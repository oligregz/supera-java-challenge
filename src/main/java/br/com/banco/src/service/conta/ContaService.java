package br.com.banco.src.service.conta;

import br.com.banco.src.model.contaModel.ContaModel;
import br.com.banco.src.repository.conta.ContaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContaService {

  private ContaRepository contaRepository;
  
  @Autowired
  public ContaService(ContaRepository contaRepository) {
    this.contaRepository = contaRepository;
  }

  public ContaModel criarConta(ContaModel conta) {
    return contaRepository.save(conta);
  }

  public List<ContaModel> listarContas() {
    return contaRepository.findAll();
  }
}
