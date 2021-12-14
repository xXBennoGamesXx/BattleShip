import java.util.Scanner;

public class BattleshipRunner {
    public static void main(String args[]){
        int choice;
        Board gameBoard = new Board();
        Board gameBoard2 = new Board();
        Game game = new Game();
        gameBoard.displayBoard(false,1);
        //Game.initializeGame();
        game.runGame();
        //gameBoard.placeShip(4, true, 2, 2);


    }


}