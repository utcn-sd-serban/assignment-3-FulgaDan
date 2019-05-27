package ro.utcn.sd.fulgadan.assignmentOne.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.fulgadan.assignmentOne.dto.UserDTO;
import ro.utcn.sd.fulgadan.assignmentOne.exceptions.NoSuchUserException;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.RepositoryFactory;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final RepositoryFactory repositoryFactory;

    @Transactional
    public User findById(int id){
        return repositoryFactory.createUserRepository().findById(id).orElseThrow(NoSuchUserException::new);
    }

    @Transactional
    public List<UserDTO> listUsers() {
        return repositoryFactory.createUserRepository().selectAll().stream().map(UserDTO::ofEntity).collect(Collectors.toList());
    }

    @Transactional
    public UserDTO addUser1(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return UserDTO.ofEntity(repositoryFactory.createUserRepository().addUser(user));
    }
    @Transactional
    public void deleteUser(int id) {
        UserRepository repository = repositoryFactory.createUserRepository();
        User user = repository.findById(id).orElseThrow(NoSuchUserException::new);
        repository.delete(user);
    }
    @Transactional
    public UserDTO login(String username, String password){
        for(UserDTO userDTO : listUsers()){
            if(userDTO.getUsername().equals(username) && userDTO.getPassword().equals(password)){
                return userDTO;
            }
            else throw new NoSuchUserException();
        }
        throw new NoSuchUserException();
    }
}
