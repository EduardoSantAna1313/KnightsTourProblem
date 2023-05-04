public class Chezzboard {

    private final Integer[][] board;

    public Chezzboard() {
        board = new Integer[8][8];
    }

    public void printBoard() {
        for (var i = 0; i < 8; i++) {
            for (var j = 0; j < 8; j++) {
                System.out.printf("%d\t", board[i][j] == null ? 0 : board[i][j]);
            }
            System.out.println();
        }
    }

    public Integer getPosition(int x, int y) {
        return board[x][y];
    }

    public void updatePosition(int x, int y, int value) {
        board[x][y] = value;
    }

}
