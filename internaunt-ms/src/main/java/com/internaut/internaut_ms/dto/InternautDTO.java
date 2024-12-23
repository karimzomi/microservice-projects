package com.internaut.internaut_ms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.internaut.internaut_ms.enums.TrancheAge;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InternautDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long idInternaut;
    private String identifiant;
    private TrancheAge trancheAge;
}