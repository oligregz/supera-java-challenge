package br.com.banco.src.controller.transferencia;

import br.com.banco.src.exceptions.GeneralException;
import br.com.banco.src.exceptions.jsonException.ErrorMessage;
import br.com.banco.src.model.tranferenciaModel.TransferenciaModel;
import br.com.banco.src.service.transferencia.TransferenciaService;
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
@RequestMapping("api/v1/transferencias")
public class TransferenciaController {
  
  private TransferenciaService transferenciaService;
  ErrorMessage erro = new ErrorMessage();
  
  @Autowired
  public TransferenciaController(TransferenciaService transferenciaService) {
    this.transferenciaService = transferenciaService;
  }

  @PostMapping
  public ResponseEntity<TransferenciaModel> criarTransferencia(@RequestBody TransferenciaModel transferencia) {
    try {
      TransferenciaModel novaTransferencia = transferenciaService.criarTransferencia(transferencia);
      if (novaTransferencia == null) {
        return new ResponseEntity<>(novaTransferencia, HttpStatus.NOT_IMPLEMENTED);
      }
      return new ResponseEntity<>(novaTransferencia, HttpStatus.CREATED);
    } catch (Exception e) {
      erro.setMessage(e.getMessage());
      throw new GeneralException(erro.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<List<TransferenciaModel>> listarTransferencias() {
    try {
      List<TransferenciaModel> transferencias = transferenciaService.listarTransferencias();
      if(transferencias.isEmpty()) {
        erro.setMessage("Transfers not found");
        throw new GeneralException(erro.getMessage());
      } else {
        return new ResponseEntity<>(transferencias, HttpStatus.OK);
      }
    } catch (Exception e) {
      erro.setMessage(e.getMessage());
      throw new GeneralException(erro.getMessage());
    }
  }
}
