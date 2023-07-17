package br.com.banco.src.model.contaModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta_tb")
public class ContaModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id_conta;

  private String nome_responsavel;

  public ContaModel() {}

  public ContaModel(String nome_responsavel) {
    this.nome_responsavel = nome_responsavel;
  }

  public Long getId_conta() {
    return id_conta;
  }

  public String getNome_responsavel() {
    return nome_responsavel;
  }

  public void setNome_responsavel(String nome_responsavel) {
    this.nome_responsavel = nome_responsavel;
  }
}
