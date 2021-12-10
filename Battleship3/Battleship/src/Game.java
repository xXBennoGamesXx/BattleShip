import java.util.Scanner;

public class Game {

    public static void initializeGame() {
        System.out.println("Do you want to play 1v1 (1) or against an AI (2)?\nPlease put your choice below.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1) {

        }
        //if (choice == 2) {

       // }

    }

    public void playBattleship1(Board b){
        // **** FIRST SHIP ****//
        Scanner shipSize = new Scanner(System.in);
        System.out.println("Pick your FIRST ship's size.");
        int sizePicked = shipSize.nextInt();

        Scanner pickShipOrientation = new Scanner(System.in);
        System.out.println("Pick an orientation for your FIRST ship (if horizontal, put true; if vertical, put false).");
        boolean orientation = pickShipOrientation.nextBoolean();

        System.out.println("Please enter x- and y-coordiates; make sure x-coordinate is capitalized (Ex. \"A0,\" \"B6\").");
        String input = (new Scanner(System.in)).nextLine();
        if (input.length() != 2) {
            while (input.length() != 2) {
                System.out.println("Please enter a correct input");
                input = (new Scanner(System.in)).nextLine();
            }
        }
        // Assumes that letter is first
        int x_coord = (int)(input.charAt(0));
        int newx_coord = x_coord - 65;
        int y_coord = Integer.parseInt(input.substring(1, 2));


        b.placeShip(sizePicked, orientation, newx_coord, y_coord);

        // **** SECOND SHIP ****//
        Scanner shipSize2 = new Scanner(System.in);
        System.out.println("Pick your SECOND ship's size");
        int sizePicked2 = shipSize2.nextInt();

        Scanner pickShipOrientation2 = new Scanner(System.in);
        System.out.println("Pick an orientation for your FIRST ship (if horizontal, put true; if vertical, put false)");
        boolean orientation2 = pickShipOrientation2.nextBoolean();

        System.out.println("Please enter x- and y-coordiates; make sure x-coordinate is capitalized (Ex. \"A0,\" \"B6\")");
        String input2 = (new Scanner(System.in)).nextLine();
        if (input2.length() != 2) {
            while (input2.length() != 2) {
                System.out.println("Please enter a correct input");
                input2 = (new Scanner(System.in)).nextLine();
            }
        }
        // Assumes that letter is first
        int x_coord2 = (int)(input2.charAt(0));
        int newx_coord2 = x_coord2 - 65;
        int y_coord2 = Integer.parseInt(input2.substring(1, 2));


        b.placeShip(sizePicked2, orientation2, newx_coord2, y_coord2);


        // **** THIRD SHIP ****//
        Scanner shipSize3 = new Scanner(System.in);
        System.out.println("Pick your THIRD ship's size");
        int sizePicked3 = shipSize3.nextInt();

        Scanner pickShipOrientation3 = new Scanner(System.in);
        System.out.println("Pick an orientation for your THIRD ship (if horizontal, put true; if vertical, put false)");
        boolean orientation3 = pickShipOrientation3.nextBoolean();

        System.out.println("Please enter x- and y-coordiates; make sure x-coordinate is capitalized (Ex. \"A0,\" \"B6\")");
        String input3 = (new Scanner(System.in)).nextLine();
        if (input3.length() != 2) {
            while (input3.length() != 2) {
                System.out.println("Please enter a correct input");
                input3 = (new Scanner(System.in)).nextLine();
            }
        }
        // Assumes that letter is first
        int x_coord3 = (int)(input3.charAt(0));
        int newx_coord3 = x_coord3 - 65;
        int y_coord3 = Integer.parseInt(input3.substring(1, 2));


        b.placeShip(sizePicked3, orientation3, newx_coord3, y_coord3);


        //while(true){
          //  Scanner yourMove = new Scanner(System.in);
            //System.out.println("Pick a coordinate to target (A-J, 0-9)");
            //String move = yourMove.nextLine();
        }
    }





