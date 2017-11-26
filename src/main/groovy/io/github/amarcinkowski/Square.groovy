package io.github.amarcinkowski

import groovy.util.logging.Slf4j
import static io.github.amarcinkowski.Direction.*;

/**
 * Used to generate enum below
 */
class Generator {

    public static void main(String[] args) {
        for(int y in 1..8) {
            for(int x in 1..8) {
                println """${CoordinateUtil.x2a(x)}${y} (${CoordinateUtil.xy2n(x,y)}, [$x,$y],
                            [ /* squares in directions from ${CoordinateUtil.x2a(x)}${y}*/
                            N:${CoordinateUtil.possibleMoves(N,x,y)},
                            W:${CoordinateUtil.possibleMoves(W,x,y)},
                            S:${CoordinateUtil.possibleMoves(S,x,y)},
                            E:${CoordinateUtil.possibleMoves(E,x,y)},
                            NW:${CoordinateUtil.possibleMoves(NW,x,y)},
                            SW:${CoordinateUtil.possibleMoves(SW,x,y)},
                            SE:${CoordinateUtil.possibleMoves(SE,x,y)},
                            NE:${CoordinateUtil.possibleMoves(NE,x,y)}
                            ] as Map),
"""
            }
        }
    }
}

@Slf4j
public enum Square {

    A1 (1, [1,1],
            [ /* squares in directions from A1*/
              N:['A2', 'A3', 'A4', 'A5', 'A6', 'A7', 'A8'],
              W:[],
              S:[],
              E:['B1', 'C1', 'D1', 'E1', 'F1', 'G1', 'H1'],
              NW:[],
              SW:[],
              SE:[],
              NE:['B2', 'C3', 'D4', 'E5', 'F6', 'G7', 'H8']
            ] as Map),

    B1 (2, [2,1],
            [ /* squares in directions from B1*/
              N:['B2', 'B3', 'B4', 'B5', 'B6', 'B7', 'B8'],
              W:['A1'],
              S:[],
              E:['C1', 'D1', 'E1', 'F1', 'G1', 'H1'],
              NW:['A2'],
              SW:[],
              SE:[],
              NE:['C2', 'D3', 'E4', 'F5', 'G6', 'H7']
            ] as Map),

    C1 (3, [3,1],
            [ /* squares in directions from C1*/
              N:['C2', 'C3', 'C4', 'C5', 'C6', 'C7', 'C8'],
              W:['B1', 'A1'],
              S:[],
              E:['D1', 'E1', 'F1', 'G1', 'H1'],
              NW:['B2', 'A3'],
              SW:[],
              SE:[],
              NE:['D2', 'E3', 'F4', 'G5', 'H6']
            ] as Map),

    D1 (4, [4,1],
            [ /* squares in directions from D1*/
              N:['D2', 'D3', 'D4', 'D5', 'D6', 'D7', 'D8'],
              W:['C1', 'B1', 'A1'],
              S:[],
              E:['E1', 'F1', 'G1', 'H1'],
              NW:['C2', 'B3', 'A4'],
              SW:[],
              SE:[],
              NE:['E2', 'F3', 'G4', 'H5']
            ] as Map),

    E1 (5, [5,1],
            [ /* squares in directions from E1*/
              N:['E2', 'E3', 'E4', 'E5', 'E6', 'E7', 'E8'],
              W:['D1', 'C1', 'B1', 'A1'],
              S:[],
              E:['F1', 'G1', 'H1'],
              NW:['D2', 'C3', 'B4', 'A5'],
              SW:[],
              SE:[],
              NE:['F2', 'G3', 'H4']
            ] as Map),

    F1 (6, [6,1],
            [ /* squares in directions from F1*/
              N:['F2', 'F3', 'F4', 'F5', 'F6', 'F7', 'F8'],
              W:['E1', 'D1', 'C1', 'B1', 'A1'],
              S:[],
              E:['G1', 'H1'],
              NW:['E2', 'D3', 'C4', 'B5', 'A6'],
              SW:[],
              SE:[],
              NE:['G2', 'H3']
            ] as Map),

