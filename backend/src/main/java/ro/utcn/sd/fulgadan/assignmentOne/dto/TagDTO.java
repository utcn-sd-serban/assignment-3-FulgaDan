package ro.utcn.sd.fulgadan.assignmentOne.dto;

import lombok.Data;
import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;

import java.util.List;

@Data
public class TagDTO {

    private Integer id;
    private String name;
    public static TagDTO ofEntity(Tag tag){
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());
        return tagDTO;
    }
}
