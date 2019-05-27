package ro.utcn.sd.fulgadan.assignmentOne.repositories;


public interface RepositoryFactory {
    UserRepository createUserRepository();
    QuestionRepository createQuestionRepository();
    TagRepository createTagRepository();
}
