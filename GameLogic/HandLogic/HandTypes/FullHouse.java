import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class FullHouse extends Hand {

  public FullHouse(Card[] hand){
    super(Util.FULL_HOUSE, hand);
    
  }
 
  @Override
  protected String createString(Card[] hand){ 
    HashMap<Integer, Integer> frequencyOfValues = new HashMap<>();
    for (Card c: hand){
      int value = Util.getValue(c.getRank());
      if (frequencyOfValues.containsKey(value)){
        int frequency = frequencyOfValues.get(value);
        frequencyOfValues.put(value, frequency + 1);
      }
      else 
        frequencyOfValues.put(value, 1);
    }
    Iterator<Integer> keys = frequencyOfValues.keySet().iterator();
    int key = keys.next();
    if (frequencyOfValues.get(key) == 3)
      return Util.getChar(key) + "" + 
          Util.getChar(keys.next());
    else 
      return Util.getChar(keys.next()) + "" + 
          Util.getChar(key); 
  }
  
}

