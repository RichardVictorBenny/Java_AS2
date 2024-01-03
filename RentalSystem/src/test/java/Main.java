import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> record = new HashMap<>();
        record.put("houseId", "2001");


        Collection<String> keySet = record.keySet();
        Collection<String> valueSet = record.values();

        String joined = keySet.stream().collect(Collectors.joining(","));
        System.out.println(joined);

    
    
    }
    
}
