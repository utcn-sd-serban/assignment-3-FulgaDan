package ro.utcn.sd.fulgadan.assignmentOne.repositories.memory;

import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryTagRepository implements TagRepository {
    private Map<Integer, Tag> tagMap = new ConcurrentHashMap<>();
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Tag addTag(Tag tag) {
        if(tag.getId() == null){
            tag.setId(atomicInteger.incrementAndGet());
        }
        tagMap.put(tag.getId(), tag);
        return tag;
    }

    @Override
    public List<Tag> selectAll() {
        return new ArrayList<>(tagMap.values());
    }

    @Override
    public Optional<Tag> findByName(String name) {
        return Optional.ofNullable(tagMap.get(name));
    }

    @Override
    public void delete(Tag tag) {
        tagMap.remove(tag);
    }
}
