package model;

import rule.PointChain;
import service.GameService;
import util.GenericCardUtil;
import java.util.List;

/**
 *
 * Uses the Template Pattern so all players have same actions. only difference is brain
 */
public abstract class Player implements BrainTemplate {

    private int index;
    private int point;
    private int sizeCollectedCard;
    private GameService gameService;

    public Player(int index){
        this.index = index;
        this.point = 0;
        gameService = new GameService();
    }

    public void play(GameState gameState) {
        List<Card> myCards = gameState.getPlayersCards().get(index);
        List<Card> discardedCards = gameState.getDiscardedCards();

        Card card = logic(gameState);
        discardCard(myCards, discardedCards, card);

        gameService.calculateUserPoint(gameState,discardedCards,this,false);
    }

    private void discardCard(List<Card> myCards, List<Card> discardedCards, Card card) {
        discardedCards.add(new CardWithFacingUp(card));
        myCards.remove(card);
    }

    public void addPoint(int point){
        this.point+=point;
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

    public int getSizeCollectedCard() {
        return sizeCollectedCard;
    }

    public void setSizeCollectedCard(int sizeCollectedCard) {
        this.sizeCollectedCard = sizeCollectedCard;
    }
}