    G1 (7, [7,1],
            [ /* squares in directions from G1*/
              N:['G2', 'G3', 'G4', 'G5', 'G6', 'G7', 'G8'],
              W:['F1', 'E1', 'D1', 'C1', 'B1', 'A1'],
              S:[],
              E:['H1'],
              NW:['F2', 'E3', 'D4', 'C5', 'B6', 'A7'],
              SW:[],
              SE:[],
              NE:['H2']
            ] as Map),

    H1 (8, [8,1],
            [ /* squares in directions from H1*/
              N:['H2', 'H3', 'H4', 'H5', 'H6', 'H7', 'H8'],
              W:['G1', 'F1', 'E1', 'D1', 'C1', 'B1', 'A1'],
              S:[],
              E:[],
              NW:['G2', 'F3', 'E4', 'D5', 'C6', 'B7', 'A8'],
              SW:[],
              SE:[],
              NE:[]
            ] as Map),

    A2 (9, [1,2],
            [ /* squares in directions from A2*/
              N:['A3', 'A4', 'A5', 'A6', 'A7', 'A8'],
              W:[],
              S:['A1'],
              E:['B2', 'C2', 'D2', 'E2', 'F2', 'G2', 'H2'],
              NW:[],
              SW:[],
              SE:['B1'],
              NE:['B3', 'C4', 'D5', 'E6', 'F7', 'G8']
            ] as Map),

    B2 (10, [2,2],
            [ /* squares in directions from B2*/
              N:['B3', 'B4', 'B5', 'B6', 'B7', 'B8'],
              W:['A2'],
              S:['B1'],
              E:['C2', 'D2', 'E2', 'F2', 'G2', 'H2'],
              NW:['A3'],
              SW:['A1'],
              SE:['C1'],
              NE:['C3', 'D4', 'E5', 'F6', 'G7', 'H8']
            ] as Map),

    C2 (11, [3,2],
            [ /* squares in directions from C2*/
              N:['C3', 'C4', 'C5', 'C6', 'C7', 'C8'],
              W:['B2', 'A2'],
              S:['C1'],
              E:['D2', 'E2', 'F2', 'G2', 'H2'],
              NW:['B3', 'A4'],
              SW:['B1'],
              SE:['D1'],
              NE:['D3', 'E4', 'F5', 'G6', 'H7']
            ] as Map),

    D2 (12, [4,2],
            [ /* squares in directions from D2*/
              N:['D3', 'D4', 'D5', 'D6', 'D7', 'D8'],
              W:['C2', 'B2', 'A2'],
              S:['D1'],
              E:['E2', 'F2', 'G2', 'H2'],
              NW:['C3', 'B4', 'A5'],
              SW:['C1'],
              SE:['E1'],
              NE:['E3', 'F4', 'G5', 'H6']
            ] as Map),

    E2 (13, [5,2],
            [ /* squares in directions from E2*/
              N:['E3', 'E4', 'E5', 'E6', 'E7', 'E8'],
              W:['D2', 'C2', 'B2', 'A2'],
              S:['E1'],
              E:['F2', 'G2', 'H2'],
              NW:['D3', 'C4', 'B5', 'A6'],
              SW:['D1'],
              SE:['F1'],
              NE:['F3', 'G4', 'H5']
            ] as Map),

    F2 (14, [6,2],
            [ /* squares in directions from F2*/
              N:['F3', 'F4', 'F5', 'F6', 'F7', 'F8'],
              W:['E2', 'D2', 'C2', 'B2', 'A2'],
              S:['F1'],
              E:['G2', 'H2'],
              NW:['E3', 'D4', 'C5', 'B6', 'A7'],
              SW:['E1'],
              SE:['G1'],
              NE:['G3', 'H4']
            ] as Map),

