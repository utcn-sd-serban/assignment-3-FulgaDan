package ro.utcn.sd.fulgadan.assignmentOne.repositories.memory;

import ro.utcn.sd.fulgadan.assignmentOne.models.User;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryUserRepository implements UserRepository {
    private final Map<Integer, User> userMap = new ConcurrentHashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(0);

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userMap.get(id));
    }

    @Override
    public void delete(User user) {
        userMap.remove(user);
    }

    @Override
    public List<User> selectAll() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User addUser(User user) {
        if (user.getId() == null) {
            user.setId(currentId.incrementAndGet());
        }
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findByName(String username) {
        return this.selectAll().stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }



}
