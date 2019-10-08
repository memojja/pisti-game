package model;

/**
 *
 * All players have different logic implementation
 */
public interface BrainTemplate {

    /**
     * Players have same action. Only difference is logic.
     *
     * @param gameState
     * @return
     */
    Card logic(GameState gameState);

}
