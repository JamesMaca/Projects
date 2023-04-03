//James MacAloney - 101362896
//Stefan Kepinski - 101356431

import java.io.StringReader;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String playerSymbol = null;
    public static String player2Symbol = null;
    public static String compSymbol = null;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String choice = null;

        while (!Objects.equals(choice, "3")) {
            System.out.println("1. 1 Player Game");
            System.out.println("2. 2 Player Game");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scan.nextLine();

            switch (choice) {
                case "1":

                    System.out.println("\n********** TIC-TAC-TOE **********\n");
                    System.out.println("Welcome to Tic-Tac-Toe!");

                    while (compSymbol == null) {
                        System.out.print("Would you like to be X or O: ");
                        playerSymbol = scan.nextLine().toUpperCase();
                        if (Objects.equals(playerSymbol, "X")) {
                            compSymbol = "0";
                        } else if (Objects.equals(playerSymbol, "O")) {
                            compSymbol = "X";
                        } else {

                            System.out.println("ERROR; NOT VALID SYMBOL; MUST BE X OR O");
                        }
                    }

                    String choice2 = "Y";
                    while (!choice2.equals("N")) {
                        while (true) {
                            String [][]board = {
                                    {"1", "2", "3"},
                                    {"4", "5", "6"},
                                    {"7", "8", "9"}};
                            String difficulty;
                            System.out.print("What difficulty do you want to play easy or hard (type easy or hard): ");
                            difficulty = scan.nextLine();
                            if (Objects.equals(difficulty, "easy")) {
                                System.out.println("EASY MODE");
                                playGameEasy(board, scan);
                                break;
                            } else if (Objects.equals(difficulty, "hard")) {
                                playGameHard(board, scan);
                                break;
                            } else {
                                System.out.println("ERROR; Must be easy or hard only");
                            }
                        }
                        System.out.println("Play again? Press Y to play again or N");
                        choice2 = scan.nextLine().toUpperCase();
                    }

                    break;
                case "2":

                    String choice3 = "Y";
                    while (!choice3.equals("N")) {

                    String [][]board = {
                            {"1", "2", "3"},
                            {"4", "5", "6"},
                            {"7", "8", "9"}};

                    System.out.println("\n********** TIC-TAC-TOE **********\n");
                    System.out.println("Welcome to Tic-Tac-Toe!");

                    System.out.println("What is player 1's name?");
                    String player1Name = scan.nextLine();
                    System.out.println("What is player 2' name?");
                    String player2Name = scan.nextLine();

                    while(player2Symbol == null){
                        System.out.print(player1Name + ", would you like to be X or O?");
                        playerSymbol = scan.nextLine().toUpperCase();
                        if(Objects.equals(playerSymbol, "X")){
                            player2Symbol = "0";
                        }else if(Objects.equals(playerSymbol, "O")){
                            player2Symbol = "X";
                        }else{
                            System.out.println("ERROR; NOT VALID SYMBOL; MUST BE X OR O");
                        }
                    }
                    printBoard(board);
                    while (boardNotFull(board)) {
                        playerTurn(board, scan, playerSymbol);
                        printBoard(board);
                        if (isWinner(board, playerSymbol)) {System.out.println(player1Name.toUpperCase() + " WINS");break;}
                        if(!boardNotFull(board)) break;
                        playerTurn(board, scan, player2Symbol);
                        printBoard(board);
                        if (isWinner(board, player2Symbol)) {System.out.println(player2Name.toUpperCase() + " WINS");break;}
                    }
                    if (!boardNotFull(board)) {System.out.println("DRAW");}

                    System.out.println("Play again? Press Y to play again or N");
                    choice3 = scan.nextLine().toUpperCase();
                    }
                    break;

                case "3":
                    System.out.println("Exiting game...");
                    break;

                default:
                    System.out.println("\nInvalid choice, please try again.\n");
                    break;
            }
        }
    }



    /*==============================Easy Game Code======================================================*/
    public static void playGameEasy(String[][] board, Scanner scan) {
        String answer;
        System.out.println("What is your name?");
        String playerName = scan.nextLine();
        printBoard(board);
        while (true) {
            System.out.println("Enter 1 to go first or 2 to for the computer to go first: ");
            answer = scan.nextLine();
            if (Objects.equals(answer, "1") || Objects.equals(answer, "2")) {
                break;
            } else {
                System.out.println("You must enter 1 or 2 to continue");
            }
        }
        if (answer.equals("1")) {
            while (boardNotFull(board)) {
                playerTurn(board, scan, playerSymbol);
                printBoard(board);
                if (isWinner(board, playerSymbol)) {System.out.println(playerName.toUpperCase() + " WINS");break;}
                if(!boardNotFull(board)) break;
                compTurnEasy(board, compSymbol);
                printBoard(board);
                if (isWinner(board, compSymbol)) {System.out.println("COMPUTER WINS");break;}
            }
            if (!boardNotFull(board)) System.out.println("DRAW");
        }
        if (answer.equals("2")) {
            while (boardNotFull(board)) {
                compTurnEasy(board, compSymbol);
                printBoard(board);
                if (isWinner(board, compSymbol)) { System.out.println("COMPUTER WINS"); break;}
                if(!boardNotFull(board)) break;
                playerTurn(board, scan, playerSymbol);
                printBoard(board);
                if (isWinner(board, playerSymbol)) { System.out.println(playerName.toUpperCase() + " WINS"); break;}
            }
            if (!boardNotFull(board)) System.out.println("DRAW");
        }
    }
    public static void compTurnEasy(String[][] board, String symbol){
        Random r = new Random();
        boolean goodLoc = false;
        int compLoc = 0;
        while(!goodLoc){
            compLoc = r.nextInt(8)+1;
            goodLoc = validMove(board, String.valueOf(compLoc));
        }
        placeSymbol(board, String.valueOf(compLoc), symbol);
        System.out.println("Computer played at location: " + compLoc);
    }

    /*==============================Hard Game Code======================================================*/

    public static void playGameHard(String[][] board, Scanner scan){
        String answer;
        System.out.println("What is your name?");
        String playerName = scan.nextLine();
        printBoard(board);
        while (true) {
            System.out.println("Enter 1 to go first or 2 to for the computer to go first: ");
            answer = scan.nextLine();
            if (Objects.equals(answer, "1") || Objects.equals(answer, "2")){
                break;
            }
            else{
                System.out.println("You must enter 1 or 2 to continue");
            }
        }
        if(answer.equals("1")){
            while(boardNotFull(board)){
                playerTurn(board, scan, playerSymbol);
                printBoard(board);
                if(isWinner(board, playerSymbol)){ System.out.println(playerName.toUpperCase() + " WINS"); break;}
                if(!boardNotFull(board)) break;
                compTurnHard(board, compSymbol);
                printBoard(board);
                if(isWinner(board, compSymbol)) { System.out.println("HARD AI WINS"); break;}
            }
            if(!boardNotFull(board)) System.out.println("DRAW");
        }
        if(answer.equals("2")){
            while(boardNotFull(board)){
                compTurnHard(board, compSymbol);
                printBoard(board);
                if(isWinner(board, compSymbol)) { System.out.println("HARD AI WINS"); break;}
                if(!boardNotFull(board)) break;
                playerTurn(board, scan, playerSymbol);
                printBoard(board);
                if(isWinner(board, playerSymbol)){ System.out.println(playerName.toUpperCase() + " WINS"); break;}
            }
            if(!boardNotFull(board)) System.out.println("DRAW");
        }

    }

    public static void compTurnHard(String[][] board, String symbol){
        boolean goodLoc = false;
        String compLoc = null;
        while(!goodLoc){
            compLoc = optimalMove(board);
            goodLoc = validMove(board, String.valueOf(compLoc));
        }
        placeSymbol(board, compLoc, symbol);
        System.out.println("Computer played at location: " + compLoc);
    }

    public static String optimalMove(String[][] board){
        int bestVal = -1000;
        String bestMove = null;
        int moveTry = 0;
        for(int i=0; i<3;i++){
            for (int j=0; j<3; j++){
                if(board[i][j].matches("[1-9]")){
                    String tempLoc = board[i][j];
                    board[i][j] = compSymbol;
                    moveTry = minimax(board, playerSymbol);
                    if(isWinner(board, compSymbol)){
                        bestMove = tempLoc;
                        bestVal = 11;
                    }
                    board[i][j] = tempLoc;
                    if (moveTry >= bestVal) {
                        bestMove = board[i][j];
                        bestVal = moveTry;
                    }
                }

            }
        }
        return bestMove;
    }
    public static int minimax(String[][] board, String symbol){
        if(isWinner(board, playerSymbol)) return -10;
        if(isWinner(board, compSymbol)) return 10;
        if(!boardNotFull(board)) return 0;

        if(symbol == compSymbol){
            int maxScore = -100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j].matches("[1-9]")){
                        String tempLoc = board[i][j];
                        board[i][j] = compSymbol;
                        int nVal = minimax(board, playerSymbol);
                        board[i][j] = tempLoc;
                        maxScore = Math.max(maxScore, nVal);
                    }
                }

            }
            return maxScore;
        }else{
            int minScore = 100;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(board[i][j].matches("[1-9]")){
                        String tempLoc = board[i][j];
                        board[i][j] = playerSymbol;
                        int nVal = minimax(board, compSymbol);
                        board[i][j] = tempLoc;
                        minScore = Math.min(minScore, nVal);
                    }
                }

            }
            return minScore;
        }
    }

    /*================== All Other Functions =====================*/
    public static void playerTurn(String[][] board, Scanner scan, String symbol){
        String loc = null;
        boolean goodLoc = false;
        while(!goodLoc){
            System.out.print("Please select a location to play between 1-9: ");
            loc = scan.nextLine();
            goodLoc = (validMove(board, loc));
            if(!goodLoc){
                System.out.println(loc + " is not valid, please try again!");
            }
        }
        placeSymbol(board, loc, symbol);
    }



    public static void placeSymbol(String[][] board, String loc, String symbol){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(Objects.equals(board[i][j], loc)){
                    board[i][j] = symbol;
                }
            }
        }
    }

    public static boolean validMove(String[][] board, String loc){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(Objects.equals(board[i][j], loc)){
                    return true;
                }
            }
        }
        return false;
    }
    static Boolean boardNotFull(String[][] board)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].matches("[1-9]"))
                    return true;
        return false;
    }

    public static void printBoard(String[][] board){
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n" +
                           board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n" +
                           board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

    public static boolean isWinner(String[][] board, String symbol) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true;
            }
        }
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol) {
            return true;
        }
        return false;
    }
}