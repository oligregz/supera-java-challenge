package br.com.banco.src.exceptions.jsonException;

public class ErrorMessage {
  private String message;

  public ErrorMessage() {}

  public String getMessage() {
      return message;
  }

  public void setMessage(String message) {
      this.message = message;
  }
}