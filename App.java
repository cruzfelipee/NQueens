public class App {
    public static boolean logs = false;

    public static void main(String[] args) {
        long st = System.currentTimeMillis();

        int size = 8; // Default value
        boolean showProgress = false;

        for (String arg : args) {
            if (arg.startsWith("--size=")) {
                size = Integer.parseInt(arg.substring("--size=".length()));
            } else if (arg.equals("--log")) {
                logs = true;
            } else if (arg.equals("--show-progress")) {
                showProgress = true;
            }
        }

        Board board = new Board(size);
        int solutions = 0;

        for (int i = 0; i < size; i++) {
            solutions += solve(0, i, board);
            if (showProgress) {
                System.out.println("solved " + (i + 1) + "/" + size);
            }
        }

        System.out.println("Found " + solutions + " unique solutions after " + (System.currentTimeMillis() - st)/1000 + "s");
    }

    public static int solve(int x, int y, Board board) {
        if (!board.isPositionValid(x, y)) return 0;

        if (!board.isQueenValid(x, y)) return 0;

        board.setPosition(x, y, true);

        if (x == board.getBoardSize() - 1) {
            if (logs) {
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