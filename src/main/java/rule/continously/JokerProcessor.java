package rule.continously;

import model.Card;
import model.Value;
import rule.PointChain;
import model.Player;

public class JokerProcessor implements PointChain {

    private PointChain nextChain;

    @Override
    public void setNext(PointChain next) {
        nextChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if (card.getNumber().equals(Value.JACK)){
            player.addPoint(1);
        }else {
            nextChain.process(card,player);
        }
    }
}
