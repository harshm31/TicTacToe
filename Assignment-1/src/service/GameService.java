package service;

import model.Game;
import model.Player;
import java.util.*;

public class GameService {

    //function to display board
    public void displayBoard(Game game) {
        String[] board = game.board;

        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");

    }

    public boolean isSqValid(Game game, int sq) {
        boolean valid = false;
        if(!(game.board[sq].equalsIgnoreCase("x") || game.board[sq].equalsIgnoreCase("o"))){
            //sq is valid
            valid = true;
        }
        return valid;
    }

    public void playTurn(Game game, Player player) {

        /**
         * 1.get square input from user
         * 2.check validity of input
         * 3.check for sequence
         *  a.end game if sequence exists
         *  b.make next player input his square
         */

        boolean validity = false; int gameState = game.gameState;
        Scanner scanner = new Scanner(System.in);
        while(!validity) {
            System.out.println("Player "+player.counter+" choose a square:");
            int sq = scanner.nextInt();

            if(isSqValid(game,sq)) {
                //insert into board, display board,check sequence
                game.board[sq] = player.counter;
                System.out.println("You have enetered in pos :"+sq);
                displayBoard(game);

                //gameState = checkSequence(game,player);
                validity = true;

            }
            else {
                System.out.println("Invalid square entered!");
            }
        }
    }


    public int checkSequence(Game game, Player player1,Player player2) {
        String sequence1 = player1.getSequence();
        String sequence2 = player2.getSequence();

        for(int i=0;i<8;i++) {
            String line = null;

            switch(i){
                case 0 :
                    StringBuffer seq = new StringBuffer();
                    seq.append(game.board[0]);
                    seq.append(game.board[1]);
                    seq.append(game.board[2]);
                    line = seq.toString();
                    break;

                case 1:
                    StringBuffer seq1 = new StringBuffer();
                    seq1.append(game.board[3]);
                    seq1.append(game.board[4]);
                    seq1.append(game.board[5]);
                    line = seq1.toString();
                    break;

                case 2 :
                    StringBuffer seq2 = new StringBuffer();
                    seq2.append(game.board[6]);
                    seq2.append(game.board[7]);
                    seq2.append(game.board[8]);
                    line = seq2.toString();
                    break;

                case 3 :
                    StringBuffer seq3 = new StringBuffer();
                    seq3.append(game.board[0]);
                    seq3.append(game.board[3]);
                    seq3.append(game.board[6]);
                    line = seq3.toString();
                    break;

                case 4 :
                    StringBuffer seq4 = new StringBuffer();
                    seq4.append(game.board[1]);
                    seq4.append(game.board[4]);
                    seq4.append(game.board[7]);
                    line = seq4.toString();
                    break;

                case 5 :
                    StringBuffer seq5 = new StringBuffer();
                    seq5.append(game.board[2]);
                    seq5.append(game.board[5]);
                    seq5.append(game.board[8]);
                    line = seq5.toString();
                    break;

                case 6 :
                    StringBuffer seq6 = new StringBuffer();
                    seq6.append(game.board[0]);
                    seq6.append(game.board[4]);
                    seq6.append(game.board[8]);
                    line = seq6.toString();
                    break;

                case 7 :
                    StringBuffer seq7 = new StringBuffer();
                    seq7.append(game.board[2]);
                    seq7.append(game.board[4]);
                    seq7.append(game.board[6]);
                    line = seq7.toString();
                    break;

            }

            if(line.equalsIgnoreCase(sequence1)) {
                //sequence found

                //1.change score
                player1.setScore(player1.getScore()+1);
                //2. announce winner
                System.out.println("Player "+player1.getCounter()+" wins the game!!");

                //3. set game to complete status
                game.setGameState(1);

                return game.gameState; //end the game
            }
            else if(line.equalsIgnoreCase(sequence2)) {
                //sequence found

                //1.change score
                player2.setScore(player2.getScore()+1);
                //2. announce winner
                System.out.println("Player "+player2.getCounter()+" wins the game!!");

                //3. set game to complete status
                game.setGameState(1);

                return game.gameState; //end the game
            }

            for(int j=0;j<9;j++) {
                if(Arrays.asList(game.board).contains(String.valueOf(j+1))) {
                    game.setGameState(0);
                    break;
                }
                else if(j==8) {
                    //game is drawn
                    game.setGameState(2);
                    return game.gameState;
                }
            }
        }
        return game.gameState;
    }

    public Game startNewGame() {
        Game game = new Game();
        game.board = new String[9];
        game.gameState = 0;
        for(int i=0;i<9;i++)
            game.board[i] = String.valueOf(i);
        System.out.println("starting new game");
        return game;
    }
}
