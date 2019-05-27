package ro.utcn.sd.fulgadan.assignmentOne.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ro.utcn.sd.fulgadan.assignmentOne.dto.TagDTO;

@Data
@EqualsAndHashCode(callSuper = true)
public class TagCreatedEvent extends BaseEvent {
    private final TagDTO tagDTO;

    public TagCreatedEvent(TagDTO tagDTO){
        super(EventType.TAG_CREATED);
        this.tagDTO = tagDTO;
    }
}
