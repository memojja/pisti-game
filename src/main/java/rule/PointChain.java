package rule;

import model.Card;
import model.Player;

/**
 *
 * Uses the Chain of Responsibility to calculate given card point.
 */
public interface PointChain {
    public void setNext(PointChain next);
    public void process(Card card, Player player);
}
