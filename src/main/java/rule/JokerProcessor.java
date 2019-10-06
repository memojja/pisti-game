package rule;

import model.Card;
import model.Value;
import org.apache.log4j.Logger;
import model.Player;

public class JokerProcessor implements PointChain {
    private final static Logger logger = Logger.getLogger(String.valueOf(JokerProcessor.class));

    private PointChain nextInChain;

    @Override
    public void setNext(PointChain next) {
        nextInChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if (card.getNumber().equals(Value.JACK)){
            player.addPoint(1);
            logger.debug(player.getGameName() + " Player-" + player.getIndex() + " get one point.");
        }else{
            nextInChain.process(card,player);
        }
    }
}
