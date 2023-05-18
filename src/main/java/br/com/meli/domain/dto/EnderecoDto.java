package br.com.meli.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {

    private Long id;
    private String logradouro;
    private String cep;
    private UfDto ufDto;

}
