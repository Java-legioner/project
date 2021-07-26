package ua.ivashchuk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ivashchuk.domain.Periodical;

public interface PeriodicalRepository extends JpaRepository<Periodical, Integer> {
}