    G2 (15, [7,2],
            [ /* squares in directions from G2*/
              N:['G3', 'G4', 'G5', 'G6', 'G7', 'G8'],
              W:['F2', 'E2', 'D2', 'C2', 'B2', 'A2'],
              S:['G1'],
              E:['H2'],
              NW:['F3', 'E4', 'D5', 'C6', 'B7', 'A8'],
              SW:['F1'],
              SE:['H1'],
              NE:['H3']
            ] as Map),

    H2 (16, [8,2],
            [ /* squares in directions from H2*/
              N:['H3', 'H4', 'H5', 'H6', 'H7', 'H8'],
              W:['G2', 'F2', 'E2', 'D2', 'C2', 'B2', 'A2'],
              S:['H1'],
              E:[],
              NW:['G3', 'F4', 'E5', 'D6', 'C7', 'B8'],
              SW:['G1'],
              SE:[],
              NE:[]
            ] as Map),

    A3 (17, [1,3],
            [ /* squares in directions from A3*/
              N:['A4', 'A5', 'A6', 'A7', 'A8'],
              W:[],
              S:['A2', 'A1'],
              E:['B3', 'C3', 'D3', 'E3', 'F3', 'G3', 'H3'],
              NW:[],
              SW:[],
              SE:['B2', 'C1'],
              NE:['B4', 'C5', 'D6', 'E7', 'F8']
            ] as Map),

    B3 (18, [2,3],
            [ /* squares in directions from B3*/
              N:['B4', 'B5', 'B6', 'B7', 'B8'],
              W:['A3'],
              S:['B2', 'B1'],
              E:['C3', 'D3', 'E3', 'F3', 'G3', 'H3'],
              NW:['A4'],
              SW:['A2'],
              SE:['C2', 'D1'],
              NE:['C4', 'D5', 'E6', 'F7', 'G8']
            ] as Map),

    C3 (19, [3,3],
            [ /* squares in directions from C3*/
              N:['C4', 'C5', 'C6', 'C7', 'C8'],
              W:['B3', 'A3'],
              S:['C2', 'C1'],
              E:['D3', 'E3', 'F3', 'G3', 'H3'],
              NW:['B4', 'A5'],
              SW:['B2', 'A1'],
              SE:['D2', 'E1'],
              NE:['D4', 'E5', 'F6', 'G7', 'H8']
            ] as Map),

    D3 (20, [4,3],
            [ /* squares in directions from D3*/
              N:['D4', 'D5', 'D6', 'D7', 'D8'],
              W:['C3', 'B3', 'A3'],
              S:['D2', 'D1'],
              E:['E3', 'F3', 'G3', 'H3'],
              NW:['C4', 'B5', 'A6'],
              SW:['C2', 'B1'],
              SE:['E2', 'F1'],
              NE:['E4', 'F5', 'G6', 'H7']
            ] as Map),

    E3 (21, [5,3],
            [ /* squares in directions from E3*/
              N:['E4', 'E5', 'E6', 'E7', 'E8'],
              W:['D3', 'C3', 'B3', 'A3'],
              S:['E2', 'E1'],
              E:['F3', 'G3', 'H3'],
              NW:['D4', 'C5', 'B6', 'A7'],
              SW:['D2', 'C1'],
              SE:['F2', 'G1'],
              NE:['F4', 'G5', 'H6']
            ] as Map),

    F3 (22, [6,3],
            [ /* squares in directions from F3*/
              N:['F4', 'F5', 'F6', 'F7', 'F8'],
              W:['E3', 'D3', 'C3', 'B3', 'A3'],
              S:['F2', 'F1'],
              E:['G3', 'H3'],
              NW:['E4', 'D5', 'C6', 'B7', 'A8'],
              SW:['E2', 'D1'],
              SE:['G2', 'H1'],
              NE:['G4', 'H5']
            ] as Map),

    G3 (23, [7,3],
            [ /* squares in directions from G3*/
              N:['G4', 'G5', 'G6', 'G7', 'G8'],
              W:['F3', 'E3', 'D3', 'C3', 'B3', 'A3'],
              S:['G2', 'G1'],
              E:['H3'],
              NW:['F4', 'E5', 'D6', 'C7', 'B8'],
              SW:['F2', 'E1'],
              SE:['H2'],
              NE:['H4']
            ] as Map),

