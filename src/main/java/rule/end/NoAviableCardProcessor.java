package rule.end;

import model.Card;
import rule.PointChain;
import simulation.Player;

import java.util.List;

// TODO give all of them last player
public class NoAviableCardProcessor implements PointChain {

    private PointChain pointChain;

    @Override
    public void setNext(PointChain next) {
        pointChain = next;
    }

    @Override
    public void process(Card card, Player player) {

    }
}
