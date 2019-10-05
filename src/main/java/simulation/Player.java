package simulation;

import model.Card;
import model.GameState;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int index;
    private int point;

    public Player(int index){
        this.index = index;
        this.point = 0;
    }


    public void play(GameState gameState) {

    }


    public void addPoint(int point){
        this.point+=point;
    }

    public void discardCard(){

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
