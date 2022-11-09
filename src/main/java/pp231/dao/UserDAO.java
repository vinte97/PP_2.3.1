package pp231.dao;

import org.springframework.stereotype.Component;
import pp231.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private List<User> users;
    private static int USERS_COUNT;

    {
        users = new ArrayList<>();
        users.add( new User(++USERS_COUNT, "Ivan", 23));
        users.add( new User(++USERS_COUNT, "Erik", 25));
        users.add( new User(++USERS_COUNT, "Erketai", 24));
        users.add( new User(++USERS_COUNT, "Viktor", 21));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(users -> users.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS_COUNT);
        users.add(user);
    }
}
