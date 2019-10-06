package rule;

import model.Card;
import model.Suit;
import model.Value;
import org.apache.log4j.Logger;
import model.Player;

public class ClubTwoProcessor implements PointChain {

    private final static Logger logger = Logger.getLogger(String.valueOf(ClubTwoProcessor.class));

    private PointChain nextInChain;

    @Override
    public void setNext(PointChain next) {
        nextInChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if(card.getNumber().equals(Value.TWO) && card.getSuit().equals(Suit.CLUB)){
            player.addPoint(2);
            logger.debug(player.getGameName() + " Player-" + player.getIndex() + " get two point.");
        }else{
            nextInChain.process(card,player);
        }
    }
}
