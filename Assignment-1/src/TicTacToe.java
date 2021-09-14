import model.Game;
import model.Player;
import service.GameService;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Welcome to Tic-Tac-Toe \n");
        Scanner scanner = new Scanner(System.in);

        //initialize players
        Player player1 = new Player("X",0);
        Player player2 = new Player("O",0);

        //play game in loop until user decides to quit
        String newGame = "Y"; //at the end of each game check this, if Y/y start new game, else quit

        do {
            GameService gameService = new GameService();
            Game game = gameService.startNewGame();
            gameService.displayBoard(game);
            for(int i=1;i<=9 && game.gameState==0;i++) {
                if(i%2!=0) {
                    //player1 plays
                    gameService.playTurn(game,player1);
                }else {
                    gameService.playTurn(game,player2);
                }
                game.gameState = gameService.checkSequence(game,player1,player2);
            }
            //check game state for different results
            if(game.gameState==1) {
                System.out.println("game has ended");
                System.out.println("Do you want to start another one?");
                newGame = scanner.next();
            }
            else if(game.gameState==2) {
                //game has ended in a draw
                player1.setScore(player1.getScore()+0.5);
                player2.setScore(player2.getScore()+0.5);
                System.out.println("game drawn");
                System.out.println("Do you want to start another one?");
                newGame = scanner.next();
            }

        }while(newGame.equalsIgnoreCase("Y"));

        System.out.println("Game Ends. Final tally as follows:");
        System.out.println("Player 1 :"+player1.getScore());
        System.out.println("Player 2 :"+player2.getScore());
    }
}
