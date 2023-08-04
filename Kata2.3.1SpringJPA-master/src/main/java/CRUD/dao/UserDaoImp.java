package CRUD.dao;

import CRUD.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(User user) {
        em.persist(user);
        em.flush();
    }

    @Override
    public void removeUserById(long id) {
        em.createQuery("delete from User i where i.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.flush();
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void updateUserById(long id, String firstName, String lastName, String email) {
        em.createQuery("update User u set u.firstName=:name, u.lastName=:lastname, u.email=:email where u.id=:id")
                .setParameter("name", firstName)
                .setParameter("lastname", lastName)
                .setParameter("email", email)
                .setParameter("id", id)
                .executeUpdate();
        em.flush();
    }
}
