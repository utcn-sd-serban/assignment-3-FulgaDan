package ro.utcn.sd.fulgadan.assignmentOne.repositories.jpa;

import lombok.RequiredArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.QuestionRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class HibernateQuestionRepository implements QuestionRepository {

    private final EntityManager entityManager;

    @Override
    public Optional<Question> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Question.class, id));
    }

    @Override
    public List<Question> selectAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Question> query = builder.createQuery(Question.class);
        query.select(query.from(Question.class));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void delete(Question question) {

    }


    @Override
    public Question addQuestion(Question question) {
        if(question.getId() ==  null) entityManager.persist(question);
        return entityManager.merge(question);
    }
}
