import java.lang.Exception;

/*
 * As the name implies, this exception is only caused when too many 
 * chips were bet.
 *
 * There is a constructor to pass in how many chips the player had so 
 * the Round class can access them.
*/
public class TooManyChipsBet extends Exception {
  private int availableChips;
  public TooManyChipsBet(int chips){
    availableChips = chips;
  }

  public int getAvailableChips(){
    return availableChips;
  }
}