    H3 (24, [8,3],
            [ /* squares in directions from H3*/
              N:['H4', 'H5', 'H6', 'H7', 'H8'],
              W:['G3', 'F3', 'E3', 'D3', 'C3', 'B3', 'A3'],
              S:['H2', 'H1'],
              E:[],
              NW:['G4', 'F5', 'E6', 'D7', 'C8'],
              SW:['G2', 'F1'],
              SE:[],
              NE:[]
            ] as Map),

    A4 (25, [1,4],
            [ /* squares in directions from A4*/
              N:['A5', 'A6', 'A7', 'A8'],
              W:[],
              S:['A3', 'A2', 'A1'],
              E:['B4', 'C4', 'D4', 'E4', 'F4', 'G4', 'H4'],
              NW:[],
              SW:[],
              SE:['B3', 'C2', 'D1'],
              NE:['B5', 'C6', 'D7', 'E8']
            ] as Map),

    B4 (26, [2,4],
            [ /* squares in directions from B4*/
              N:['B5', 'B6', 'B7', 'B8'],
              W:['A4'],
              S:['B3', 'B2', 'B1'],
              E:['C4', 'D4', 'E4', 'F4', 'G4', 'H4'],
              NW:['A5'],
              SW:['A3'],
              SE:['C3', 'D2', 'E1'],
              NE:['C5', 'D6', 'E7', 'F8']
            ] as Map),

    C4 (27, [3,4],
            [ /* squares in directions from C4*/
              N:['C5', 'C6', 'C7', 'C8'],
              W:['B4', 'A4'],
              S:['C3', 'C2', 'C1'],
              E:['D4', 'E4', 'F4', 'G4', 'H4'],
              NW:['B5', 'A6'],
              SW:['B3', 'A2'],
              SE:['D3', 'E2', 'F1'],
              NE:['D5', 'E6', 'F7', 'G8']
            ] as Map),

    D4 (28, [4,4],
            [ /* squares in directions from D4*/
              N:['D5', 'D6', 'D7', 'D8'],
              W:['C4', 'B4', 'A4'],
              S:['D3', 'D2', 'D1'],
              E:['E4', 'F4', 'G4', 'H4'],
              NW:['C5', 'B6', 'A7'],
              SW:['C3', 'B2', 'A1'],
              SE:['E3', 'F2', 'G1'],
              NE:['E5', 'F6', 'G7', 'H8']
            ] as Map),

    E4 (29, [5,4],
            [ /* squares in directions from E4*/
              N:['E5', 'E6', 'E7', 'E8'],
              W:['D4', 'C4', 'B4', 'A4'],
              S:['E3', 'E2', 'E1'],
              E:['F4', 'G4', 'H4'],
              NW:['D5', 'C6', 'B7', 'A8'],
              SW:['D3', 'C2', 'B1'],
              SE:['F3', 'G2', 'H1'],
              NE:['F5', 'G6', 'H7']
            ] as Map),

    F4 (30, [6,4],
            [ /* squares in directions from F4*/
              N:['F5', 'F6', 'F7', 'F8'],
              W:['E4', 'D4', 'C4', 'B4', 'A4'],
              S:['F3', 'F2', 'F1'],
              E:['G4', 'H4'],
              NW:['E5', 'D6', 'C7', 'B8'],
              SW:['E3', 'D2', 'C1'],
              SE:['G3', 'H2'],
              NE:['G5', 'H6']
            ] as Map),

    G4 (31, [7,4],
            [ /* squares in directions from G4*/
              N:['G5', 'G6', 'G7', 'G8'],
              W:['F4', 'E4', 'D4', 'C4', 'B4', 'A4'],
              S:['G3', 'G2', 'G1'],
              E:['H4'],
              NW:['F5', 'E6', 'D7', 'C8'],
              SW:['F3', 'E2', 'D1'],
              SE:['H3'],
              NE:['H5']
            ] as Map),

