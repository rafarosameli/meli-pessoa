package br.com.meli.controller;

import br.com.meli.domain.dto.PessoaFisicaDto;
import br.com.meli.domain.model.Pessoa;
import br.com.meli.domain.model.PessoaFisica;
import br.com.meli.service.PessoaFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa-fisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaService pessoaFisicaService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody PessoaFisicaDto pessoaFisicaDto){
        return new ResponseEntity<>(pessoaFisicaService.create(pessoaFisicaDto), HttpStatus.CREATED);
    }

}
