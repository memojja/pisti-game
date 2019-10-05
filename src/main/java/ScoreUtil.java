import model.Card;
import model.Suit;
import model.Value;

import java.util.HashMap;
import java.util.Map;

//TODO majority cards 3 points
//TODO each pisti 10, J=J 20 point

public class ScoreUtil {

    private Map<Card,Integer> scoreCards;

    private static ScoreUtil scoreUtil;

    private ScoreUtil(){
        fillHashMapWithRule();
    }

    public static ScoreUtil getInstance(){
        if (scoreUtil == null){
            synchronized (ScoreUtil.class){
                return new ScoreUtil();
            }
        }
        return scoreUtil;
    }

    private void fillHashMapWithRule() {
        scoreCards = new HashMap<>(10);

        scoreCards.put(new Card(Suit.CLUB,Value.TWO),2);

        scoreCards.put(new Card(Suit.DIAMOND,Value.TEN),3);

        scoreCards.put(new Card(Suit.CLUB,Value.JACK),1);
        scoreCards.put(new Card(Suit.DIAMOND,Value.JACK),1);
        scoreCards.put(new Card(Suit.SPADES,Value.JACK),1);
        scoreCards.put(new Card(Suit.HEARTS,Value.JACK),1);

        scoreCards.put(new Card(Suit.CLUB,Value.ACE),1);
        scoreCards.put(new Card(Suit.DIAMOND,Value.ACE),1);
        scoreCards.put(new Card(Suit.SPADES,Value.ACE),1);
        scoreCards.put(new Card(Suit.HEARTS,Value.ACE),1);
    }
}
