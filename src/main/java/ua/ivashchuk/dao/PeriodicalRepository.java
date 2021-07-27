package ua.ivashchuk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ivashchuk.domain.Periodical;

@Repository
public interface PeriodicalRepository extends JpaRepository<Periodical, Integer> {

}
