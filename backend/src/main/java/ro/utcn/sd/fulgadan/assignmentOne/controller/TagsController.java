package ro.utcn.sd.fulgadan.assignmentOne.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.fulgadan.assignmentOne.command.commands.CreateTagCommand;
import ro.utcn.sd.fulgadan.assignmentOne.command.Invoker;
import ro.utcn.sd.fulgadan.assignmentOne.command.commands.SelectAllTagsCommand;
import ro.utcn.sd.fulgadan.assignmentOne.dto.TagDTO;
import ro.utcn.sd.fulgadan.assignmentOne.services.TagService;

@RestController
@RequiredArgsConstructor
public class TagsController {
    private final TagService tagService;
    private final Invoker invoker;

    @GetMapping("/tags")
    public Object readAll() {
        invoker.setCommand(new SelectAllTagsCommand(tagService));
        return invoker.invoke();
    }

    @PostMapping("/tags")
    public Object create(@RequestBody TagDTO tagDTO) {
        invoker.setCommand(new CreateTagCommand(tagDTO, tagService));
        return invoker.invoke();
    }
}