    H4 (32, [8,4],
            [ /* squares in directions from H4*/
              N:['H5', 'H6', 'H7', 'H8'],
              W:['G4', 'F4', 'E4', 'D4', 'C4', 'B4', 'A4'],
              S:['H3', 'H2', 'H1'],
              E:[],
              NW:['G5', 'F6', 'E7', 'D8'],
              SW:['G3', 'F2', 'E1'],
              SE:[],
              NE:[]
            ] as Map),

    A5 (33, [1,5],
            [ /* squares in directions from A5*/
              N:['A6', 'A7', 'A8'],
              W:[],
              S:['A4', 'A3', 'A2', 'A1'],
              E:['B5', 'C5', 'D5', 'E5', 'F5', 'G5', 'H5'],
              NW:[],
              SW:[],
              SE:['B4', 'C3', 'D2', 'E1'],
              NE:['B6', 'C7', 'D8']
            ] as Map),

    B5 (34, [2,5],
            [ /* squares in directions from B5*/
              N:['B6', 'B7', 'B8'],
              W:['A5'],
              S:['B4', 'B3', 'B2', 'B1'],
              E:['C5', 'D5', 'E5', 'F5', 'G5', 'H5'],
              NW:['A6'],
              SW:['A4'],
              SE:['C4', 'D3', 'E2', 'F1'],
              NE:['C6', 'D7', 'E8']
            ] as Map),

    C5 (35, [3,5],
            [ /* squares in directions from C5*/
              N:['C6', 'C7', 'C8'],
              W:['B5', 'A5'],
              S:['C4', 'C3', 'C2', 'C1'],
              E:['D5', 'E5', 'F5', 'G5', 'H5'],
              NW:['B6', 'A7'],
              SW:['B4', 'A3'],
              SE:['D4', 'E3', 'F2', 'G1'],
              NE:['D6', 'E7', 'F8']
            ] as Map),

    D5 (36, [4,5],
            [ /* squares in directions from D5*/
              N:['D6', 'D7', 'D8'],
              W:['C5', 'B5', 'A5'],
              S:['D4', 'D3', 'D2', 'D1'],
              E:['E5', 'F5', 'G5', 'H5'],
              NW:['C6', 'B7', 'A8'],
              SW:['C4', 'B3', 'A2'],
              SE:['E4', 'F3', 'G2', 'H1'],
              NE:['E6', 'F7', 'G8']
            ] as Map),

    E5 (37, [5,5],
            [ /* squares in directions from E5*/
              N:['E6', 'E7', 'E8'],
              W:['D5', 'C5', 'B5', 'A5'],
              S:['E4', 'E3', 'E2', 'E1'],
              E:['F5', 'G5', 'H5'],
              NW:['D6', 'C7', 'B8'],
              SW:['D4', 'C3', 'B2', 'A1'],
              SE:['F4', 'G3', 'H2'],
              NE:['F6', 'G7', 'H8']
            ] as Map),

    F5 (38, [6,5],
            [ /* squares in directions from F5*/
              N:['F6', 'F7', 'F8'],
              W:['E5', 'D5', 'C5', 'B5', 'A5'],
              S:['F4', 'F3', 'F2', 'F1'],
              E:['G5', 'H5'],
              NW:['E6', 'D7', 'C8'],
              SW:['E4', 'D3', 'C2', 'B1'],
              SE:['G4', 'H3'],
              NE:['G6', 'H7']
            ] as Map),

    G5 (39, [7,5],
            [ /* squares in directions from G5*/
              N:['G6', 'G7', 'G8'],
              W:['F5', 'E5', 'D5', 'C5', 'B5', 'A5'],
              S:['G4', 'G3', 'G2', 'G1'],
              E:['H5'],
              NW:['F6', 'E7', 'D8'],
              SW:['F4', 'E3', 'D2', 'C1'],
              SE:['H4'],
              NE:['H6']
            ] as Map),

