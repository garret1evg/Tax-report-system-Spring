package ua.training.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.training.system.entity.Renouncement;
import ua.training.system.entity.Report;
import ua.training.system.repository.RenouncementRepository;

import java.util.List;

@Service
public class RenouncementService {
    RenouncementRepository renouncementRepository;

    @Autowired
    public RenouncementService(RenouncementRepository renouncementRepository) {
        this.renouncementRepository = renouncementRepository;
    }

    public Renouncement save(Renouncement renouncement) {
        return renouncementRepository.save(renouncement);
    }

    public List<Renouncement> getByReport(Report report) {
        return renouncementRepository.findByReport(report);
    }
}
