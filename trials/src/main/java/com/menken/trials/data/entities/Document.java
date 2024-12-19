package com.menken.trials.data.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String documentType;

    private BigDecimal weight;

    public Document(String documentType, BigDecimal weight) {
        this.documentType = documentType;
        this.weight = weight;
    }
}
