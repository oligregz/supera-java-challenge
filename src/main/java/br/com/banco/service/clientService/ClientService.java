package br.com.banco.service.clientService;

import br.com.banco.domain.clientModel.ClientModel;
import br.com.banco.repository.clientRepository.ClientRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClientService {

  private final ClientRepository clientRepository;

  @Autowired
  public ClientService(ClientRepository clientRepository) {
    this.clientRepository = clientRepository;
  }

  public List<ClientModel> getAllClients() {
    return clientRepository.findAll();
  }

  public Optional<ClientModel> getClientById(UUID id) {
    return clientRepository.findById(id);
  }

  public ClientModel createClient(ClientModel client) {
    return clientRepository.save(client);
  }

  public ClientModel updateClient(UUID id, ClientModel clientDetails) {
    Optional<ClientModel> optionalClient = clientRepository.findById(id);
    if (optionalClient.isPresent()) {
      ClientModel client = optionalClient.get();
      client.setName(clientDetails.getName());
      client.setEmail(clientDetails.getEmail());
      client.setPassword(clientDetails.getPassword());
      client.setTelephone(clientDetails.getTelephone());
      return clientRepository.save(client);
    }
    return null;
  }

  public void deleteClient(UUID id) {
    clientRepository.deleteById(id);
  } 
}
