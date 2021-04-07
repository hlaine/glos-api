package se.deftly.glosapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Conjugation {
    private String val;
    private String translated;
}
