

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class HashMapTryoutTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class HashMapTryoutTest
{
    /**
     * Default constructor for test class HashMapTryoutTest
     */
    public HashMapTryoutTest()
    {
    }
    @Test
    public  void tryMap()
    {
        HashMap<String,Integer> telefonbuch = new HashMap<String,Integer>();
        telefonbuch.put("Trick",345);
        telefonbuch.put("Tick",123);
        telefonbuch.put("Tack",832);
        telefonbuch.put("Donald",323);
        
        assertEquals(new Integer(123),telefonbuch.get("Tick"));
        assertEquals(4,telefonbuch.size());
        
        assertEquals(null,telefonbuch.get("nicht da"));
    }
    
    @Test
    public  void tryResponseMap()
    {
        HashMap<String,String> responseMap = new HashMap<String,String>();
        responseMap.put("crash","my computer crashes, too.");
        responseMap.put("windows","use a mac");
        
        String response = responseMap.get("windows");
        
        assertEquals("use a mac",response);
    }
    
    @Test
    public void trySet(){
        HashSet<Integer> lottoZahlen = new HashSet<Integer>();
        lottoZahlen.add(13);
        assertEquals(1,lottoZahlen.size());
        lottoZahlen.add(13);
        assertEquals(1,lottoZahlen.size());
        lottoZahlen.add(49);
        assertEquals(2,lottoZahlen.size());
    }
    
  
}
