package ro.utcn.sd.fulgadan.assignmentOne.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.fulgadan.assignmentOne.dto.TagDTO;
import ro.utcn.sd.fulgadan.assignmentOne.events.TagCreatedEvent;
import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.repositories.RepositoryFactory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {
    private final RepositoryFactory repositoryFactory;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public TagDTO addTag1(TagDTO tagDTO){
        Tag tag = new Tag();
        tag.setName(tagDTO.getName());
        TagDTO output = TagDTO.ofEntity(repositoryFactory.createTagRepository().addTag(tag));
        applicationEventPublisher.publishEvent(new TagCreatedEvent(output));
        return output;
    }

    @Transactional
    public List<TagDTO> listTags() {
        return repositoryFactory.createTagRepository().selectAll().stream().map(TagDTO::ofEntity).collect(Collectors.toList());
    }
}
