package rule;

import model.Card;
import simulation.Player;

import java.util.List;

public interface PointChain {
    public void setNext(PointChain next);
    public void process(Card card, Player player);
}
