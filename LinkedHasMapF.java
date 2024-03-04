import java.util.Map;
import java.util.LinkedHashMap;

public class LinkedHasMapF implements InterfaceMap{
   public Map<String, String> createMap() {
    return new LinkedHashMap<>();
    }   
}
