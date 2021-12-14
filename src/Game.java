import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Game extends Board {
    private Board board1;
    private Board board2;
    private boolean playerTurn;
    private int counter;
    private int counter2;


    public void runGame() {
        playBattleship1();
        loop();
    }

    public void loop() {


        while (counter > 0 && counter2 > 0) {
            if (playerTurn) {
                takeTurn(board1, 2, 1);
                playerTurn = false;

            }
            if (!playerTurn) {
                takeTurn(board2, 1, 2);
                playerTurn = true;

            }
        }
        if (counter == 0) {
            System.out.println("Player 2 has sunk all of the opposing battleships!!");
            System.out.print("Player 2 wins!!!!!!!");
        }
        if (counter2 == 0) {
            System.out.println("Player 1 has sunk all of the opposing battleships!!");
            System.out.print("Player 1 wins!!!!!!!!");
        }
    }


    public void playBattleship1() {

        this.board1 = new Board();
        this.board2 = new Board();

        // **** Prompts for ships for player 1 ****//
        System.out.println("-------------------------\nPlayer 1's picks:\n");
        createShips("FIRST", board1, 1);
        board1.displayBoard(false, 1);
        createShips("SECOND", board1, 1);
        board1.displayBoard(false, 1);
        createShips("THIRD", board1, 1);
        board1.displayBoard(false, 1);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");

        // **** Prompts for ships for player 2 ****//
        board2.displayBoard(true, 2);
        System.out.println("-------------------------\nPlayer 2's picks:\n");
        createShips("FIRST", board2, 2);
        board2.displayBoard(false, 2);
        createShips("SECOND", board2, 2);
        board2.displayBoard(false, 2);
        createShips("THIRD", board2, 2);
        board2.displayBoard(false, 2);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");

    }


    public void takeTurn(Board a, int player, int playerBoard) {
        Scanner attack = new Scanner(System.in);
        a.displayBoard(true, playerBoard);
        System.out.println("Player " + player + " Pick a coordinate to attack; make sure x-coordinate is capitalized (Ex. \"A0,\"\"B6\")\" ");
        String attackInput = (new Scanner(System.in)).nextLine();
        if (attackInput.length() != 2) {
            while (attackInput.length() != 2) {
                System.out.println("Please enter a correct input");
                attackInput = (new Scanner(System.in)).nextLine();
            }
        }
        failsafe(attackInput);

        int x = (int) attackInput.charAt(0) - 65;
        int y = Integer.parseInt(attackInput.substring(1, 2));

        if (a.locate(x, y).equals("▲")) {
            a.editBoard(x, y, "H");
            System.out.println("hit");
            a.displayBoard(true, playerBoard);
            if (playerBoard == 1) {
                counter = counter - 1;
                System.out.println(counter);
            }
            if (playerBoard == 2) {
                counter2 = counter2 - 1;
                System.out.println(counter2);
            }
            if (counter >= 1 && counter2 >= 1) {
                takeTurn(a, player, playerBoard);
            }
        } else if (a.locate(x, y).equals("•")) {
            a.editBoard(x, y, "x");
            System.out.println("Miss");
            a.displayBoard(true, playerBoard);

        } else if (a.locate(x, y).equals("H") || a.locate(x, y).equals("x")) {
            System.out.println("Coordinate already chosen, chose a new one.");
            a.displayBoard(true, playerBoard);
            takeTurn(a, player, playerBoard);
        }
    }

    public int createShips(String order, Board z, int f) {

        Scanner shipSize = (new Scanner(System.in));
        System.out.println("Pick your " + order + " ship's size (number)");
        int sizePicked = (new Scanner(System.in)).nextInt();


        Scanner pickShipOrientation = new Scanner(System.in);
        System.out.println("Pick an orientation for your " + order + " ship (if horizontal, put true; if vertical, put false).");
        try {
            pickShipOrientation.hasNextBoolean();
        }catch(InputMismatchException e){
            System.out.println("Please enter a correct input");
    }
        boolean orientation = pickShipOrientation.nextBoolean();

        System.out.println("Please enter x- and y-coordiates; make sure x-coordinate is capitalized (Ex. \"A0,\" \"B6\").");
        String input = (new Scanner(System.in)).nextLine();
        if (input.length() != 2) {
            while (input.length() != 2) {
                System.out.println("Please enter a correct input");
                input = (new Scanner(System.in)).nextLine();
            }
        }
        failsafe(input);

        // Assumes that letter is first
        int x_coord = (int) (input.toUpperCase().charAt(0));
        int newx_coord = x_coord - 65;
        int y_coord = Integer.parseInt(input.substring(1, 2));

        z.placeShip(sizePicked, orientation, newx_coord, y_coord);



        if(f == 1) {
            counter = counter + sizePicked;
        System.out.println(counter);
            return counter;
        }
        if(f == 2) {
            counter2 = counter2 + sizePicked;
            System.out.println(counter2);
            return counter2;
        }
        return 5;
    }



    }




