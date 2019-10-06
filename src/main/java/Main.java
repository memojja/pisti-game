import simulation.GameImpl;

public class Main {
    public static void main(String[] args) {
        GameImpl game = new GameImpl();
        GameImpl game2 = new GameImpl();
        GameImpl game3 = new GameImpl();
        new Thread(game).start();
        new Thread(game2).start();
        new Thread(game3).start();
    }
}
