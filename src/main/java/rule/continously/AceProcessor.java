package rule.continously;

import model.Card;
import model.Value;
import rule.PointChain;
import model.Player;

public class AceProcessor implements PointChain {

    private PointChain nextInChain;

    @Override
    public void setNext(PointChain next) {
        nextInChain = next;
    }

    @Override
    public void process(Card card, Player player) {
        if(card.getNumber().equals(Value.ACE)){
            player.addPoint(1);
        }else{
            nextInChain.process(card,player);
        }
    }
}
