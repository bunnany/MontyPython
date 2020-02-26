
/**
 * Returns if the door has a prize or a goat
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door
{
    private boolean prize, firstChoice, switchDoor, otherDoor, finalChoice;
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     * 
     *
     */
    public Door() {
        prize = false;
        firstChoice = false;
        switchDoor = false;
        otherDoor = false;
        finalChoice = false;
    }
    
    public boolean getPrize() {
        /*if (prize == true) {
            return true;
        } else {
            return false;
        }*/
        return prize;
    }
    
    public void setPrize() {
        prize = true;
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
    
    public void setOtherDoor() {
        otherDoor = false;
    }
    
    public boolean getOtherDoor() {
        return otherDoor;
    }
    
    public void setFinalChoice() {
        finalChoice = true;
    }
    
    public boolean getFinalChoice() {
        return finalChoice;
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
    public boolean checkWin() {
        if (prize == true && finalChoice == true) {
            return true;
        } else {
            return false;
        }
    }
}
