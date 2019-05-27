package ro.utcn.sd.fulgadan.assignmentOne.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id, user, title, text, date"})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;
    private String title;
    private String text;
    private Instant date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable( name = "question_tags", joinColumns = @JoinColumn(name = "question_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags;

    public Question(Integer userId, String title, String text, Instant date) {
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Question(Integer id, Integer userId, String title, String text, List<Tag> tags) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.tags = tags;
    }

    public Question(Integer id, String title, String text, List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.tags = tags;
    }

    public Question(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Question(String title, String text, List<Tag> tags) {
        this.title = title;
        this.text = text;
        this.tags = tags;
    }

}
