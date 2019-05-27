package ro.utcn.sd.fulgadan.assignmentOne.command.commands;

import lombok.AllArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.command.Command;
import ro.utcn.sd.fulgadan.assignmentOne.services.UserService;

@AllArgsConstructor
public class SelectAllUsersCommand implements Command {

    private UserService userService;

    @Override
    public Object execute() {
        return userService.listUsers();
    }
}
