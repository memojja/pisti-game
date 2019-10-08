package rule;

import model.Card;
import model.Player;

/**
 *
 * Uses the Chain of Responsibility to calculate given card point.
 */
public interface PointChain {

    /**
     * to move to the next chain
     *
     * @param next
     */
    void setNext(PointChain next);

    /**
     * to process chain element
     *
     * @param card
     * @param player
     */
    void process(Card card, Player player);
}
