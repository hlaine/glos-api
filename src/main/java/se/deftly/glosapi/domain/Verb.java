package se.deftly.glosapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
public class Verb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Modality modality;

    @Enumerated(EnumType.STRING)
    private Tense tense;

    private String val;

    @JsonIgnore
    private String conjugationList;

    public List<Conjugation> getConjugations() {
        return Arrays.stream(conjugationList.split(";"))
                .map(s -> {
                    String[] pair = s.split("=");
                    return new Conjugation(pair[1], pair[0]);
        }).collect(Collectors.toList());
    }
}
