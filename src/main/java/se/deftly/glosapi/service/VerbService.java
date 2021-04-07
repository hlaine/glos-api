package se.deftly.glosapi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.deftly.glosapi.domain.Verb;
import se.deftly.glosapi.domain.VerbRepository;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class VerbService {

    @Autowired
    private VerbRepository verbRepository;

    public Verb getRandomVerb() {
        return getRandomWordFromList(getAllVerbs());
    }

    private Verb getRandomWordFromList(List<Verb> verbs) {
        return verbs.get(new Random().nextInt(verbs.size()));
    }

    @Transactional(readOnly = true)
    @Cacheable("all-verbs")
    public List<Verb> getAllVerbs() {
        return verbRepository.findAll();
    }
}
