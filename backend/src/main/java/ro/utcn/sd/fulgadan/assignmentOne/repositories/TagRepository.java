package ro.utcn.sd.fulgadan.assignmentOne.repositories;

import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;

import java.util.List;
import java.util.Optional;


public interface TagRepository {
    Tag addTag(Tag tag);
    List<Tag> selectAll();
    Optional<Tag> findByName(String name);
    void delete(Tag tag);
}
