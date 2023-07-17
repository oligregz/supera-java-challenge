package br.com.banco.src.repository.conta;

import br.com.banco.src.model.contaModel.ContaModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContaRepository extends JpaRepository<ContaModel, Long> { 
  
}
