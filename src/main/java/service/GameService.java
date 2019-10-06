package service;

import model.Card;
import model.GameState;
import model.Player;
import model.Value;
import rule.PointChain;
import rule.continously.*;
import util.GenericCardUtil;

import java.util.List;
import java.util.stream.IntStream;

public class GameService {

    private final PointChain pointChain;

    public GameService() {
        pointChain = new AceProcessor();
        PointChain c2 = new ClubTwoProcessor();
        PointChain c3 = new DiamondTenProcessor();
        PointChain c4 = new JokerProcessor();
        PointChain c5 = new NoneProcessor();
        pointChain.setNext(c2);
        c2.setNext(c3);
        c3.setNext(c4);
        c4.setNext(c5);
    }

    public void calculateUserPoint(GameState gameState, List<Card> discardedCards, Player player,boolean isGameFinished) {
        Card card = discardedCards.get(discardedCards.size()-1);
        if(GenericCardUtil.isPisti(gameState)){
            player.addPoint(card.getNumber().equals(Value.JACK) ? 20 : 10);
            gameState.setCollectedCardIndex(discardedCards.size()-1);
            gameState.setLastCollectDiscardedCardUserIndex(player.getIndex());
        }else if(GenericCardUtil.canIGetAllDiscardedCards(gameState) || isGameFinished){
            IntStream.range(gameState.getCollectedCardIndex(),discardedCards.size())
                      .forEach(i -> pointChain.process(card,player));

            gameState.setCollectedCardIndex(discardedCards.size()-1);
            gameState.setLastCollectDiscardedCardUserIndex(player.getIndex());
        }
    }
}