    H5 (40, [8,5],
            [ /* squares in directions from H5*/
              N:['H6', 'H7', 'H8'],
              W:['G5', 'F5', 'E5', 'D5', 'C5', 'B5', 'A5'],
              S:['H4', 'H3', 'H2', 'H1'],
              E:[],
              NW:['G6', 'F7', 'E8'],
              SW:['G4', 'F3', 'E2', 'D1'],
              SE:[],
              NE:[]
            ] as Map),

    A6 (41, [1,6],
            [ /* squares in directions from A6*/
              N:['A7', 'A8'],
              W:[],
              S:['A5', 'A4', 'A3', 'A2', 'A1'],
              E:['B6', 'C6', 'D6', 'E6', 'F6', 'G6', 'H6'],
              NW:[],
              SW:[],
              SE:['B5', 'C4', 'D3', 'E2', 'F1'],
              NE:['B7', 'C8']
            ] as Map),

    B6 (42, [2,6],
            [ /* squares in directions from B6*/
              N:['B7', 'B8'],
              W:['A6'],
              S:['B5', 'B4', 'B3', 'B2', 'B1'],
              E:['C6', 'D6', 'E6', 'F6', 'G6', 'H6'],
              NW:['A7'],
              SW:['A5'],
              SE:['C5', 'D4', 'E3', 'F2', 'G1'],
              NE:['C7', 'D8']
            ] as Map),

    C6 (43, [3,6],
            [ /* squares in directions from C6*/
              N:['C7', 'C8'],
              W:['B6', 'A6'],
              S:['C5', 'C4', 'C3', 'C2', 'C1'],
              E:['D6', 'E6', 'F6', 'G6', 'H6'],
              NW:['B7', 'A8'],
              SW:['B5', 'A4'],
              SE:['D5', 'E4', 'F3', 'G2', 'H1'],
              NE:['D7', 'E8']
            ] as Map),

    D6 (44, [4,6],
            [ /* squares in directions from D6*/
              N:['D7', 'D8'],
              W:['C6', 'B6', 'A6'],
              S:['D5', 'D4', 'D3', 'D2', 'D1'],
              E:['E6', 'F6', 'G6', 'H6'],
              NW:['C7', 'B8'],
              SW:['C5', 'B4', 'A3'],
              SE:['E5', 'F4', 'G3', 'H2'],
              NE:['E7', 'F8']
            ] as Map),

    E6 (45, [5,6],
            [ /* squares in directions from E6*/
              N:['E7', 'E8'],
              W:['D6', 'C6', 'B6', 'A6'],
              S:['E5', 'E4', 'E3', 'E2', 'E1'],
              E:['F6', 'G6', 'H6'],
              NW:['D7', 'C8'],
              SW:['D5', 'C4', 'B3', 'A2'],
              SE:['F5', 'G4', 'H3'],
              NE:['F7', 'G8']
            ] as Map),

    F6 (46, [6,6],
            [ /* squares in directions from F6*/
              N:['F7', 'F8'],
              W:['E6', 'D6', 'C6', 'B6', 'A6'],
              S:['F5', 'F4', 'F3', 'F2', 'F1'],
              E:['G6', 'H6'],
              NW:['E7', 'D8'],
              SW:['E5', 'D4', 'C3', 'B2', 'A1'],
              SE:['G5', 'H4'],
              NE:['G7', 'H8']
            ] as Map),

    G6 (47, [7,6],
            [ /* squares in directions from G6*/
              N:['G7', 'G8'],
              W:['F6', 'E6', 'D6', 'C6', 'B6', 'A6'],
              S:['G5', 'G4', 'G3', 'G2', 'G1'],
              E:['H6'],
              NW:['F7', 'E8'],
              SW:['F5', 'E4', 'D3', 'C2', 'B1'],
              SE:['H5'],
              NE:['H7']
            ] as Map),

