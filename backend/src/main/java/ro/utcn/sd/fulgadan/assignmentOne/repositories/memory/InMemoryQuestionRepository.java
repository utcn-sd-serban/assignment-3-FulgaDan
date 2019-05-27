package ro.utcn.sd.fulgadan.assignmentOne.repositories.memory;

import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryQuestionRepository implements QuestionRepository {
    private final Map<Integer, Question> questionMap = new ConcurrentHashMap<>();
    private final AtomicInteger currentId = new AtomicInteger(0);

    @Override
    public Optional<Question> findById(Integer id) {
        return Optional.ofNullable(questionMap.get(id));
    }


    @Override
    public List<Question> selectAll() {
        return new ArrayList<>(questionMap.values());
    }

    @Override
    public void delete(Question question) {
        questionMap.remove(question);
    }


    @Override
    public Question addQuestion(Question question) {
        if (question.getId() == null) {
            question.setId(currentId.incrementAndGet());
        }
        questionMap.put(question.getId(), question);
        return question;
    }
}
