package ro.utcn.sd.fulgadan.assignmentOne.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.fulgadan.assignmentOne.command.Invoker;
import ro.utcn.sd.fulgadan.assignmentOne.command.commands.SelectAllUsersCommand;
import ro.utcn.sd.fulgadan.assignmentOne.dto.UserDTO;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;
import ro.utcn.sd.fulgadan.assignmentOne.services.UserService;
import ro.utcn.sd.fulgadan.assignmentOne.services.UserUserDetailsService;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;
    private final UserUserDetailsService userUserDetailsService;
    private final Invoker invoker;

    @GetMapping("/users")
    public Object readAll() {
        invoker.setCommand(new SelectAllUsersCommand(userService));
        return invoker.invoke();
    }

    @PostMapping("/users")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.addUser1(userDTO);
    }

    @GetMapping("/me")
    public User readCurrent(){
        return userUserDetailsService.loadCurrentUser();
    }
}
