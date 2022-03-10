package de.neuefische.quizapp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question createNewQuestion(Question question) {

        return questionRepository.save(question);
    }

    public Optional<Question> findById(String id) {

        return questionRepository.findById(id);
    }
/*
    public List<Question> findByRating(String rating) {
        return questionRepository.findByRating(rating);
    }

 */


    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }


    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Optional<Question> patchQuestion(String id, Question question) {
        /*
        Optional<Joke> optionalJoke = jokeRepository.findById(id);
        if (optionalJoke.isPresent()) {
            Joke jokeFromDatabase = optionalJoke.get();
            if (joke.getJoke() != null) {
                jokeFromDatabase.setJoke(joke.getJoke());
            }
            if (joke.getRating() != null) {
                jokeFromDatabase.setRating(joke.getRating());
            }
            return Optional.of(jokeRepository.save(jokeFromDatabase));
        } else {
            return Optional.empty();
        }
         */

        return questionRepository.findById(id)
                .map(j -> j.patch(question))
                .map(j -> questionRepository.save(j));
    }
}