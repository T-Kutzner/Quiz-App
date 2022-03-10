package de.neuefische.quizapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuizAppApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        Question question = new Question();
        question.setQuestion("Wie heißt die Hauptstadt von Brasilien?");

        ResponseEntity<Question> postResponse = restTemplate.postForEntity("/api/quiz", question, Question.class);
        assertThat(postResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(postResponse.getBody().getId()).isNotNull();
        assertThat(postResponse.getBody().getQuestion()).isEqualTo("Wie heißt die Hauptstadt von Brasilien?");

        ResponseEntity<Question> getResponse = restTemplate.getForEntity("/api/quiz/" + postResponse.getBody().getId(), Question.class);
        assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(getResponse.getBody().getId()).isNotNull();
        assertThat(getResponse.getBody().getQuestion()).isEqualTo("Wie heißt die Hauptstadt von Brasilien?");
    }
}