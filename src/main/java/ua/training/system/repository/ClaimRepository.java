package ua.training.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.training.system.entity.Claim;
import ua.training.system.entity.Client;
import ua.training.system.entity.Inspector;

import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByInspector(Inspector inspector);
    List<Claim> findByClient(Client client);
}
