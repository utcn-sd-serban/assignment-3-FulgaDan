package ro.utcn.sd.fulgadan.assignmentOne.command.commands;

import lombok.AllArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.command.Command;
import ro.utcn.sd.fulgadan.assignmentOne.dto.TagDTO;
import ro.utcn.sd.fulgadan.assignmentOne.services.TagService;

@AllArgsConstructor
public class CreateTagCommand implements Command {
    private TagDTO tagDTO;
    private TagService tagService;

    @Override
    public Object execute() {
        return tagService.addTag1(tagDTO);
    }
}