    H6 (48, [8,6],
            [ /* squares in directions from H6*/
              N:['H7', 'H8'],
              W:['G6', 'F6', 'E6', 'D6', 'C6', 'B6', 'A6'],
              S:['H5', 'H4', 'H3', 'H2', 'H1'],
              E:[],
              NW:['G7', 'F8'],
              SW:['G5', 'F4', 'E3', 'D2', 'C1'],
              SE:[],
              NE:[]
            ] as Map),

    A7 (49, [1,7],
            [ /* squares in directions from A7*/
              N:['A8'],
              W:[],
              S:['A6', 'A5', 'A4', 'A3', 'A2', 'A1'],
              E:['B7', 'C7', 'D7', 'E7', 'F7', 'G7', 'H7'],
              NW:[],
              SW:[],
              SE:['B6', 'C5', 'D4', 'E3', 'F2', 'G1'],
              NE:['B8']
            ] as Map),

    B7 (50, [2,7],
            [ /* squares in directions from B7*/
              N:['B8'],
              W:['A7'],
              S:['B6', 'B5', 'B4', 'B3', 'B2', 'B1'],
              E:['C7', 'D7', 'E7', 'F7', 'G7', 'H7'],
              NW:['A8'],
              SW:['A6'],
              SE:['C6', 'D5', 'E4', 'F3', 'G2', 'H1'],
              NE:['C8']
            ] as Map),

    C7 (51, [3,7],
            [ /* squares in directions from C7*/
              N:['C8'],
              W:['B7', 'A7'],
              S:['C6', 'C5', 'C4', 'C3', 'C2', 'C1'],
              E:['D7', 'E7', 'F7', 'G7', 'H7'],
              NW:['B8'],
              SW:['B6', 'A5'],
              SE:['D6', 'E5', 'F4', 'G3', 'H2'],
              NE:['D8']
            ] as Map),

    D7 (52, [4,7],
            [ /* squares in directions from D7*/
              N:['D8'],
              W:['C7', 'B7', 'A7'],
              S:['D6', 'D5', 'D4', 'D3', 'D2', 'D1'],
              E:['E7', 'F7', 'G7', 'H7'],
              NW:['C8'],
              SW:['C6', 'B5', 'A4'],
              SE:['E6', 'F5', 'G4', 'H3'],
              NE:['E8']
            ] as Map),

    E7 (53, [5,7],
            [ /* squares in directions from E7*/
              N:['E8'],
              W:['D7', 'C7', 'B7', 'A7'],
              S:['E6', 'E5', 'E4', 'E3', 'E2', 'E1'],
              E:['F7', 'G7', 'H7'],
              NW:['D8'],
              SW:['D6', 'C5', 'B4', 'A3'],
              SE:['F6', 'G5', 'H4'],
              NE:['F8']
            ] as Map),

    F7 (54, [6,7],
            [ /* squares in directions from F7*/
              N:['F8'],
              W:['E7', 'D7', 'C7', 'B7', 'A7'],
              S:['F6', 'F5', 'F4', 'F3', 'F2', 'F1'],
              E:['G7', 'H7'],
              NW:['E8'],
              SW:['E6', 'D5', 'C4', 'B3', 'A2'],
              SE:['G6', 'H5'],
              NE:['G8']
            ] as Map),

    G7 (55, [7,7],
            [ /* squares in directions from G7*/
              N:['G8'],
              W:['F7', 'E7', 'D7', 'C7', 'B7', 'A7'],
              S:['G6', 'G5', 'G4', 'G3', 'G2', 'G1'],
              E:['H7'],
              NW:['F8'],
              SW:['F6', 'E5', 'D4', 'C3', 'B2', 'A1'],
              SE:['H6'],
              NE:['H8']
            ] as Map),

    H7 (56, [8,7],
            [ /* squares in directions from H7*/
              N:['H8'],
              W:['G7', 'F7', 'E7', 'D7', 'C7', 'B7', 'A7'],
              S:['H6', 'H5', 'H4', 'H3', 'H2', 'H1'],
              E:[],
              NW:['G8'],
              SW:['G6', 'F5', 'E4', 'D3', 'C2', 'B1'],
              SE:[],
              NE:[]
            ] as Map),

