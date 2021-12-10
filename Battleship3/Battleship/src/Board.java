public class Board {
    private String[][] board = createBoard();


 // Constructor for the Board Object, creates by default a new set of arrays, 10 x 10
    private void Board(){
        this.board = createBoard();
    }

    public String[][] createBoard(){
        String[][] tempBoard = new String[][]{new String[10], new String[10], new String[10], new String[10],
                new String[10], new String[10], new String[10], new String[10], new String[10], new String[10]};

        for (int i =0; i < tempBoard.length;i++){
            for (int j = 0; j < tempBoard[i].length;j++){
                if(tempBoard[i][j] == null){
                    tempBoard[i][j] = "•";}
            }
        }
        return tempBoard;
    }
    public void displayBoard(){
        System.out.print("\n");
        System.out.println("    A B C D E F G H I J");
        for(int i = 0; i < board.length; i++){
            System.out.print(i + " | ");
            for (String val : board[i]){
                System.out.print(val + " ");
            }
            System.out.println("|");
        }

    }
    public void editBoard(int x, int y, String edit){
        if ((x >= 0 && x < 10) && (y >= 0 && y < 10)){
            board[y][x] = edit;
        }
        else{
            System.out.println("Out of bounds, please try again");
        }
    }

    public void placeShip(int size, boolean horizontal, int x, int  y){
        if (horizontal) {
            for (int i = 0; i < size; i++) {
                this.editBoard(x + i, y, "▲");
            }
            displayBoard();
        }
        else{
                for (int i = 0; i < size; i++) {
                    this.editBoard(x, y + i, "▲");
                }
            displayBoard();
        }
    }


}


