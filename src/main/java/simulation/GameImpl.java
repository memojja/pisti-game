package simulation;

import model.GameState;
import model.Player;

import java.util.stream.IntStream;

public class GameImpl implements Game {
    private Player[] players;
    private GameState gameState;


    public GameImpl(){
        players = new Player[4];
        IntStream.range(0,4).forEach(i -> players[i] = new Player(i));
        gameState = new GameState();

    }


    void play(){

        while (!gameState.isFinished()){

            int turn = gameState.getTurn();
            Player player = players[turn];
            player.play(gameState);
            gameState.incrementTurn();

        }

    }


    @Override
    public void createGame() {

    }
}
