package rule.continously;

import model.Card;
import model.Suit;
import model.Value;
import rule.PointChain;
import simulation.Player;

public class ClubTwoProcessor implements PointChain {

    private PointChain nextInChain;

    @Override
    public void setNext(PointChain next) {
        nextInChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if(card.getNumber().equals(Value.TWO) && card.getSuit().equals(Suit.CLUB)){
            player.addPoint(2);
        }else {
            nextInChain.process(card,player);
        }
    }
}
