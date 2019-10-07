import simulation.Game;

public class Main {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int K = Integer.parseInt(args[1]);

            for (int j = 0; j < K; j++) {
                new Thread(new Game()).start();

            }



    }
}
