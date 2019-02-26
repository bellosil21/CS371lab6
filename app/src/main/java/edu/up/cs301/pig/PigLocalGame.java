package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;
import edu.up.cs301.game.infoMsg.PigGameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    PigGameState instance;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        instance = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if (instance.getTurn() == playerIdx){return true;}
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
        if (action instanceof PigRollAction) {
            Random random = new Random();
            instance.setDieVal(random.nextInt(6) + 1);

            if (instance.getDieVal() == 1) {
                instance.setRunningTotal(0);
                if (players.length == 2) {
                    if (instance.getTurn() == 1) {
                        instance.setTurn(0);
                    } else if (instance.getTurn() == 0) {
                        instance.setTurn(1);
                    }
                }
            } else {
                instance.setRunningTotal(instance.getRunningTotal() + instance.getDieVal());
            }

            return true;
        }


        else if(action instanceof PigHoldAction) {
            int newRoll = instance.getRunningTotal();

            if (instance.getTurn() == 1) {
                instance.setPlayer1Score(instance.getPlayer1Score() + newRoll);
                if (players.length == 2) {
                    instance.setTurn(0);
                }
            }

                else if (instance.getTurn() == 0) {
                    instance.setPlayer0Score(instance.getPlayer0Score() + newRoll);
                    if (players.length == 2) {
                        instance.setTurn(1);
                    }
                }

                instance.setRunningTotal(0);
                return true;
            }

        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState newInstance = new PigGameState(instance);
        p.sendInfo(newInstance);
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        String won = null;
        if (instance.getPlayer0Score() >= 50){
            won = "Player 1 wins";
        }
        else if (instance.getPlayer1Score() >= 50){
            won = "Player 2 wins";
        }
        return won;
    }

}// class PigLocalGame
