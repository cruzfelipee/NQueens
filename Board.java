public class Board {
    public boolean[][] board;

    public Board(int size) {
        this.board = new boolean[size][size];
    }

    // if in bounds
    public boolean isPositionValid(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board.length;
    }

    public boolean isQueenValid(int x, int y)   {
        if (!this.board[x][y]) return true; // empty squares are always valid 

        for (int dx = -1; dx <= 1; dx++) //if queen doesnt see other queen
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
                sb.append(' ');
            }

            sb.append("\n");
        }

        return sb.toString();
    }

    public int getBoardSize() {
        return board.length;
    }

    public boolean getPosition(int x, int y) {
        return board[x][y];
    }

    public void setPosition(int x, int y, boolean v) {
        board[x][y] = v;
    }
}