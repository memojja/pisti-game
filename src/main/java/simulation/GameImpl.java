package simulation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameImpl implements Game {
    private List<Player> players;

    public GameImpl(){
        players = new LinkedList<>();
    }


    @Override
    public void createGame() {

    }
}
