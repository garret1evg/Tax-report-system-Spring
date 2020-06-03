package ua.training.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.training.system.entity.Renouncement;
import ua.training.system.entity.Report;

import java.util.List;

@Repository
public interface RenouncementRepository extends JpaRepository<Renouncement, Long> {
    List<Renouncement> findByReport(Report report);
}
