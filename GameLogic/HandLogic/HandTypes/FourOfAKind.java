import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

public class FourOfAKind extends Hand {

  public FourOfAKind(Card[] hand){
    super(Util.FOUR_OF_A_KIND, hand);
    
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
    int k = keys.next();
    if (frequencyOfValues.get(k) == 4)
      return Util.translateValueToChar(k) + "" + 
          Util.translateValueToChar(keys.next());
    else 
      return Util.translateValueToChar(keys.next()) + "" + 
          Util.translateValueToChar(k); 

  }
  
}