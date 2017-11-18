package io.github.amarcinkowski

import java.util.function.Predicate

/**
 * Created by am on 15.11.17.
 */
class Board {
    def squares = new Square[64]
    List<Piece> pieces = []

    def createBoard() {
        char col = 'a'
        for (int i = 0; i < 64; i += 8) {
            for (int j = 0; j < 8; j++) {
                squares[i + j] = new Square(column: col, row: j + 1)
            }
            col++;
        }
    }

    Predicate<Piece> half = { it.square > 16 }

    def addPieces() {
        def cloned = new Piece(color: Color.WHITE)
        for (int i = 0; i < 32; i++) {
            pieces += cloned.clone()
            pieces.get(i).square = i + 1
            pieces.get(i).type = i > 15 ?
                    Arrangment.pieces.get(Math.abs(31 - i) % 16) :
                    Arrangment.pieces.get(i % 16)
        }
        def setBlack = {
            p -> p.color = Color.BLACK;
        }
        def moveBlack = {
            p -> p.move(0, 4)
        }
        pieces.findAll { p -> p.square > 16 }.forEach(setBlack)
        pieces.findAll { p -> p.square > 16 }.forEach(moveBlack)
        pieces.find { p -> p.color == Color.BLACK && p.type == PieceType.KING }.square += 1
        pieces.find { p -> p.color == Color.BLACK && p.type == PieceType.QUEEN }.square -= 1
    }

    Board() {
        createBoard()
        addPieces()
    }

    @Override
    String toString() {
        def board = new Piece[64] as List<Piece>
        for (int i = 0; i < pieces.size(); i++) {
            board.set(pieces.get(i).square - 1, pieces.get(i))
        }
        def result = ""
        for (int i = 1; i < 9; i++) {
            result += board.takeRight(8 * i).take(8).join(" ").replaceAll('null', '_') + System.getProperty("line.separator")
        }
        return result
    }
}
