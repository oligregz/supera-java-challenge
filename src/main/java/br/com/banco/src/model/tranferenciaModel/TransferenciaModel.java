package br.com.banco.src.model.tranferenciaModel;

import br.com.banco.src.model.contaModel.ContaModel;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transferencia_tb")
public class TransferenciaModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDateTime data_transferencia;

  private Double valor;

  private String tipo;

  private String nome_operador_transacao;

  @ManyToOne
  @JoinColumn(name = "conta_id")
  private ContaModel conta;

  public TransferenciaModel() {}

  public TransferenciaModel(
      LocalDateTime data_transferencia,
      Double valor,
      String tipo,
      String nome_operador_transacao
    ) {
    this.data_transferencia = data_transferencia;
    this.valor = valor;
    this.tipo = tipo;
    this.nome_operador_transacao = nome_operador_transacao;
  }

  public Long getId() {
    return id;
  }

  public LocalDateTime getData_transferencia() {
    return data_transferencia;
  }

  public void setData_transferencia(LocalDateTime data_transferencia) {
    this.data_transferencia = data_transferencia;
  }

  public Double getValor() {
    return valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getNome_operador_transacao() {
    return nome_operador_transacao;
  }

  public void setNome_operador_transacao(String nome_operador_transacao) {
    this.nome_operador_transacao = nome_operador_transacao;
  }

  public ContaModel getConta() {
    return conta;
  }

  public void setConta(ContaModel conta) {
    this.conta = conta;
  }
}
