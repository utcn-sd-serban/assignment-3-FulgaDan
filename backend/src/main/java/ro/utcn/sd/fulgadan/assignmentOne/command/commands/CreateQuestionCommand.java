package ro.utcn.sd.fulgadan.assignmentOne.command.commands;

import lombok.AllArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.command.Command;
import ro.utcn.sd.fulgadan.assignmentOne.dto.QuestionDTO;
import ro.utcn.sd.fulgadan.assignmentOne.services.QuestionService;

@AllArgsConstructor
public class CreateQuestionCommand implements Command {
    private QuestionDTO questionDTO;
    private QuestionService questionService;

    @Override
    public Object execute() {
        return questionService.addQuestion1(questionDTO);
    }
}
