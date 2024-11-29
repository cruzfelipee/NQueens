public class Board {
    public boolean[][] board;

    public Board(int size) {
        this.board = new boolean[size][size];
    }

    // if in bounds
    public boolean isPositionValid(int x, int y) {
        return x >= 0 && y >= 0 && x < board.length && y < board.length;
    }

    // checks if queen doesnt see other queens in any direction
    public boolean isQueenValid(int x, int y) {
        for (int dx = -1; dx <= 1; dx++)
            for (int dy = -1; dy <= 1; dy++)
                if ((dy != 0 || dx != 0) && raycast(x + dx, y + dy, dx, dy))
                    return false;

        return true;
    }

    // recursively walks in a direction until it finds a queen
    public boolean raycast(int sx, int sy, int dx, int dy) {
        if (!isPositionValid(sx, sy)) {return false;}
        if (this.board[sx][sy]) {return true;}

        return raycast(sx + dx, sy + dy, dx, dy);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j] ? 'Q' : ' ');
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