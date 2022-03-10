package de.neuefische.quizapp;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Question {

    @Id
    private String id;
    private String question;
    //private Answer answer;

    public Question patch(Question question) {

        if (question.getQuestion() != null) {
            setQuestion(question.getQuestion());
        }

        return this;
    }
}