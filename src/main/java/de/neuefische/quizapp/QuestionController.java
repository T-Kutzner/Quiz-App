package de.neuefische.quizapp;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    public Question createNewQuestion(@RequestBody Question question) {
        return questionService.createNewQuestion(question);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable String id) {
        return ResponseEntity.of(questionService.findById(id));
    }

    @GetMapping
    public List<Question> findAllQuestions() {
        return questionService.findAllQuestions();
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable String id, @RequestBody Question question) {
        question.setId(id);
        return questionService.updateQuestion(question);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Question> patchQuestion(@PathVariable String id, @RequestBody Question question) {
        return ResponseEntity.of(questionService.patchQuestion(id, question));
    }
}