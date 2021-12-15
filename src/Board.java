//import javax.lang.model.util.AbstractElementVisitor14;
import java.util.Scanner;

public class Board {
    private String[][] board;
    public int counter;
    public int counter2;

    // Constructor for the Board Object, creates by default a new set of arrays, 10 x 10
    public Board() {
        this.board = createBoard();

    }

    public String[][] createBoard() {
        String[][] tempBoard = new String[][]{new String[10], new String[10], new String[10], new String[10],
                new String[10], new String[10], new String[10], new String[10], new String[10], new String[10]};

        for (int i = 0; i < tempBoard.length; i++) {
            for (int j = 0; j < tempBoard[i].length; j++) {
                if (tempBoard[i][j] == null) {
                    tempBoard[i][j] = "•";
                }
            }
        }
        return tempBoard;
    }

    public void displayBoard(boolean hidden, int d) {
        System.out.print("\n");
        System.out.println("     Player " + d + "'s Board \n    A B C D E F G H I J");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " | ");
            for (String val : board[i]) {
                if (hidden) {
                    if (!val.equals("▲")) {
                        System.out.print(val + " ");
                    }
                    else {
                        System.out.print("• ");
                    }
                     if (val.equals("H")){
                        System.out.print("");
                    }
                     if(val.equals("x")) {
                         System.out.print("");
                     }
                } else {
                    System.out.print(val + " ");
                }
            }
            System.out.println("|");
        }

    }

    public void editBoard(int x, int y, String edit) {
        if ((x >= 0 && x < 10) && (y >= 0 && y < 10)) {
            board[y][x] = edit;
        } else {
            System.out.println("Out of bounds, please try again");
        }
    }

    public boolean checkShipCollision(int size, int x, int y, boolean horizontal) {
        boolean shipPresent = false;


        return true;
    }


    public void placeShip(int size, boolean horizontal, int x, int y) {
        boolean isClear = true;
        if (horizontal) {
            for (int i = 0; i < size; i++) {
               // boolean present = false;
                //present = sCheck(x+i,y);
                //if (present) {
                 //  isClear = false;
                //if(isClear = true) {
                    this.editBoard(x + i, y, "▲");
               // }
                //else{
                  //  System.out.println("error, put in new input");
                  //  placeShip(size, horizontal, x, y);
                    //break;
                //}
                //}
            }
        } else {
            for (int i = 0; i < size; i++) {
            //    boolean present = false;
              //  sCheck(x,+y+i);
                //present = sCheck(x+i,y);
                //if(present){
                  //  isClear =false;
            //}
              //  if(isClear){
                    this.editBoard(x, y + i, "▲");
                }
                //else{
                //    placeShip(size, horizontal, x, y);
                  //  break;
               // }

        }
        }
        ////


    public boolean sCheck(int x, int y) {
        boolean present = false;
        String[] s = plot(x, y);
        for (String q : s) {
            if (q != null && q.equals("▲")) {
                present  = true;
                break;
            }
        }
        return present;
    }
    public String locate(int a, int b) {
        return board[b][a];

    }

    public void failsafe(String input) {
        boolean test = true;
        while (test) {
            try {
                Integer.parseInt(input.substring(1, 2));
                test = false;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a correct input");
                input = (new Scanner(System.in)).nextLine();
            }
        }
    }
    public String[] plot(int x, int y){
        String[] s = {"•","•","•","•"};
        s[0] = locate(x,y-1);
        s[1] = locate(x,y-1);
        s[2] = locate(x,y-1);
        s[3] = locate(x,y-1);
        return s;
    }
}




