package br.com.bandtec.lutadoravaliacaocontinuada2.repositorio;

import br.com.bandtec.lutadoravaliacaocontinuada2.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LutadorRepository extends JpaRepository<Lutador, Integer> {
    List<Lutador> findByVidaTrue();
    List<Lutador> findByVidaFalse();
}
