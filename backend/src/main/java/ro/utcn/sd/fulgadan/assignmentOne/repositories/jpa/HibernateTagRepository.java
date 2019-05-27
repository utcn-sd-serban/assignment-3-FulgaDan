package ro.utcn.sd.fulgadan.assignmentOne.repositories.jpa;

import lombok.AllArgsConstructor;
import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.TagRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class HibernateTagRepository implements TagRepository {
    private final EntityManager entityManager;

    @Override
    public Tag addTag(Tag tag) {
        if(tag.getId() == null ) {
            entityManager.persist(tag);
        }
        return entityManager.merge(tag);
    }

    @Override
    public List<Tag> selectAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tag> query = builder.createQuery(Tag.class);
        query.select(query.from(Tag.class));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Optional<Tag> findByName(String name) {
        return Optional.ofNullable(entityManager.find(Tag.class, name));
    }

    @Override
    public void delete(Tag tag) {

    }


}
