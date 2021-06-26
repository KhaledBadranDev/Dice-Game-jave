
/*
 * @author Khaled Badran <gym4programming@gmail.com>
 * UML Class Diagram of the "Dice" class
  ________________________
  |         Dice         |
  |----------------------|
  |-diceNumber: int      |
  |----------------------|
  |+rollTheDice()        | 
  |+getDiceNumber(): int |
  |+printDice()          |
  |______________________|
*/


/**
 * The "Dice" class represents a dice.
 * 
 * @author Khaled Badran <gym4programming@gmail.com>
 * @version 1.00 - 26 Juni 2021
 */
public class Dice {
    
    /** 
     *  "diceNumber" represents all the 6 possible numbers on the 6 faces of a dice.
     *  The 6 possible numbers are (1, 2, 3, 4, 5, 6).
    */
    private int diceNumber;

    /**
     * To roll the dice and to get a random diceNumber.
     * 
     * @author Khaled Badran <gym4programming@gmail.com>
     */
    public void rollTheDice() {
        double randDouble = Math.random();
        int randDiceNumber = -1;

        if (randDouble >= 0 && randDouble <= 1.0/6.0) randDiceNumber = 1;
        else if (randDouble <= 2.0/6.0) randDiceNumber = 2;
        else if (randDouble <= 3.0/6.0) randDiceNumber = 3;
        else if (randDouble <= 4.0/6.0) randDiceNumber = 4;
        else if (randDouble <= 5.0/6.0) randDiceNumber = 5;
        else if (randDouble < 6.0/6.0) randDiceNumber = 6;
        else {
            System.err.println("Error: java.lang.Math.random() gives invalid numbers!");
            System.exit(1);
        }

        this.diceNumber = randDiceNumber;
        printDice();
    }


    /**
     * 
     * Getter method to get the number placed on the current face of the dice.
     *
     * @author Khaled Badran <gym4programming@gmail.com>
     * @return the number placed on the current face of the dice as an integer.
     */
    public int getDiceNumber() {
        return this.diceNumber;
    }


    /**
     * To print the number of the current face of a dice on the console as following:
     * If diceNumber=1,  if diceNumber=2,  if diceNumber=3,  if diceNumber=4,  if diceNumber=5,  if diceNumber=6 
     *                          *                  *                * *              * *              * *
     *       *                                      *                                 *               * *
     *                            *                  *              * *              * *              * *  
     * 
     * @author Khaled Badran <gym4programming@gmail.com>
     */
    public void printDice() {
        switch (this.diceNumber) {
            case 1:
                System.out.println("\n*\n");
                break;
            case 2:
                System.out.println("*\n\n  *");
                break;
            case 3:
                System.out.println("*\n *\n  *");
                break;
            case 4:
                System.out.println("* *\n\n* *");
                break;
            case 5:
                System.out.println("* *\n *\n* *");
                break;
            case 6:
                System.out.println("* *\n* *\n* *");
                break;        
            default:
                System.err.println("Error: diceNumber is invalid!");
                System.exit(1);
        }
    }

}
