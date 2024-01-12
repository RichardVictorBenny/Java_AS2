package functions;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Test {
    
    public static void main(String[] args) {
        Map<String,Object> record = new HashMap<>();
        record.put("id", "90090");
        record.put("tenantId", "5003");
        record.put("date", "10-01-2024");
        record.put("type", "STRIPE");
        record.put("tenantName", "rihard");
        record.put("Amount", "500");
        record.put("houseId", "2001");

        try {
            new Database().update("payments", record, "id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
