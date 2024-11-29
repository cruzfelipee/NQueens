public class App {
    public static final boolean PRINTS = false;
    public static final int SIZE = 8;

    public static void main(String[] args) {
        long st = System.currentTimeMillis();

        Board board = new Board(SIZE);
        int solutions = 0;

        for (int i = 0; i < SIZE; i++) {
            solutions += solve(0, i, board);
            System.out.println("solved " + (i + 1) + "/" + SIZE);
        }

        System.out.println("Found " + solutions + " unique solutions after " + (System.currentTimeMillis() - st)/1000 + "s");
    }

    public static int solve(int x, int y, Board board) {
        if (!board.isPositionValid(x, y)) return 0;

        if (!board.isQueenValid(x, y)) return 0;

        board.setPosition(x, y, true);

        if (x == board.getBoardSize() - 1) {
            if (PRINTS) {
                System.err.println("Solution:");
                System.out.println(board);
                System.err.println();
            }

            board.setPosition(x, y, false);

            return 1;
        }

        int solutions = 0;

        for (int i = 0; i < board.getBoardSize(); i ++) {
            if (i == y) continue; // queens can't be in the same column

            solutions += solve(x + 1, i, board);
        }

        board.setPosition(x, y, false);

        return solutions;
    }
}