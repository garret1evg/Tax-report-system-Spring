package ua.training.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.system.entity.Client;
import ua.training.system.entity.ClientType;
import ua.training.system.entity.Inspector;
import ua.training.system.entity.User;
import ua.training.system.repository.ClientRepository;
import ua.training.system.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    ClientRepository clientRepository;
    UserRepository userRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository, UserRepository userRepository) {
        this.clientRepository = clientRepository;
        this.userRepository = userRepository;
    }

    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getByUser(User user) {
        return clientRepository.findByUser(user);
    }

    @Transactional
    public Client update(Client client, Inspector inspector) {
        Long id = client.getId();

        return clientRepository.findById(id)
                .map(clientFromDb -> {
                    clientFromDb.setInspector(inspector);
                    return clientRepository.save(clientFromDb);
                }).orElseGet(() -> clientRepository.save(client));
    }

    public List<Client> getByClientType(ClientType clientType, Inspector inspector) {
        return clientRepository.findByClientTypeAndInspector(clientType, inspector);
    }
}
