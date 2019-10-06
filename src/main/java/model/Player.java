package model;

import service.GameService;

import java.util.List;

/**
 *
 * Uses the Template Pattern so all players have same actions. only difference is brain
 */
public abstract class Player implements BrainTemplate {

    private int index;
    private int point;
    private int sizeCollectedCard;
    private String gameName;
    private GameService gameService;

    public Player(int index,String gameName){
        this.index = index;
        this.point = 0;
        gameService = new GameService();
        this.gameName = gameName;
    }

    public void play(GameState gameState) {
        List<Card> myCards = gameState.getPlayersCards().get(index);
        List<Card> discardedCards = gameState.getDiscardedCards();

        Card card = logic(gameState);

        discardCard(myCards, discardedCards, card);

        gameService.calculateUserPoint(gameState,discardedCards,this,false);
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

    public String getGameName() {
        return gameName;
    }

    private void discardCard(List<Card> myCards, List<Card> discardedCards, Card card) {
        discardedCards.add(new CardWithFacingUp(card));
        myCards.remove(card);
    }

}
