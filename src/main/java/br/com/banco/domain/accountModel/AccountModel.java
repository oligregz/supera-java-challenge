package br.com.banco.domain.accountModel;

import br.com.banco.domain.clientModel.ClientModel;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "account_tb")
public class AccountModel implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;
  
  private Long number;
  
  private Double amount;
  
  @OneToOne
  @JoinColumn(name = "client_id")
  private ClientModel holder;
  
  // private Transactions transactions;
  
  public AccountModel() {}
  
  public AccountModel(Long number, Double amount, ClientModel holder) {
    super();
    this.number = number;
    this.amount = amount;
    this.holder = holder;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public UUID getId() {
    return id;
  }

  public Long getNumber() {
    return number;
  }

  public void setNumber(Long number) {
    this.number = number;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public ClientModel getHolder() {
    return holder;
  }

  public void setHolder(ClientModel holder) {
    this.holder = holder;
  }
}
