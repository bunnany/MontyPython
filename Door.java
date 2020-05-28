
/**
 * Returns if the door has a prize or a goat
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    private boolean prize;   // true if contains prize
    private boolean firstChoice; // true if user selects first door
    private boolean switchDoor;  // don't remember
    private boolean revealDoor;  // true if  it is door to reveal to player
    private boolean finalChoice;    // true if final choice of door
    private int posX, posY;     // position of door on screen
    private int SIZE = 100;
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     * 
     *
     */
    public Door(int x, int y) {
        prize = false;
        firstChoice = false;
        switchDoor = false;
        revealDoor = false;
        finalChoice = false;
        this.posX = x;
        this.posY = y;
    }
    
    public boolean getPrize() {
        /*if (prize == true) {
            return true;
        } else {
            return false;
        }*/
        return prize;
    }
    
    public boolean onDoor(double x, double y) {
        if (x >= this.posX && x <= this.posX+SIZE &&
        y >= this.posY && y <= this.posY+SIZE) {
            return true;
        } else {
            return false;
        }
    }
    
    public void setPrize() {
        prize = true;
    }
    
    public void resetFirstChoice() {
        firstChoice = false;
    }
    
    public void setFirstChoice() {
        firstChoice = true;
    }
    
    public void setSwitchDoor() {
        switchDoor = false;
    }
    
    public boolean getFirstChoice() {
        return firstChoice;
    }
    
    public boolean getSwitchDoor() {
        return switchDoor;
    }
    
    public void setRevealDoor() {
        revealDoor = false;
    }
    
    public boolean getRevealDoor() {
        return revealDoor;
    }
    
    public void setFinalChoice() {
        finalChoice = true;
    }
    
    public boolean getFinalChoice() {
        return finalChoice;
    }
    
    public int getDoorX() {
        return this.posX;
    }
    public int getDoorY() {
        return this.posY;
    }
    
    public boolean prizeAndFirstChoice() {
        if (prize == true && firstChoice == true) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean prizeAndSwitchDoor() {
        if (prize == true && switchDoor == true) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * If final choice contains prize returns true
     */
    public boolean checkWin() {
        if (prize == true && finalChoice == true) {
            return true;
        } else {
            return false;
        }
    }
}
