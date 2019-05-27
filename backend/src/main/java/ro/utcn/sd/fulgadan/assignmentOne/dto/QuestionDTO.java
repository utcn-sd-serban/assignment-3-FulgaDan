package ro.utcn.sd.fulgadan.assignmentOne.dto;

import lombok.Data;
import org.springframework.util.CollectionUtils;
import ro.utcn.sd.fulgadan.assignmentOne.models.Question;
import ro.utcn.sd.fulgadan.assignmentOne.models.Tag;
import ro.utcn.sd.fulgadan.assignmentOne.models.User;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class QuestionDTO {
    private Integer id;
    private String username;
    private Integer userId;
    private String title;
    private String text;
    private Instant date;
    private List<String> tags;

    public static QuestionDTO ofEntity(Question question) {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setId(question.getId());
        questionDTO.setUserId(question.getUserId());
        questionDTO.setTitle(question.getTitle());
        questionDTO.setText(question.getText());
        questionDTO.setDate(question.getDate());
        if(!CollectionUtils.isEmpty(question.getTags())){
            questionDTO.setTags(question.getTags().stream()
                    .map(Tag::getName)
                    .collect(Collectors.toList()));
        }
        return questionDTO;
    }
}
