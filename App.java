public class App {
    public static void main(String[] args) {
        Board board = new Board(4);

        for (int i = 0; i < 4; i++) {
            solve(0, i, board);
            System.out.println("solved " + i + "/4");
        }
    }

    public static void solve(int x, int y, Board board) {
        if (x >= board.getBoardSize()) {
            System.out.println(board.toString());
        }
        if (!board.isPositionValid(x, y)) return;
        if (!board.isQueenValid(x, y)) return;
    
        board.setPosition(x, y, true);

        for (int i = 0; i < board.getBoardSize(); i ++) {
            solve(x + 1, i, board);
        }

        board.setPosition(x, y, false);
    }
}