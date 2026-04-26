package io.github.amarcinkowski.chess.game

import io.github.amarcinkowski.chess.board.Board

class Game {

    Player white
    Player black
    Board board
    boolean whiteNext = true
    List<io.github.amarcinkowski.chess.board.move.Move> history = []

    Game() {
        board = new Board()
    }

    public static void main(String[] args) {
        io.github.amarcinkowski.chess.message.Message.language('en-US')
        Game game = new Game()
        System.out.println("Welcome to chessworld!")
        System.out.println(game.board.toString())

        Scanner scanner = new Scanner(System.in)
        while (true) {
            String color = game.whiteNext ? "White" : "Black"
            System.out.print(color + "'s move (e.g. e2-e4) [or 'exit' to quit]: ")
            if (!scanner.hasNextLine()) break
            String input = scanner.nextLine().trim()
            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                break
            }

            def parts = input.split("-")
            if (parts.length != 2) {
                System.out.println("Invalid format. Try e.g., e2-e4")
                continue
            }
            try {
                def fromSq = io.github.amarcinkowski.chess.board.Square.valueOf(parts[0].toUpperCase())
                def toSq = io.github.amarcinkowski.chess.board.Square.valueOf(parts[1].toUpperCase())

                def move = new io.github.amarcinkowski.chess.board.move.Move(board: game.board, from: fromSq, to: toSq)

                // Optional: ensure correct turn (white moves white pieces)
                def piece = game.board.getPiece(fromSq)
                if (piece == null) {
                    System.out.println("No piece at " + parts[0])
                    continue
                }
                boolean isWhitePiece = piece.color == io.github.amarcinkowski.chess.board.Side.WHITE
                if (game.whiteNext != isWhitePiece) {
                    System.out.println("It's " + color + "'s turn!")
                    continue
                }

                if (move.isValid()) {
                    game.board.applyMove(fromSq, toSq)
                    game.history.add(move)
                    game.whiteNext = !game.whiteNext
                    System.out.println(game.board.toString())
                } else {
                    System.out.println("Invalid move.")
                }
            } catch (Exception e) {
                System.out.println("Error parsing move. Make sure fields are valid (e.g. e2-e4) " + e.getMessage())
                e.printStackTrace()
            }
        }
    }

}