    A8 (57, [1,8],
            [ /* squares in directions from A8*/
              N:[],
              W:[],
              S:['A7', 'A6', 'A5', 'A4', 'A3', 'A2', 'A1'],
              E:['B8', 'C8', 'D8', 'E8', 'F8', 'G8', 'H8'],
              NW:[],
              SW:[],
              SE:['B7', 'C6', 'D5', 'E4', 'F3', 'G2', 'H1'],
              NE:[]
            ] as Map),

    B8 (58, [2,8],
            [ /* squares in directions from B8*/
              N:[],
              W:['A8'],
              S:['B7', 'B6', 'B5', 'B4', 'B3', 'B2', 'B1'],
              E:['C8', 'D8', 'E8', 'F8', 'G8', 'H8'],
              NW:[],
              SW:['A7'],
              SE:['C7', 'D6', 'E5', 'F4', 'G3', 'H2'],
              NE:[]
            ] as Map),

    C8 (59, [3,8],
            [ /* squares in directions from C8*/
              N:[],
              W:['B8', 'A8'],
              S:['C7', 'C6', 'C5', 'C4', 'C3', 'C2', 'C1'],
              E:['D8', 'E8', 'F8', 'G8', 'H8'],
              NW:[],
              SW:['B7', 'A6'],
              SE:['D7', 'E6', 'F5', 'G4', 'H3'],
              NE:[]
            ] as Map),

    D8 (60, [4,8],
            [ /* squares in directions from D8*/
              N:[],
              W:['C8', 'B8', 'A8'],
              S:['D7', 'D6', 'D5', 'D4', 'D3', 'D2', 'D1'],
              E:['E8', 'F8', 'G8', 'H8'],
              NW:[],
              SW:['C7', 'B6', 'A5'],
              SE:['E7', 'F6', 'G5', 'H4'],
              NE:[]
            ] as Map),

    E8 (61, [5,8],
            [ /* squares in directions from E8*/
              N:[],
              W:['D8', 'C8', 'B8', 'A8'],
              S:['E7', 'E6', 'E5', 'E4', 'E3', 'E2', 'E1'],
              E:['F8', 'G8', 'H8'],
              NW:[],
              SW:['D7', 'C6', 'B5', 'A4'],
              SE:['F7', 'G6', 'H5'],
              NE:[]
            ] as Map),

    F8 (62, [6,8],
            [ /* squares in directions from F8*/
              N:[],
              W:['E8', 'D8', 'C8', 'B8', 'A8'],
              S:['F7', 'F6', 'F5', 'F4', 'F3', 'F2', 'F1'],
              E:['G8', 'H8'],
              NW:[],
              SW:['E7', 'D6', 'C5', 'B4', 'A3'],
              SE:['G7', 'H6'],
              NE:[]
            ] as Map),

    G8 (63, [7,8],
            [ /* squares in directions from G8*/
              N:[],
              W:['F8', 'E8', 'D8', 'C8', 'B8', 'A8'],
              S:['G7', 'G6', 'G5', 'G4', 'G3', 'G2', 'G1'],
              E:['H8'],
              NW:[],
              SW:['F7', 'E6', 'D5', 'C4', 'B3', 'A2'],
              SE:['H7'],
              NE:[]
            ] as Map),

    H8 (64, [8,8],
            [ /* squares in directions from H8*/
              N:[],
              W:['G8', 'F8', 'E8', 'D8', 'C8', 'B8', 'A8'],
              S:['H7', 'H6', 'H5', 'H4', 'H3', 'H2', 'H1'],
              E:[],
              NW:[],
              SW:['G7', 'F6', 'E5', 'D4', 'C3', 'B2', 'A1'],
              SE:[],
              NE:[]
            ] as Map),


    public int n
    public int x
    public int y

    private Square(int n, ArrayList<Integer> xy, Map<Direction,String> map) {
        this.n = n
        this.x = xy[0]
        this.y = xy[1]
    }

    @Override
    String toString() {
        name()
    }
}
