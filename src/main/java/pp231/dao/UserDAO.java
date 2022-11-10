package pp231.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pp231.models.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional(readOnly = true)
    public List<User> index() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

//    public User show(int id) {
//        return users.stream().filter(users -> users.getId() == id).findAny().orElse(null);
//    }
//
    public void save(User user) {
        sessionFactory.openSession().save(user);
    }
//
//    public void update(int id, User user) {
//        User userToUpdate = show(id);
//        userToUpdate.setAge(user.getAge());
//        userToUpdate.setName(user.getName());
//
//    }
//
//    public void deleteUser(int id) {
//        users.removeIf(user -> user.getId() == id);
//    }
}
