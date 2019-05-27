package ro.utcn.sd.fulgadan.assignmentOne.repositories;

import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {
    Optional<Question> findById(Integer id);
    List<Question> selectAll();
    void delete(Question question);
    Question addQuestion(Question question);
}
