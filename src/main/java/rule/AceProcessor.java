package rule;

import model.Card;
import model.Value;
import org.apache.log4j.Logger;
import model.Player;

/**
 *
 * If given card equals ace increase point,otherwise process next chain
 */
public class AceProcessor implements PointChain {

    private PointChain nextInChain;

    private final static Logger logger = Logger.getLogger(String.valueOf(AceProcessor.class));

    @Override
    public void setNext(PointChain next) {
        nextInChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if(card.getNumber().equals(Value.ACE)){
            player.addPoint(1);
            logger.debug(player.getGameName() + " Player-" + player.getIndex() + " get one point.");
        }else{
            nextInChain.process(card,player);
        }
    }
}
