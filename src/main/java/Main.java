import simulation.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Game game2 = new Game();
        Game game3 = new Game();
        new Thread(game).start();
    }
}
