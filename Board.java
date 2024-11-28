public class Board {
    public boolean[][] board;

    public Board(int size) {
        this.board = new boolean[size][size];
    }

    public boolean isPositionValid(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board.length;
    }

    public boolean isQueenValid(int x, int y)   {
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++)
                if (raycast(x, y, dx, dy))
                    return false;

        return true;
    }

    public boolean raycast(int sx, int sy, int dx, int dy) {
        if (!isPositionValid(sx, sy)) return false;
        if (this.board[sx][sy]) return true;
        return raycast(sx + dx, sy + dy, dx, dy);
    }
}