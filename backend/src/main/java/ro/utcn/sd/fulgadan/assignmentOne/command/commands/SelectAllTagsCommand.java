package ro.utcn.sd.fulgadan.assignmentOne.command.commands;

import lombok.AllArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.command.Command;
import ro.utcn.sd.fulgadan.assignmentOne.dto.TagDTO;
import ro.utcn.sd.fulgadan.assignmentOne.services.TagService;

@AllArgsConstructor
public class SelectAllTagsCommand implements Command {

    private TagService tagService;

    @Override
    public Object execute() {
        return tagService.listTags();
    }
}
