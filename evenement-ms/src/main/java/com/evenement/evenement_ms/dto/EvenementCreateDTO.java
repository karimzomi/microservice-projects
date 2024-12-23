package com.evenement.evenement_ms.dto;

import java.util.Date;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EvenementCreateDTO {
    private String nomEvenement;
    private Integer nbPlaces;
    private Date dateEvenement;

    private List<Long> categories;
}
