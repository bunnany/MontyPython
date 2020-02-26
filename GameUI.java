/* Based on the ecs 100 template
 * Code for ??
 * Name:
 * Date:
 */


import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;


/** Game UI is the UI for the Monty Hall game problem
 */
public class GameUI{
    private final String DOORIMAGE = "images/door.jpg";
    private int TOP = 100;
    private int LEFT = 100;
    private int SIZE = 100;
    private int BUFFER = 50;
    private boolean firstChoice = true;

    /**      */
    public GameUI(){
    Game gm = new Game();    
    UI.initialise();
    UI.addButton("Quit", UI::quit);
    //UI.addButton("Door 1", gm::setFirst);
    UI.drawImage(DOORIMAGE, LEFT, TOP, SIZE, SIZE);
    UI.drawImage(DOORIMAGE, LEFT+SIZE+BUFFER, TOP, SIZE, SIZE);   // Door 2
    UI.drawImage(DOORIMAGE, LEFT+(SIZE+BUFFER)*2, TOP, SIZE, SIZE); // Door 3
    // Add mouse listener
    UI.setMouseListener((action, x, y) -> doMouse(action, x, y, gm));

    }

    /**
     * Method doMouse
     * 
     * @param action    The mouse action which occurred --
     *  only interested in pressed
     * @param   x   X-coordinate of the mouse click
     * @param   y   Y-coordinate of the mouse click
     * 
     * If the action is "pressed" and a door is not open
     * open the door and select it as their first choice
     */
    private void doMouse(String action, double x, double y, Game gm){
        int door;
        
        // Check first choice has not been made
        for (int i = 0; i < 3; i++) {
            if (gm.doors[i].getFirstChoice() == true) {
                firstChoice = false;
            }
        }
        if (action.equals("pressed") && firstChoice == true) {
            if (x >= LEFT && x <= LEFT+SIZE && y >= TOP && y <= TOP+SIZE) { // Door 1
                UI.println("Door 1");
                firstChoice = false;
                gm.doors[0].setFirstChoice();
            }
            else if (x >= LEFT+SIZE+BUFFER && x <= LEFT+SIZE+BUFFER+SIZE && y >= TOP && y <= TOP+SIZE) { // Door 2
                UI.println("Door 2");
                firstChoice = false;
                gm.doors[1].setFirstChoice();
            }
            else if (x >= LEFT+(SIZE+BUFFER)*2 && x <= LEFT+(SIZE+BUFFER)*2+SIZE && y >= TOP && y <= TOP+SIZE) { // Door 3
                UI.println("Door 3");
                firstChoice = false;
                gm.doors[2].setFirstChoice();
            }
            
        }
    }

    public static void main(String[] args){
        GameUI obj = new GameUI();
        
        
    }

}

