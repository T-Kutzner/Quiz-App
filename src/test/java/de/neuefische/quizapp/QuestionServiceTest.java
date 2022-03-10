package de.neuefische.quizapp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class QuestionServiceTest {

    @Test
    void shouldCreateNewQuestion() {
        // Given
        Question questionToCreate = new Question();
        questionToCreate.setQuestion("Wofür steht DB in der Informatik?");

        Question savedQuestion = new Question();
        savedQuestion.setId("4711");
        savedQuestion.setQuestion("Wofür steht DB in der Informatik?");

        QuestionRepository questionRepository = mock(QuestionRepository.class);
        Mockito.when(questionRepository.save(questionToCreate)).thenReturn(savedQuestion);

        QuestionService questionService = new QuestionService(questionRepository);

        // When
        Question result = questionService.createNewQuestion(questionToCreate);

        // Then
        Assertions.assertThat(result).isSameAs(savedQuestion);
    }
}