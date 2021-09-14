package model;

public class Game {
    public String[] board = new String[9];
    public int gameState;

    public Game() {
        //does nothing
    }

    public Game(String[] board,int gameState) {
        this.board = board;
        this.gameState = gameState;
    }

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public int getGameState() {
        return gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }
}
