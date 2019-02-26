package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.PigGameState;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        GameAction action = null;
        PigGameState instance = null;
        Random rand = new Random();

        if (info instanceof PigGameState) {
            instance = (PigGameState) info;
        }

        if (instance != null) {
            if (playerNum == instance.getTurn()) {
                int chance = rand.nextInt(2) + 1;
                if (chance == 1){
                    action = (new PigHoldAction(this));
                    game.sendAction(action);
                }
                else if (chance == 2){
                    action = (new PigRollAction(this));
                    game.sendAction(action);
                }
            }
        }
        else {
            return;
        }
    }//receiveInfo

}
