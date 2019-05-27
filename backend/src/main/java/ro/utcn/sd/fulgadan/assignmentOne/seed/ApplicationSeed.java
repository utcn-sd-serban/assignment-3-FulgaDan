package ro.utcn.sd.fulgadan.assignmentOne.seed;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.QuestionRepository;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.RepositoryFactory;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.TagRepository;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "assignmentOne.repository-type", havingValue = "memory")
public class ApplicationSeed implements CommandLineRunner {

    private final RepositoryFactory repositoryFactory;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) {
        UserRepository userRepository = repositoryFactory.createUserRepository();
        QuestionRepository questionRepository = repositoryFactory.createQuestionRepository();
        TagRepository tagRepository = repositoryFactory.createTagRepository();

        userRepository.addUser(new User(null, "user12", passwordEncoder.encode("user1")));
        userRepository.addUser(new User("user22", passwordEncoder.encode("user2")));
        userRepository.addUser(new User("user322", "user232"));
        User user = new User("miron", "costin");
        userRepository.addUser(user);

        tagRepository.addTag(new Tag(null, "java", null));
        tagRepository.addTag(new Tag(null, "react", null));
        Tag tag = new Tag(4, "tag1", null);
        Tag tag1 = new Tag(5, "tag2", null);
        List<Tag> tagList = new ArrayList<>();
        tagList.add(tag);
        tagList.add(tag1);

        questionRepository.addQuestion(new Question(1, user.getId(), "hello1", "question1", tagList));
        questionRepository.addQuestion(new Question(2, "hello2", "question2", tagList));
        questionRepository.addQuestion(new Question(3, user.getId(), "hello3", "question3", Instant.now(), tagList));
        questionRepository.addQuestion(new Question(4, "hello4", "question4"));

    }
}

