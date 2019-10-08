package service;

import model.Card;
import model.GameState;
import model.Player;
import model.Value;
import org.apache.log4j.Logger;
import rule.*;

import java.util.List;
import java.util.stream.IntStream;


/**
 *
 * Service class for calculate point
 */
public class GameService {

    private final static Logger logger = Logger.getLogger(String.valueOf(GameService.class));

    private final PointChain pointChain;

    public GameService() {
        pointChain = new AceProcessor();
        PointChain clubTwoProcessor = new ClubTwoProcessor();
        PointChain diamondTenProcessor = new DiamondTenProcessor();
        PointChain jokerProcessor = new JokerProcessor();
        PointChain noneProcessor = new NoneProcessor();

        pointChain.setNext(clubTwoProcessor);
        clubTwoProcessor.setNext(diamondTenProcessor);
        diamondTenProcessor.setNext(jokerProcessor);
        jokerProcessor.setNext(noneProcessor);
    }

    /**
     * To calculate user point
     *
     * @param gameState
     * @param discardedCards
     * @param player
     * @param isGameFinished
     */
    public void calculateUserPoint(GameState gameState, List<Card> discardedCards, Player player,boolean isGameFinished) {
        Card card = discardedCards.get(discardedCards.size()-1);
        if(isPisti(gameState)){
            player.addPoint(card.getNumber().equals(Value.JACK) ? 20 : 10);
            gameState.setCollectedCardIndex(discardedCards.size());
            logger.debug(gameState.getGameName() + " " + "Player " + player.getIndex() + " made pisti." + card);
        }else if(canIGetAllDiscardedCards(gameState) || isGameFinished){
            IntStream.range(gameState.getCollectedCardIndex(),discardedCards.size())
                      .forEach(i -> pointChain.process(discardedCards.get(i),player));

            gameState.setCollectedCardIndex(discardedCards.size());
        }
    }

    /**
     * calculate card majority
     *
     * @param players
     */
    public void calculateMajority(Player[] players) {
        int maxPlayerIndex = 0;
        for (int i = 1; i < 4; i++)
            if(players[i].getSizeCollectedCard() > players[maxPlayerIndex].getSizeCollectedCard())
                maxPlayerIndex = i;
        players[maxPlayerIndex].addPoint(3);
    }

    /**
     * checks whether game state is pisti
     *
     * @param gameState
     * @return boolean
     */
    private static boolean isPisti(GameState gameState) {
        List<Card> discardedCards = gameState.getDiscardedCards();
        int discardedCardSize = gameState.getCollectedCardIndex()+1;
        return discardedCardSize+2 == discardedCards.size() &&
                (discardedCards.get(0).equals(discardedCards.get(1)));
    }

    /**
     *
     * @param gameState
     * @return
     */
    private static boolean canIGetAllDiscardedCards(GameState gameState){
        List<Card> discardedCards = gameState.getDiscardedCards();
        return  ((discardedCards.get(discardedCards.size()-1).equals(discardedCards.get(discardedCards.size()-2)))
                || discardedCards.get(discardedCards.size()-1).getNumber().equals(Value.JACK));
    }

}
