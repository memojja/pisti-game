package rule;

import model.Card;
import model.Player;

public interface PointChain {
    public void setNext(PointChain next);
    public void process(Card card, Player player);
}
