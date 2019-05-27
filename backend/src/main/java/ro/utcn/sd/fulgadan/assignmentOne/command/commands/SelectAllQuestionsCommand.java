package ro.utcn.sd.fulgadan.assignmentOne.command.commands;

import lombok.AllArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.command.Command;
import ro.utcn.sd.fulgadan.assignmentOne.services.QuestionService;

@AllArgsConstructor
public class SelectAllQuestionsCommand implements Command {

    private QuestionService questionService;

    @Override
    public Object execute() {
        return questionService.listQuestions();
    }
}
