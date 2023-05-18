package br.com.meli.domain.dto;


import br.com.meli.domain.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisicaDto extends PessoaDto {

        private Long idPF;
        private String cpf;


}
