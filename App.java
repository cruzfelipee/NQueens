public class App {
    public static final int SIZE = 15;

    public static void main(String[] args) {
        Board board = new Board(SIZE);
        int solutions = 0;

        for (int i = 0; i < SIZE; i++) {
            solutions += solve(0, i, board);
            System.out.println("solved " + (i + 1) + "/" + SIZE);
        }

        System.out.println("Found " + solutions / 4 + " unique solutions");
    }

    public static int solve(int x, int y, Board board) {
        if (x >= board.getBoardSize()) {
            //System.out.println("Solution:");
            //System.out.println(board.toString());
            return 1;
        }

        if (!board.isPositionValid(x, y)) return 0;

        if (!board.isQueenValid(x, y)) return 0;

        int solutions = 0;

        board.setPosition(x, y, true);

        for (int i = 0; i < board.getBoardSize(); i ++)
            solutions += solve(x + 1, i, board);

        board.setPosition(x, y, false);

        return solutions;
    }
}