import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DBUtil {
    Map<String, User> bankDataBase = new HashMap<String, User>();

    public DBUtil() {
        this.bankDataBase.put("1001", new User("1001", 123456, "刘备", "15012345678", 100));

    }
    public User getUser(String caedID){
        return this.bankDataBase.get(caedID);
    }
    public Collection<User> getAllUser(){
        return this.bankDataBase.values();
    }
}
