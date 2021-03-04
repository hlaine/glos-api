package se.deftly.glosapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import se.deftly.glosapi.domain.Word;
import se.deftly.glosapi.domain.WordRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public Word getRandomWord() {
        return getRandomWordFromList(getAllWords());
    }

    public Word getRandomWordByCategory(String cat) {
        return getRandomWordFromList(getWordsByCategory(cat));
    }

    private Word getRandomWordFromList(List<Word> words) {
        return words.get(new Random().nextInt(words.size()));
    }

    @Cacheable("words-by-category")
    public List<Word> getWordsByCategory(String cat) {
        return getAllWords().stream()
                .filter(wq -> wq.getCategory().equalsIgnoreCase(cat))
                .collect(Collectors.toList());
    }

    @Cacheable("all-words")
    public List<Word> getAllWords() {
        return wordRepository.findAll();
    }
}
