package ua.ivashchuk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ivashchuk.dao.PeriodicalRepository;
import ua.ivashchuk.domain.Periodical;

import java.util.List;

@Service
public class PeriodicalService {
    private Logger logger = LoggerFactory.getLogger(Periodical.class);


    @Autowired
    private PeriodicalRepository periodicalRepository;

    public Periodical save(Periodical periodical) {
        logger.debug("Create new periodical item {} :" + periodical);
        return periodicalRepository.save(periodical);
    }

    public List<Periodical> findAllPeriodicals(){
        logger.debug("Get all periodical item");
        return periodicalRepository.findAll();
    }
    public Periodical findById(Integer id) {
        logger.debug("Get periodical item by id" + id);
        return periodicalRepository.getById(id);
    }
}
