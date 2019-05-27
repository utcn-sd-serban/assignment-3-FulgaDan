package ro.utcn.sd.fulgadan.assignmentOne.repositories.memory;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.*;

@Component
@ConditionalOnProperty(name = "assignmentOne.repository-type", havingValue = "memory")
public class InMemoryRepositoryFactory implements RepositoryFactory {

    private final InMemoryUserRepository inMemoryUserRepository = new InMemoryUserRepository();
    private final InMemoryQuestionRepository inMemoryQuestionRepository = new InMemoryQuestionRepository();
    private final InMemoryTagRepository inMemoryTagRepository = new InMemoryTagRepository();


    @Override
    public UserRepository createUserRepository() {
        return inMemoryUserRepository;
    }

    @Override
    public QuestionRepository createQuestionRepository() {
        return inMemoryQuestionRepository;
    }

    @Override
    public TagRepository createTagRepository() {
        return inMemoryTagRepository;
    }

}
