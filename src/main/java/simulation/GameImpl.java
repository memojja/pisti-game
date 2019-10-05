package simulation;

import model.GameState;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameImpl implements Game {
    private List<Player> players;
    private GameState gameState;


    public GameImpl(){
        players = new LinkedList<>();
        gameState = new GameState();
    }


    void play(){
        int turn = gameState.getTurn();
        Player player = players.get(turn);
        player.play(gameState);

    }


    @Override
    public void createGame() {

    }
}
