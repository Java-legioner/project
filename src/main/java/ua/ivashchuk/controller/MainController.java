package ua.ivashchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ivashchuk.domain.Periodical;
import ua.ivashchuk.service.PeriodicalService;

@Controller
public class MainController {

    @Autowired
    private PeriodicalService periodicalService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){

        ModelAndView map = new ModelAndView("home");
        map.addObject("periodicals", periodicalService.findAllPeriodicals());

        return map;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView welcome(){

        ModelAndView map = new ModelAndView("home");
        map.addObject("periodicals", periodicalService.findAllPeriodicals());

        return map;
    }


    @RequestMapping(value = "/create-periodical", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView createPeriodical(Model model){
        return new ModelAndView("createPeriodical", "periodical", new Periodical());
    }



  }
