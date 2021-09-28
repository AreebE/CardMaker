import java.util.ArrayList;

/*
 * This draws a blueprint for each type of card, from Ace to King.
 * More specifically, this creates certain boxes that the symbols 
 * should be in.
 * (made by me)
*/
public class Blueprint {

  // These constants are used to create the blueprints
  public final static int BLOCK_SIZE = 10;
  private final static int LEFT = 3;
  private final static int STANDARD_SIZE = 3;
  private final static int RIGHT = 9;
  private final static int UP = 3;
  private final static int DOWN = 19;
  private final static int MIDDLE_HORIZ = 6;
  private final static int MIDDLE_VERT = 11;
  private final static int MIDDLE_DOWN = 15; 
  private final static int MIDDLE_UP = 7;
  private final static int OFFSET = 3;


  /*
   * This is the actual method, returning a specific blueprint based 
   * on its value
   *
   *  @param    value       The value of the card
   *
   *  @param    blockSize   How many pixels wide a block is 
   * 
   *  @return   A blueprint, giving boxes of where the shape should be drawn
   * along with whether the shape should be reversed. 
  */
  public static ArrayList<Object[]> getBlueprint(int value, int blockSize){
    switch (value) {
      case 1:
      case 11:
      case 12:
      case 13:
        return getLargeBlueprint(blockSize);
      case 2:
        return getTwoBlueprint(blockSize);
      case 3:
        return getThreeBlueprint(blockSize);
      case 4:
        return getFourBlueprint(blockSize);
      case 5:
        return getFiveBlueprint(blockSize);
      case 6:
        return getSixBlueprint(blockSize);
      case 7:
        return getSevenBlueprint(blockSize);
      case 8:
        return getEightBlueprint(blockSize);
      case 9:
        return getNineBlueprint(blockSize);
      case 10:
        return getTenBlueprint(blockSize);
    }
    return null;
  }

/* Everything below this is a blueprint for each card, with two exceptions
* LargeBlueprint refers to Ace, Jack, Queen, and King
* getFourByTwoColumnBlueprint refers to a specific pattern 
* that is shared by the 10 card and the 9 card, mainly because 
* of the two columns of symbols they both share.
* Each blueprint has a model attached right above it to 
* show how it looks. '+' are right side up, '-' are 
* upside-down
*/

/*
 * A key for the blueprint.add parts:
  blueprint.add(new Object[] {
        X-COORDINATE,
        Y_COORDINATE, 
        SIZE, IS_REVERSED});
*/
  private static ArrayList<Object[]> getLargeBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = new ArrayList<>();
    blueprint.add(new Object[] {blockSize * 3,
        blockSize * 8, 
        blockSize * 9, false});
    return blueprint;
  }

  /*
    _______________
    |             |
    |      +      |
    |             |
    |             |
    |             |
    |             |
    |             |
    |             |
    |      -      |
    |             |
    _______________
  */
  private static ArrayList<Object[]> getTwoBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = new ArrayList<>();
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * UP, 
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * DOWN, 
        blockSize * STANDARD_SIZE, true});
    return blueprint;
  }
  
  /*
    _______________
    |             |
    |      +      |
    |             |
    |             |
    |      +      |
    |             |
    |             |
    |             |
    |      -      |
    |             |
    _______________
  */

  private static ArrayList<Object[]> getThreeBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = getTwoBlueprint(blockSize);
    blueprint.add(new Object[] {
       blockSize * MIDDLE_HORIZ, 
        blockSize * MIDDLE_VERT,  
        blockSize * STANDARD_SIZE, false});
    return blueprint;
  }

  /*
    _______________
    |             |
    |   +     +   |
    |             |
    |             |
    |             |
    |             |
    |             |
    |             |
    |   -     -   |
    |             |
    _______________
  */

  private static ArrayList<Object[]> getFourBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = new ArrayList<>();
    blueprint.add(new Object[] {
        blockSize * LEFT, 
        blockSize * UP, 
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * LEFT, 
        blockSize * DOWN, 
        blockSize * STANDARD_SIZE, true});
    blueprint.add(new Object[] {
        blockSize * RIGHT, 
        blockSize * UP,
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * RIGHT, 
        blockSize * DOWN, 
        blockSize * STANDARD_SIZE, true});
    return blueprint;
  }

  /*
    _______________
    |             |
    |   +     +   |
    |             |
    |             |
    |      +      |
    |             |
    |             |
    |             |
    |   -     -   |
    |             |
    _______________
  */
  private static ArrayList<Object[]> getFiveBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = getFourBlueprint(blockSize);
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * MIDDLE_VERT,  
        blockSize * STANDARD_SIZE, false});
    return blueprint;
  }

  /*
    _______________
    |             |
    |   +     +   |
    |             |
    |             |
    |   +     +   |
    |             |
    |             |
    |             |
    |   -     -   |
    |             |
    _______________
  */
  private static ArrayList<Object[]> getSixBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = getFourBlueprint(blockSize);
    blueprint.add(new Object[] {
        blockSize * LEFT, 
        blockSize * MIDDLE_VERT,  
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * RIGHT, 
        blockSize * MIDDLE_VERT,  
        blockSize * STANDARD_SIZE, false});
    return blueprint;
  }

  /*
    _______________
    |             |
    |   +     +   |
    |             |
    |             |
    |   +     +   |
    |             |
    |      -      |
    |             |
    |   -     -   |
    |             |
    _______________
  */
  private static ArrayList<Object[]> getSevenBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = getSixBlueprint(blockSize);
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * MIDDLE_UP, 
        blockSize * STANDARD_SIZE, false});
    return blueprint;
  }

  /*
    _______________
    |             |
    |   +     +   |
    |      +      |
    |             |
    |   +     +   |
    |             |
    |      -      |
    |             |
    |   -     -   |
    |             |
    _______________
  */
  private static ArrayList<Object[]> getEightBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = getSevenBlueprint(blockSize);
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * MIDDLE_DOWN, 
        blockSize * STANDARD_SIZE, true});
    return blueprint;
  }

  /*
    _______________
    |   +     +   |
    |             |
    |             |
    |   +     +   |
    |      +      |
    |             |
    |   -     -   |
    |             |
    |             |
    |   -     -   |
    _______________
  */
  private static ArrayList<Object[]> getNineBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = getFourByTwoColumnBlueprint(blockSize);
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * MIDDLE_VERT,  
        blockSize * STANDARD_SIZE, false});
    return blueprint;
  }

  /*
    _______________
    |   +     +   |
    |             |
    |      +      |
    |   +     +   |
    |             |
    |             |
    |   -     -   |
    |      -      |
    |             |
    |   -     -   |
    _______________
  */
  private static ArrayList<Object[]> getTenBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = getFourByTwoColumnBlueprint(blockSize);
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * (MIDDLE_UP - 2),  
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * MIDDLE_HORIZ, 
        blockSize * (MIDDLE_DOWN + 2),  
        blockSize * STANDARD_SIZE, true});
    return blueprint;
  }

  /*
    _______________
    |   +     +   |
    |             |
    |             |
    |   +     +   |
    |             |
    |             |
    |   -     -   |
    |             |
    |             |
    |   -     -   |
    _______________
  */
  private static ArrayList<Object[]> getFourByTwoColumnBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = new ArrayList<>();
    blueprint.add(new Object[] {
        blockSize * LEFT, 
        blockSize * (UP - 1), 
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * LEFT, 
        blockSize * (DOWN + 1), 
        blockSize * STANDARD_SIZE, true});
    blueprint.add(new Object[] {
        blockSize * RIGHT, 
        blockSize * (UP - 1), 
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * RIGHT, 
        blockSize * (DOWN + 1), 
        blockSize * STANDARD_SIZE, true});
    blueprint.add(new Object[] {
        blockSize * LEFT, 
        blockSize * (MIDDLE_VERT + OFFSET),  
        blockSize * STANDARD_SIZE, true});
    blueprint.add(new Object[] {
        blockSize * RIGHT, 
        blockSize * (MIDDLE_VERT + OFFSET),  
        blockSize * STANDARD_SIZE, true});
    blueprint.add(new Object[] {
        blockSize * LEFT, 
        blockSize * (MIDDLE_VERT - OFFSET),  
        blockSize * STANDARD_SIZE, false});
    blueprint.add(new Object[] {
        blockSize * RIGHT, 
        blockSize * (MIDDLE_VERT - OFFSET),  
        blockSize * STANDARD_SIZE, false});
    return blueprint;
  }


/*
  private static ArrayList<Object[]> getXBlueprint(int blockSize){
    ArrayList<Object[]> blueprint = new ArrayList<>();
    return blueprint;
  }
*/
}