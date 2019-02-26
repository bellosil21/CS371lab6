package edu.up.cs301.game.infoMsg;

public class PigGameState extends GameState {
    private int turn;
    private int player0;
    private int player1;
    private int runningTotal;
    private int dieVal;

    public PigGameState(){
        turn = 0;
        player0 = 0;
        player1 = 0;
        runningTotal = 0;
        dieVal = 0;
    }

    public PigGameState(int turn, int player0, int player1, int runningTotal, int dieVal){
        this.turn = turn;
        this.player0 = player0;
        this.player1 = player1;
        this.runningTotal = runningTotal;
        this.dieVal = dieVal;
    }

    public int getTurn(){return this.turn;}

    public int getPlayer0Score(){return this.player0;}

    public int getPlayer1Score(){return this.player1;}

    public int getRunningTotal(){return  this.runningTotal;}

    public int getDieVal() {return dieVal;}

    public void setTurn(int turn){this.turn = turn;}

    public void setPlayer0Score(int player0Score){this.player0 = player0Score;}

    public void setPlayer1Score(int player1Score){this.player1 = player1Score;}

    public void setRunningTotal(int runningTotal){this.runningTotal = runningTotal;}

    public void setDieVal(int dieVal) {this.dieVal = dieVal;}
}
