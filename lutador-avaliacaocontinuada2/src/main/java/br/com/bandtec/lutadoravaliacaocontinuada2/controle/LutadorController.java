package br.com.bandtec.lutadoravaliacaocontinuada2.controle;

import br.com.bandtec.lutadoravaliacaocontinuada2.dominio.Lutador;
import br.com.bandtec.lutadoravaliacaocontinuada2.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
//        return "Novo lutador cadastrado";
    }

    @GetMapping
    public ResponseEntity getLutador(){
        return ResponseEntity.status(200).body(repository.findAll());
    }
}
