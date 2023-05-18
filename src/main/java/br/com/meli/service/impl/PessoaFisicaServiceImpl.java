package br.com.meli.service.impl;

import br.com.meli.domain.dto.PessoaFisicaDto;
import br.com.meli.domain.model.Endereco;
import br.com.meli.domain.model.Pessoa;
import br.com.meli.domain.model.PessoaFisica;
import br.com.meli.domain.model.Uf;
import br.com.meli.repository.EnderecoRepository;
import br.com.meli.repository.PessoaFisicaRepository;
import br.com.meli.repository.PessoaRepository;
import br.com.meli.repository.UfRepository;
import br.com.meli.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaFisicaServiceImpl implements PessoaFisicaService {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private UfRepository ufRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;



    public PessoaFisicaDto create(PessoaFisicaDto pessoaFisicaDto){
        PessoaFisica pessoaFisica = new PessoaFisica();
        pessoaFisica.setCpf(pessoaFisicaDto.getCpf());
        pessoaFisica.setPessoa(preencherPessoa(pessoaFisicaDto));
        pessoaFisicaRepository.save(pessoaFisica);


        pessoaFisicaDto.setIdPF(pessoaFisica.getId());
        return pessoaFisicaDto;

    }

    private Uf preencherUf(PessoaFisicaDto pessoaFisicaDto){
        Uf uf = new Uf();
        uf.setNome(pessoaFisicaDto.getEnderecoDto().getUfDto().getNome());
        ufRepository.save(uf);
        return uf;
    }

    private Endereco preencherEndereco(PessoaFisicaDto pessoaFisicaDto){
        Endereco endereco = new Endereco();
        endereco.setCep(pessoaFisicaDto.getEnderecoDto().getCep());
        endereco.setLogradouro(pessoaFisicaDto.getEnderecoDto().getLogradouro());
        endereco.setUf(preencherUf(pessoaFisicaDto));
        enderecoRepository.save(endereco);
        return endereco;
    }

    private Pessoa preencherPessoa(PessoaFisicaDto pessoaFisicaDto){
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail(pessoaFisicaDto.getEmail());
        pessoa.setNome(pessoaFisicaDto.getNome());
        pessoa.setEndereco(preencherEndereco(pessoaFisicaDto));
        pessoaRepository.save(pessoa);

        return pessoa;
    }
}
