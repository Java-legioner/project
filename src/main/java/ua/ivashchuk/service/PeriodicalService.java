package ua.ivashchuk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ivashchuk.dao.PeriodicalRepository;
import ua.ivashchuk.domain.Periodical;

import java.util.List;

@Service
public class PeriodicalService {

    @Autowired
    private PeriodicalRepository periodicalRepository;

    public Periodical save(Periodical periodical){
        return periodicalRepository.save(periodical);
    }

    public List<Periodical> findAllPeriodicals(){
        return periodicalRepository.findAll();
    }
}
