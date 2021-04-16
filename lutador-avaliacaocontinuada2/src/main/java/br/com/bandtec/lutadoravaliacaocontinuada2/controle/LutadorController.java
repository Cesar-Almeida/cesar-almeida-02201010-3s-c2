package br.com.bandtec.lutadoravaliacaocontinuada2.controle;

import br.com.bandtec.lutadoravaliacaocontinuada2.dominio.Lutador;
import br.com.bandtec.lutadoravaliacaocontinuada2.repositorio.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

//    @GetMapping("/contagem-vivos")
//    public ResponseEntity getContagemVivos(){
//        List<Lutador> lutador = repository.findByVidaFalse();
//        int vivo = 0;
//        for (Lutador sobrevivendo : lutador){
//            vivo++;
//        }
//        return ResponseEntity.status(200).body(vivo);
//    }
//
//    @GetMapping("/mortos")
//    public ResponseEntity getContagemMortos(){
//        List<Lutador> lutadores
//
//        return ResponseEntity.status(200).body(repository.findByVidaFalse());
//    }

    @PostMapping("/{id}/concentrar")
    public ResponseEntity postConcentrar(@PathVariable Integer id){
        if (!repository.existsById(id)){
            return ResponseEntity.status(400).body("Lutador não existe");
        }else {
            Lutador lutador = repository.findById(id).get();
            if (lutador.getConcentracoesRealizadas()<=3){
                lutador.setConcentracoesRealizadas(lutador.getConcentracoesRealizadas()+1);
                lutador.setVida(lutador.getVida()*1.15);
                repository.save(lutador);
                return ResponseEntity.status(201).build();
            }else {
                return ResponseEntity.status(400).body("Lutador já se concentrou 3 vezes!");
            }
        }
    }

//    @PostMapping("/golpe")
//    public ResponseEntity postGolpe(@RequestBody @Valid Lutador novoLutador){
//        repository.save(id);
//        return ResponseEntity.status(201).build();
//    }
}
