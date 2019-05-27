package ro.utcn.sd.fulgadan.assignmentOne.command;

import org.springframework.stereotype.Component;

@Component
public class Invoker {

    private Command command;

    public Object invoke(){
        return this.command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

}
