package br.com.claudiowork.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bitcoin {
    private Long id;
    private Double preco;
    private String tipo;
    private LocalDate data;
}
