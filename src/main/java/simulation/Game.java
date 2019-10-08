package simulation;

import java.util.concurrent.atomic.AtomicInteger;
import model.*;
import org.apache.log4j.Logger;
import service.GameService;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 *
 * Games run in different threads
 */
public class Game implements Runnable {

    private String gameName;
    private Player[] players;
    private GameState gameState;
    private GameService gameService;
    private int count=0;
    private PlayerFactory playerFactory;

    private final static Logger logger = Logger.getLogger(String.valueOf(Game.class));

    public Game(){
        gameName = UUID.randomUUID().toString();
        players = new Player[4];
        playerFactory = new PlayerFactory();
        IntStream.range(0,4)
                .forEach(i -> {
                    if(i == 1) players[i] = playerFactory.getPlayer(PlayerEnum.SMART_BOT,i,gameName);
                    else  players[i] = playerFactory.getPlayer(PlayerEnum.DUMMY_BOT,i,gameName);
                });
        gameState = new GameState(gameName);
        gameService = new GameService();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(gameName);
        play();
    }


    /**
     *  to start game
     */
    private void play(){
        final List<Card> discardedCards = gameState.getDiscardedCards();
        logger.debug(gameName + " game is starting");
        logger.debug(gameName + " cards on the table : " + discardedCards);

        while (!gameState.isFinished()){

            if(isPlayersNoHaveCard()){
                gameState.giveFourCardAllOfPlayer();
                gameState.setUserActionCount(0);
            }

            final int turn = gameState.getTurn();
            final Player player = players[turn];
            player.play(gameState);


            gameState.incrementTurn();
            count++;
        }

        //if game finished, last player must take discarded cards.
        gameService.calculateUserPoint(gameState,discardedCards,players[gameState.getTurn()],true);
        gameService.calculateMajority(players);

        logger.debug(gameName + " game has been finished");
        logger.debug(gameName + " game Collected Card Index : " + gameState.getCollectedCardIndex());
        logger.debug(gameName + " game count : " + count);

        System.out.println("Game Id : " +gameName);
        IntStream.range(0,4).forEach(i -> System.out.println("Player-"+ i + " has " + players[i].getPoint() + " pts"));

    }

    /**
     * Players don't have card
     * @return boolean
     */
    private boolean isPlayersNoHaveCard() {
        return gameState.getUserActionCount() == 16 && gameState.getGiveCardCount() !=4;
    }

}
