package ro.utcn.sd.fulgadan.assignmentOne.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.fulgadan.assignmentOne.dto.QuestionDTO;
import ro.utcn.sd.fulgadan.assignmentOne.events.QuestionCreatedEvent;
import ro.utcn.sd.fulgadan.assignmentOne.exceptions.NoSuchQuestionException;
import ro.utcn.sd.fulgadan.assignmentOne.exceptions.NoSuchUserException;
import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.RepositoryFactory;

import javax.persistence.QueryTimeoutException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final RepositoryFactory repositoryFactory;
    private ApplicationEventPublisher eventPublisher;

    @Transactional
    public Question findById(Integer id){
        return repositoryFactory.createQuestionRepository().findById(id).orElseThrow(NoSuchQuestionException::new);
    }

    @Transactional
    public QuestionDTO addQuestion1(QuestionDTO questionDTO){
        Question question = new Question();
        question.setTitle(questionDTO.getTitle());
        question.setText(questionDTO.getText());
        question.setUserId(questionDTO.getUserId());
        question.setDate(question.getDate());
        QuestionDTO output =  QuestionDTO.ofEntity(repositoryFactory.createQuestionRepository().addQuestion(question));
        eventPublisher.publishEvent(new QuestionCreatedEvent(output));
        return output;
    }


    @Transactional
    public List<QuestionDTO> listQuestions() {
        List<Question> questions = repositoryFactory.createQuestionRepository().selectAll();
        List<QuestionDTO> questionDTOS = questions.stream().map(QuestionDTO::ofEntity).collect(Collectors.toList());
        return questionDTOS;
    }
}
