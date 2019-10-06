package simulation;

import model.Card;
import model.DummyBot;
import model.GameState;
import model.Player;
import org.apache.log4j.Logger;
import service.GameService;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class Game implements Runnable {

    private String gameName;
    private Player[] players;
    private GameState gameState;
    private GameService gameService;
    private int userActionCount = 0;
    private int count=0;

    private final static Logger logger = Logger.getLogger(String.valueOf(Game.class));

    public Game(){
        gameName = UUID.randomUUID().toString();
        players = new Player[4];
        IntStream.range(0,4)
                .forEach(i -> {
                   players[i] = new DummyBot(i,gameName);
                });
        gameState = new GameState(gameName);
        gameService = new GameService();
    }

    @Override
    public void run() {
        Thread.currentThread().setName(gameName);
        play();
    }


    private void play(){
        List<Card> discardedCards = gameState.getDiscardedCards();
        logger.debug(gameName + " game is starting");
        logger.debug(gameName + " cards on the table : " + discardedCards);

        while (!gameState.isFinished()){
            userActionCount++;

            int turn = gameState.getTurn();
            Player player = players[turn];

            player.play(gameState);
            if(isPlayersNoHaveCard()){
                gameState.giveFourCardAllOfPlayer();
                userActionCount = 0;
            }

            gameState.incrementTurn();
            count++;
        }

        //if game finished, last player must take discarded cards.
        gameService.calculateUserPoint(gameState,discardedCards,players[gameState.getTurn()],true);
        gameService.calculateMajority(players);

        logger.debug(gameName + " game has been finished");
        logger.debug(gameName + " game Collected Card Index : " + gameState.getCollectedCardIndex());
        logger.debug(gameName + " game count : " + count);

        IntStream.range(0,4).forEach(i -> logger.debug(gameName + " Player "+ i + " " + players[i].getPoint()));

    }

    private boolean isPlayersNoHaveCard() {
        return userActionCount == 16 && gameState.getGiveCardCount() !=3;
    }

    private void calculateMajority(Player[] players) {

    }

    public String getGameName() {
        return gameName;
    }
}
