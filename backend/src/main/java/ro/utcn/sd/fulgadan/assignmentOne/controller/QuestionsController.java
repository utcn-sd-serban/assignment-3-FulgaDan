package ro.utcn.sd.fulgadan.assignmentOne.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.fulgadan.assignmentOne.command.commands.CreateQuestionCommand;
import ro.utcn.sd.fulgadan.assignmentOne.command.Invoker;
import ro.utcn.sd.fulgadan.assignmentOne.command.commands.SelectAllQuestionsCommand;
import ro.utcn.sd.fulgadan.assignmentOne.dto.QuestionDTO;
import ro.utcn.sd.fulgadan.assignmentOne.events.BaseEvent;
import ro.utcn.sd.fulgadan.assignmentOne.services.QuestionService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionService questionService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final Invoker invoker;

    @GetMapping("/questions")
    public Object readAll(){
        invoker.setCommand(new SelectAllQuestionsCommand(questionService));
        return invoker.invoke();
    }

    @PostMapping("/questions")
    public Object create(@RequestBody QuestionDTO questionDTO) {
        invoker.setCommand(new CreateQuestionCommand(questionDTO, questionService));
        return invoker.invoke();
    }

    @EventListener(BaseEvent.class)
    public void handleEvent(BaseEvent baseEvent){
        log.info("Got an event: {}. " +  baseEvent);
        simpMessagingTemplate.convertAndSend("/topic/events", baseEvent);
    }
}
