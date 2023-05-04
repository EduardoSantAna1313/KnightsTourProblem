public class App {
    public static void main(final String[] args) throws Exception {

        Chezzboard board = new Chezzboard();

        var game = new KnightsTour(board);

        while (game.hasNextRound()) {
            clearTerminal();

            System.out.println("\t\t### Round " + game.getRound() + " ###\n");
            game.nextRound();

            board.printBoard();

            //Thread.sleep(1000);
        }
    }

    private static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
