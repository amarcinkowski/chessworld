package io.github.amarcinkowski

import groovy.util.logging.Slf4j


/**
 * Used to generate enum below
 */
class Generator {
    public static void main(String[] args) {
        int n = 0
        for (int i in 1..8) {
            println ""
            for (char c in 'A'..'H') {
                print "$c$i(${++n}, [${(int) c - (int) 'A' + 1}, $i]), "
            }
        }
        println Square1.values().toString()
    }
}

@Slf4j
enum Square1 {
    A1(1, [1, 1]), B1(2, [2, 1]), C1(3, [3, 1]), D1(4, [4, 1]), E1(5, [5, 1]), F1(6, [6, 1]), G1(7, [7, 1]), H1(8, [8, 1]),
    A2(9, [1, 2]), B2(10, [2, 2]), C2(11, [3, 2]), D2(12, [4, 2]), E2(13, [5, 2]), F2(14, [6, 2]), G2(15, [7, 2]), H2(16, [8, 2]),
    A3(17, [1, 3]), B3(18, [2, 3]), C3(19, [3, 3]), D3(20, [4, 3]), E3(21, [5, 3]), F3(22, [6, 3]), G3(23, [7, 3]), H3(24, [8, 3]),
    A4(25, [1, 4]), B4(26, [2, 4]), C4(27, [3, 4]), D4(28, [4, 4]), E4(29, [5, 4]), F4(30, [6, 4]), G4(31, [7, 4]), H4(32, [8, 4]),
    A5(33, [1, 5]), B5(34, [2, 5]), C5(35, [3, 5]), D5(36, [4, 5]), E5(37, [5, 5]), F5(38, [6, 5]), G5(39, [7, 5]), H5(40, [8, 5]),
    A6(41, [1, 6]), B6(42, [2, 6]), C6(43, [3, 6]), D6(44, [4, 6]), E6(45, [5, 6]), F6(46, [6, 6]), G6(47, [7, 6]), H6(48, [8, 6]),
    A7(49, [1, 7]), B7(50, [2, 7]), C7(51, [3, 7]), D7(52, [4, 7]), E7(53, [5, 7]), F7(54, [6, 7]), G7(55, [7, 7]), H7(56, [8, 7]),
    A8(57, [1, 8]), B8(58, [2, 8]), C8(59, [3, 8]), D8(60, [4, 8]), E8(61, [5, 8]), F8(62, [6, 8]), G8(63, [7, 8]), H8(64, [8, 8])

    public int n
    public int x
    public int y

    private Square1(int n, ArrayList<Integer> xy) {
        this.n = n
        this.x = xy[0]
        this.y = xy[1]
    }

    @Override
    String toString() {
        name()
    }
}
