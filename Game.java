

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
    // ArrayList to store doors
    public Door doors[] = new Door[3];
    
    /**
     * Constructor for the GUI
     */
    public Game() {
        // Adding doors to the arraylist
        for (int i = 0; i<3; i++){
            doors[i] = new Door();
        }
    //gameShow();
    
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
     * Reveal no prize door
     */
    private void revealDoor(){
        // Reveal another door
        int otherDoor;
        do {
            otherDoor = randNum(3);
        } while (doors[otherDoor].getFirstChoice() == true || doors[otherDoor].getPrize() == true);
        doors[otherDoor].setOtherDoor();
        System.out.println("Behind Door " + otherDoor + " is no prize");
    }
    
    /**
     * Ask user if they want to switch Door
     * If they want to switch set it as their final choice
     * otherwise set their first choice as their final choice
     * @param sd a String which is their decision
     * @param firstChoice which is their initial Door Choice
     */
    private void switchDoor(String sd, int firstChoice){
        if (sd.equals("y")) {
            for (int i = 0; i< 3; i++) {
                if (doors[i].getFirstChoice() == false && doors[i].getOtherDoor() == false) {
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
        
        int firstChoiceDoor, prizeDoor, otherDoor;

        // Set Prize Door
        prizeDoor = randNum(3);
        doors[prizeDoor].setPrize();

        // Choosing a door
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a door");
        firstChoiceDoor = sc.nextInt();
        doors[firstChoiceDoor].setFirstChoice();
        System.out.println("You chose to open Door:" + firstChoiceDoor);
        
        // Reveal another door
        revealDoor();

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

    }
        
}

