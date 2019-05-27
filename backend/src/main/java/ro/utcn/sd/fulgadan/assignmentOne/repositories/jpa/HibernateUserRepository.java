package ro.utcn.sd.fulgadan.assignmentOne.repositories.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class HibernateUserRepository implements UserRepository {
    private final EntityManager entityManager;

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }


    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> selectAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        query.select(query.from(User.class));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public User addUser(User user) {
        if(user.getId() == null) entityManager.persist(user);
        return entityManager.merge(user);
    }

    @Override
    public Optional<User> findByName(String username) {
        return null;
    }



}
