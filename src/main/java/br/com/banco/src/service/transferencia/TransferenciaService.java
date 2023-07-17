package br.com.banco.src.service.transferencia;

import br.com.banco.src.model.tranferenciaModel.TransferenciaModel;
import br.com.banco.src.repository.transerencia.TransferenciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransferenciaService {
    
  private TransferenciaRepository transferenciaRepository;

  @Autowired
  public TransferenciaService (
    TransferenciaRepository transferenciaRepository
  ) {
    this.transferenciaRepository = transferenciaRepository;
  }

  public TransferenciaModel criarTransferencia(TransferenciaModel transferencia) {
    return transferenciaRepository.save(transferencia);
  }

  public List<TransferenciaModel> listarTransferencias() {
    return transferenciaRepository.findAll();
  }
} 