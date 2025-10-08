import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String name, String phone) {
        if (!book.containsKey(name)) {
            book.put(name, new ArrayList<>());
        }
        book.get(name).add(phone);
    }

    public List<String> get(String name) {
        if (book.containsKey(name)) {
            return book.get(name);
        } else {
            return null;
        }
    }

    public void showAll() {
        for (String name : book.keySet()) {
            System.out.println(name + ": " + book.get(name));
        }
    }
}
