package ua.ivashchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.ivashchuk.domain.Periodical;
import ua.ivashchuk.service.PeriodicalService;

@Controller
public class PeriodicalController {

    @Autowired
    private PeriodicalService periodicalService;



    @RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public String createPeriodical(@Validated @ModelAttribute("periodical")Periodical periodical, BindingResult bindingResult){
        periodicalService.save(periodical);
        return "redirect:/home";
    }
}
