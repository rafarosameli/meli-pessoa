package br.com.meli.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pessoa_fisica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String cpf;

    @OneToOne
    @JoinColumn(name = "fk_pessoa")
    private Pessoa pessoa;
}
