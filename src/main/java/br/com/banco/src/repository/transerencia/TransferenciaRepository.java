package br.com.banco.src.repository.transerencia;

import br.com.banco.src.model.tranferenciaModel.TransferenciaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Long> {}
