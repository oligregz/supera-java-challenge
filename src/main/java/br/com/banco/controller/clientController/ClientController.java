package br.com.banco.controller.clientController;

import br.com.banco.domain.clientModel.ClientModel;
import br.com.banco.service.clientService.ClientService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientService clientService;

  @Autowired
  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @GetMapping
  public ResponseEntity<List<ClientModel>> getAllClients() {
    List<ClientModel> clients = clientService.getAllClients();
    return ResponseEntity.ok(clients);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClientModel> getClientById(@PathVariable UUID id) {
    Optional<ClientModel> client = clientService.getClientById(id);
    return client.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<ClientModel> createClient(@RequestBody ClientModel client) {
    ClientModel createdClient = clientService.createClient(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ClientModel> updateClient(@PathVariable UUID id, @RequestBody ClientModel clientDetails) {
    ClientModel updatedClient = clientService.updateClient(id, clientDetails);
    if (updatedClient != null) {
      return ResponseEntity.ok(updatedClient);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable UUID id) {
    clientService.deleteClient(id);
    return ResponseEntity.noContent().build();
  }
}