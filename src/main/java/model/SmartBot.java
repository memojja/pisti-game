package model;

import org.apache.log4j.Logger;

import java.util.List;

public class SmartBot extends Player {

  private final static Logger logger = Logger.getLogger(String.valueOf(SmartBot.class));

    public SmartBot(int index, String gameName) {
        super(index,gameName);
    }

    @Override
    public Card logic(GameState gameState) {
        List<Card> discardedCards = gameState.getDiscardedCards();
        List<Card> myCards = gameState.getPlayersCards().get(getIndex());
        Card card = null;
        for (Card myCard : myCards) {
            if (myCard.getNumber().equals(discardedCards.get(discardedCards.size() - 1).getNumber())) {
                card = myCard;
                break;
            }
            if (myCard.getNumber().equals(Value.JACK)) {
                card = myCard;
            }
        }
        //send logical card if there is a discarded card if not send random.

        card = getCardIfPlayerHasDiscardedCard(discardedCards, myCards, card);

        logger.debug(gameState.getGameName() + " " + "Player " + getIndex() + " played " + card);
        return card;
    }


    private Card getCardIfPlayerHasDiscardedCard(List<Card> discardedCards, List<Card> myCards, Card card) {
        if(card == null){
            for (int i = 0; i < discardedCards.size()-1; i++) {
                for (int j = 0; j < myCards.size(); j++) {
                    if(discardedCards.get(i).equals(myCards.get(j))){
                        card = myCards.get(j);
                        return card;
                    }
                }
            }
        }
      card = card != null ?  card : myCards.get(GameState.random.nextInt(myCards.size()));
      return card;
    }

}
