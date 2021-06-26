
/*
 * @author Khaled Badran <gym4programming@gmail.com>
 * UML Class Diagram of the "Game" class
  __________________________________
  |              Game              |
  |--------------------------------|
  |--------------------------------|
  |+evaluateScore (b: Becher): int |
  |+main (args: String[])          |
  |________________________________|
*/


import java.util.Scanner;


/**
 * The "Game" class is to start the game, 
 * and to evaluate the score of all the dice thrown out from the dice cup, 
 * based on the game rules.
 * 
 * @author Khaled Badran <gym4programming@gmail.com>
 * @version 1.00 - 26 Juni 2021
*/
public class Game {

    /**
     * The is the Main method.
     * In this method we will list/call all the tasks/operations of the program/game. 
     * 
     * @author Khaled Badran <gym4programming@gmail.com>
     * @param args
     */
    public static void main(String[] args) {
        // welcome the player to the game.
        System.out.println("# WELCOME TO THE DICE GAME #");        
        System.out.println("  ************************");

        //start the game
        while(true){
            System.out.println("rolling the dice .....");
            sleep2Sec(); // just to make the game a little bit realistic.

            DiceCup cup = new DiceCup();
            cup.rollAllDice(); // to roll all the 3 dice 
            
            int score = evaluateScore(cup);
            System.out.print("Score = ");
            System.out.println(score); // print the score of this turn/game.
            System.out.println(); // new line just to make some free space.

            //check if the player wants to play again.
            System.out.print("Would you like to play again? [y/n] \n> ");
            Scanner scan =  new Scanner(System.in); 
            String exit = scan.nextLine();
            if (!exit.equalsIgnoreCase("y")) // ff the player enters anything other than "y" or "Y", then close the game.
                break;
        }
    }


   /**
     * evaluates the score of the dice thrown from the dice cup,
     * based on the following rules.
     * *************************************************
     * "Pasch": the numbers of all the 3 dice are the same.
     * The score would be = the number on the face of any of these 3 dice * 100.
     * E.g. if all the number of all the 3 dice = 6, the score would be 6*100 = 600. 
     * E.g. if all the number of all the 3 dice = 2, the score would be 2*100 = 200.
     * 
     * "Pair": the numbers of 2 dice are the same.
     * The score would be = the number on the face of any of these 2 dice * 10.
     * E.g. if a pair of one-dice exists, the score would be = 1*10 = 10.
     * E.g. if a pair of two-dice exists, the score would be = 2*20 = 20.
     * 
     * "Street": the numbers of the dice follow one another.
     * E.g. (2, 3, 4) or (4, 5, 6) or (3, 2, 1), etc. the score would be = 100,
     * regardless of the numbers on the dice.
     * *************************************************
     * in all the other cases the score will be =
     * the sum of the numbers on the current faces of all the dice.
     * E.g. (3, 5, 1), the score would be = 3+5+1 = 9
     * 
     * @author Khaled Badran <gym4programming@gmail.com>
     * @param b the dice cup that has the dice in it. 
     * @return the score of the dice thrown from the dice cup as an integer.
     */
    public static int evaluateScore(DiceCup b) {
        int score;
        
        // To determine the score and the evaluation criteria of the game.
        // **************************************************************
        if(b.getDiceNumber(1) == b.getDiceNumber(2) &&  b.getDiceNumber(2) ==  b.getDiceNumber(3)){//if "Pash"
            System.out.println("Evaluation criteria: \"Pash\"");
            score = b.getDiceNumber(1) * 100;
            return score;
        }

        else if (b.getDiceNumber(1) == b.getDiceNumber(2)|| b.getDiceNumber(1) == b.getDiceNumber(3)){//if "Pair"
            System.out.println("Evaluation criteria: \"Pair\"");
            score = b.getDiceNumber(1) * 10;
            return score;
        }
        else if (b.getDiceNumber(2) == b.getDiceNumber(3)){//if "Pair"
            System.out.println("Evaluation criteria: \"Pair\"");
            score = b.getDiceNumber(2) * 10;
            return score;
        }

        // neither "Pair" nor "Pasch", but it might be "Street"
        else if( b.getDiceNumber(1)-b.getDiceNumber(2) == -1 && b.getDiceNumber(2)-b.getDiceNumber(3) == -1){ // ascending e.g 1,2,3
            System.out.println("Evaluation criteria: \"Street\"");
            score = 100;
            return score;
        }
        else if( b.getDiceNumber(1)-b.getDiceNumber(2) == 1 && b.getDiceNumber(2)-b.getDiceNumber(3) == 1){ // descending e.g 3,2,1
            System.out.println("Evaluation criteria: \"Street\"");
            score = 100;
            return score;
        }
        // ***********************************************************
        
        // if no evaluation criteria/rule was found.
        System.out.println("Evaluation criteria: Not applicable");
        score = b.getDiceNumber(1) + b.getDiceNumber(2) +  b.getDiceNumber(3);
        return score; 
    }


    /**
     * pause the execution of the current thread for 2 seconds.
     * 
     * @author Khaled Badran <gym4programming@gmail.com>
     */
    public static void sleep2Sec() {
        try {
            Thread.sleep(2000); // sleep for 2 second
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
