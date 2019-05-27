package ro.utcn.sd.fulgadan.assignmentOne.dto;

import lombok.Data;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;

@Data
public class UserDTO {

    private Integer id;
    private String username;
    private String password;

    public static UserDTO ofEntity(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }
}
