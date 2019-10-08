package rule;

import model.Card;
import model.Suit;
import model.Value;
import org.apache.log4j.Logger;
import model.Player;

/**
 *
 * If given card equals diamond ten increase point,otherwise process next chain
 */
public class DiamondTenProcessor implements PointChain {
    private final static Logger logger = Logger.getLogger(String.valueOf(DiamondTenProcessor.class));

    private PointChain nextInChain;

    @Override
    public void setNext(PointChain next) {
        nextInChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if(card.getNumber().equals(Value.TEN) && card.getSuit().equals(Suit.DIAMOND)){
            player.addPoint(3);
            logger.debug(player.getGameName() + " Player-" + player.getIndex() + " get three point.");

        }else{
            nextInChain.process(card,player);
        }
    }
}
