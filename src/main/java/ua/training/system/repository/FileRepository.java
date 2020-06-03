package ua.training.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.training.system.entity.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
