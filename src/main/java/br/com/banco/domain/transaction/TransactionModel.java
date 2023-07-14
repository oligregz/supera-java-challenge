package br.com.banco.domain.transaction;

import br.com.banco.domain.accountModel.AccountModel;
import br.com.banco.domain.transaction.types.TransactionType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "transaction_tb")
public class TransactionModel implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  private double value;

  private LocalDateTime moment;

  private TransactionType type;


  @ManyToOne
  @JoinColumn(name = "account_id")
  private AccountModel account;

  public TransactionModel() {}
  
  public TransactionModel(double value, LocalDateTime moment) {
    this.value = value;
    this.moment = moment;
  }

  public UUID getId() {
    return id;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }

  public LocalDateTime getMoment() {
    return moment;
  }

  public void setMoment(LocalDateTime moment) {
    this.moment = moment;
  }

  public TransactionType getType() {
    return type;
  }

  public void setTransactionType(TransactionType type) {
    this.type = type;
  }

  public AccountModel getAccount() {
    return account;
  }
}
