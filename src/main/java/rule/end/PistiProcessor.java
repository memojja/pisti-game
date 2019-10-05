package rule.end;

import model.Card;
import rule.PointChain;
import simulation.Player;

public class PistiProcessor implements PointChain {

    private PointChain nextChain;

    @Override
    public void setNext(PointChain next) {
        nextChain = next;
    }

    @Override
    public void process(Card card, Player player) {
//        if(cards.size() == 2){
//            if(cards.get(0).equals(cards.get(1))){
//                if(cards.get(0).getNumber().equals(Value.JACK)){
//                    player.addPoint(20);
//                }else{
//                    player.addPoint(10);
//                }
//            }
//        }else {
//            nextChain.process(cards,player);
//        }
    }
}
