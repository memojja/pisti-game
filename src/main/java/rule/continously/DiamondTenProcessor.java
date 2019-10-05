package rule.continously;

import model.Card;
import model.Suit;
import model.Value;
import rule.PointChain;
import model.Player;

// TODO 3 point
public class DiamondTenProcessor implements PointChain {

    private PointChain nextInChain;

    @Override
    public void setNext(PointChain next) {
        nextInChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if(card.getNumber().equals(Value.TEN) && card.getSuit().equals(Suit.DIAMOND)){
            player.addPoint(3);
        }else {
            nextInChain.process(card,player);
        }
    }
}
