package pp231.dao;

import org.springframework.stereotype.Component;
import pp231.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private List<User> users;

    {
        users = new ArrayList<User>();
        users.add( new User(0, "Ivan", 23));
        users.add( new User(1, "Erik", 25));
        users.add( new User(2, "Erketai", 24));
        users.add( new User(3, "Viktor", 21));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(users -> users.getId() == id).findAny().orElse(null);
    }
}
