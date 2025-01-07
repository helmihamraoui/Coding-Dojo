import java.util.HashMap;
import java.util.Set;

public class MapOfTheHashmatique {

    HashMap<String, String> map = new HashMap<String, String>();

    public void add() {
        map.put("Houmani", "test test test test test test test test");
        map.put("eminem", "test test test test test test test test");
        map.put("Drake", "test test test test test test test test");
        map.put("snoop dogg", "test test test test test test test test");
    }

    public void print() {
        System.out.println("test map" + map);
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    public void get(String houmani) {
        System.out.println(map.get(houmani));
    }

}