package simulation;

import model.GameState;

import java.util.LinkedList;
import java.util.List;
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
