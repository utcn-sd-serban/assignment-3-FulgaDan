package ro.utcn.sd.fulgadan.assignmentOne.repositories;

import ro.utcn.sd.fulgadan.assignmentOne.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Integer id);
    void delete(User user);
    List<User> selectAll();
    User addUser(User user);
    java.util.Optional<User> findByName(String username);

}
