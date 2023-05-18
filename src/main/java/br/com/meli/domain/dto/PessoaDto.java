package br.com.meli.domain.dto;

import br.com.meli.domain.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {

    private Long idPessoa;

    private String nome;

    private String email;

    private EnderecoDto enderecoDto;

}
