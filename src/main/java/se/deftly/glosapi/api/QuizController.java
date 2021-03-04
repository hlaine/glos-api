package se.deftly.glosapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.deftly.glosapi.domain.Word;
import se.deftly.glosapi.service.WordService;

@RestController
public class QuizController {

    @Autowired
    private WordService wordService;

    @GetMapping("/q/words")
    public ResponseEntity<Word> getWord() {
        Word word = wordService.getRandomWord();
        return ResponseEntity.ok(word);
    }

    @GetMapping("/q/words/{category}")
    public ResponseEntity<Word> getWordByCategory(@PathVariable String category) {
        Word word = wordService.getRandomWordByCategory(category);
        return ResponseEntity.ok(word);
    }
}
