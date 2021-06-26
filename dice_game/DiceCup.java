
/*
 * @author Khaled Badran <gym4programming@gmail.com>
 * UML Class Diagram of the "DiceCup" class
  _______________________________
  |           DiceCup           |
  |-----------------------------|
  |-cup: Dice[]                 |
  |-----------------------------|
  |+rollAllDice()               |
  |+getDiceNumber(id: int): int |
  |_____________________________|
*/


/**
 * The "DiceCup" class represents a dice cup that has 3 dice in it.
 * 
 * @author Khaled Badran <gym4programming@gmail.com>
 * @version 1.00 - 26 Juni 2021
 */
public class DiceCup {

    /** 
     * "cup" is an array that represents a cup that has 3 dice in it.
    */
    private Dice[] cup = {new Dice(), new Dice(), new Dice()};

    /**
     * To get the number placed on the the current face of the dice with the given index.
     * 
     * @author Khaled Badran <gym4programming@gmail.com>
     * @param id index of the dice. either 1, 2 or 3.
     * @return the number placed on the current face of the dice as an integer
     */
    public int getDiceNumber (int id) {
        return cup[id-1].getDiceNumber();
    }


    /**
     * To throw all the dice out of the dice cup = to roll all the dice.
     * 
     * @author Khaled Badran <gym4programming@gmail.com>
     */
    public void rollAllDice() {
        for(int id = 1; id <= cup.length; id++){
            System.out.printf("Dice %d:%n", id);
            this.cup[id-1].rollTheDice();
        }
    }

}
