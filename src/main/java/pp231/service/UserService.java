package pp231.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pp231.dao.UserDAO;
import pp231.models.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> showAllUsers() {
        return userDAO.showAllUsers();
    }

    public User getUserByUd(long id) {
        return userDAO.getUserByUd(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }
    public void update(User user) {
        userDAO.update(user);
    }

    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }
}
