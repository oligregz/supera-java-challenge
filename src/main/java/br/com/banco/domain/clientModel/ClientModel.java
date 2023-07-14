package br.com.banco.domain.clientModel;

import br.com.banco.domain.accountModel.AccountModel;
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
@Table(name = "client_tb")
public class ClientModel implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private UUID id;

  private String name;

  private String email;

  private String password;

  private String telephone;

  @OneToOne
  @JoinColumn(name = "account_id")
  private AccountModel account;

  public ClientModel() {}
  
  public ClientModel(String name, String email, String password, String telephone) {
    super();
    this.name = name;
    this.email = email;
    this.password = password;
    this.telephone = telephone;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public AccountModel getAccount() {
    return account;
  }

  public void setAccount(AccountModel account) {
    this.account = account;
  }
}
