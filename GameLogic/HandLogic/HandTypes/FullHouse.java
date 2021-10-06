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
      int value = Util.interpretValue(c.getValue());
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
      return Util.translateValueToChar(key) + "" + 
          Util.translateValueToChar(keys.next());
    else 
      return Util.translateValueToChar(keys.next()) + "" + 
          Util.translateValueToChar(key); 
  }
  
}

