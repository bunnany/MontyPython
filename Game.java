

/* Based on the ecs 100 template
 * Code for ??
 * Name:
 * Date:
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

import java.util.Random;    // for random number
import java.util.Scanner;

/** <description of class Game>
 */
public class Game{
    // Array to store doors
    private Door doors[] = new Door[3];
    private Door selectedDoor;
    private Door revealDoor;
    
    // Fields to draw the door
    private final String DOORIMAGE = "images/door.jpg";
    private int TOP = 100;
    private int LEFT = 100;
    private int SIZE = 100;
    private int BUFFER = 50;
   
    /**
     * Constructor for the Game
     */
    public Game() {
        // Adding doors to the array
        for (int i = 0; i<3; i++){
            int leftPos;      // top corner of door
            leftPos = LEFT*(i+1)+BUFFER;
            doors[i] = new Door(leftPos, TOP);
            
            // Draw Door
            UI.drawImage(DOORIMAGE, leftPos, TOP, SIZE, SIZE);
            
            // Get First choice 
            UI.setMouseListener((action, x, y) -> setFirstChoice(action, x, y));
        }
    
    }
    
    /**
     * Method setFirstChoice
     * 
     * @param action    The mouse action which occurred --
     *  only interested in pressed
     * @param   x   X-coordinate of the mouse click
     * @param   y   Y-coordinate of the mouse click
     * 
     * If the action is "pressed" and a door is not open
     * open the door and select it as their first choice
     */
    private void setFirstChoice(String action, double x, double y){
        
        
        // Check first choice has not been made
        for (int i = 0; i < 3; i++) {
            if (this.doors[i].getFirstChoice() == true) {
                doors[i].resetFirstChoice();
            }
        }
        
        //
        if (action.equals("pressed")) {
            for (int i = 0; i < 3; i++) {
                if (this.doors[i].onDoor(x, y) == true) {
                    doors[i].setFirstChoice();
                    UI.println(i);  // Print out door selected
                    // Go To Reveal Door
                    this.showDoor();
                }
        }
    }
}
    
    /**
     * Return a random number based on n
     * @param n upper limit of random number exclusive
     * @return an int which is the random number
     */
    private int randNum(int n) {
        Random rn = new Random();
        return rn.nextInt(n);
    }

    /**
     * Reveal the door with no prize
     * returns the door with no prize
     */
    private void showDoor(){
        // Reveal anreveal door
        int revealDoorIDX;
        do {
            revealDoorIDX = randNum(3);
            this.revealDoor = doors[revealDoorIDX]; 
        } while (doors[revealDoorIDX].getFirstChoice() == true || doors[revealDoorIDX].getPrize() == true);
        doors[revealDoorIDX].setRevealDoor();
        UI.println("Behind Door " + revealDoorIDX + " is no prize");
        //Change image

        //get position of reveal door and redraw image
        
        UI.drawImage("images/goat.jpg", this.revealDoor.getDoorX(), this.revealDoor.getDoorY(),100, 100);
    }

    
    /**
     * Ask user if they want to switch Door
     * If they want to switch set it as their final choice
     * revealwise set their first choice as their final choice
     * @param sd a String which is their decision
     * @param firstChoice which is their initial Door Choice
     */
    private void switchDoor(String switchChoice, int firstChoice){
        if (switchChoice.equals("y")) {
            for (int i = 0; i< 3; i++) {
                if (doors[i].getFirstChoice() == false && doors[i].getRevealDoor() == false) {
                    doors[i].setSwitchDoor();
                    doors[i].setFinalChoice();
                }
            }
        } else {
            doors[firstChoice].setFinalChoice();
        }
    }
    
    /**
     * Check if the player has selected a winning door
     * @return boolean true if won
     */
    private boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (doors[i].checkWin()){
                return true;
            }
        }
        return false;
    }
    
    private void setFirst() {
        UI.println("Here");
    }
    
    public void gameShow() {
        // Setup doors
        
        int firstChoiceDoor, prizeDoor, revealDoor;

        // Set Prize Door
        prizeDoor = randNum(3);
        doors[prizeDoor].setPrize();

        // Choosing a door
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a door");
        firstChoiceDoor = sc.nextInt();
        doors[firstChoiceDoor].setFirstChoice();
        System.out.println("You chose to open Door:" + firstChoiceDoor);
        
        // Reveal anreveal door
        showDoor();

        // Offering Switch
        System.out.println("Would you like to switch your door? (y):");
        String sd = sc.next();
        switchDoor(sd, firstChoiceDoor);
        
        // Check win or lose
        if (checkWin() == true) {
                System.out.println("You win");
            } else {
                System.out.println("Sorry the prize was behind door " + prizeDoor);
                System.out.println("You lose");
            }
    }
    
    public static void main(String[] args) {
        Game gm = new Game();
        //gm.gameShow();
    }
        
}

