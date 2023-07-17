package br.com.banco.src.controller.conta;

import br.com.banco.src.exceptions.GeneralException;
import br.com.banco.src.exceptions.jsonException.ErrorMessage;
import br.com.banco.src.model.contaModel.ContaModel;
import br.com.banco.src.service.conta.ContaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("api/v1/contas")
public class ContaController {
  
  private final ContaService contaService;
  ErrorMessage erro = new ErrorMessage();

  @Autowired
  public ContaController(ContaService contaService) {
    this.contaService = contaService;
  }

  @PostMapping
  public ResponseEntity<ContaModel> criarConta(@RequestBody ContaModel conta) {
    try {
      ContaModel novaConta = contaService.criarConta(conta);
      return new ResponseEntity<>(novaConta, HttpStatus.CREATED);
    } catch (Exception e) {
      erro.setMessage(e.getMessage());
      throw new GeneralException(erro.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<ContaModel>> listarContas() {
    try {
      List<ContaModel> contas = contaService.listarContas();
      if (contas.isEmpty()) {
        throw new GeneralException("Accounts not found");
      }
      return new ResponseEntity<>(contas, HttpStatus.OK);
    } catch (Exception e) {
      erro.setMessage(e.getMessage());
      throw new GeneralException(erro.getMessage());
    }
  }
}
