package rule;

import model.Card;
import model.Player;

/**
 *
 * End of the point chain
 */
public class NoneProcessor implements PointChain {
    @Override
    public void setNext(PointChain next) {

    }

    @Override
    public void process(Card card, Player player) {

    }
}
