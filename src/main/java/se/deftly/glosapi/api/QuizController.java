package se.deftly.glosapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import se.deftly.glosapi.domain.Verb;
import se.deftly.glosapi.domain.Word;
import se.deftly.glosapi.service.VerbService;
import se.deftly.glosapi.service.WordService;

@CrossOrigin(origins = {"http://deftly.se", "http://quiz.deftly.se", "http://glosor.deftly.se"})
@RestController
public class QuizController {

    @Autowired
    private WordService wordService;

    @Autowired
    private VerbService verbService;

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

    @GetMapping("/q/verbs")
    public ResponseEntity<Verb> getWordByCategory() {
        Verb verb = verbService.getRandomVerb();
        return ResponseEntity.ok(verb);
    }
}
