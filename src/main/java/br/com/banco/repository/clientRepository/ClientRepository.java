package br.com.banco.repository.clientRepository;

import br.com.banco.domain.clientModel.ClientModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
}
