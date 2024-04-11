package org.ntnu.idi.idatt2105.project.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ntnu.idi.idatt2105.project.entity.quiz.Quiz;

/** Class representing a category in the application. */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "category")
@Schema(description = "A quiz category for categorizing quizzes.")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The category id, autogenerated by the database.")
    private Long category_id;

    @Column(name = "category_name", nullable = false)
    @Schema(description = "The name of the category.")
    private String categoryName;

    @OneToMany(mappedBy = "category", orphanRemoval = true)
    @JsonIgnore
    @Schema(description = "The list of quizzes in the category.")
    private List<Quiz> quizList;
}