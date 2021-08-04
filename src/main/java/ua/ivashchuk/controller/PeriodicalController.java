package ua.ivashchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ua.ivashchuk.service.PeriodicalService;
import ua.ivashchuk.service.PeriodicalsDTOHelper;

import java.io.IOException;

@Controller
public class PeriodicalController {

    @Autowired
    private PeriodicalService periodicalService;



    @RequestMapping(value = "/addPeriodical", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ModelAndView createPeriodical(
            @RequestParam MultipartFile image,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam Double price) throws IOException {

        periodicalService.save(PeriodicalsDTOHelper.createEntity(image, name, description, price));

        return new ModelAndView("redirect:/home");
    }
}
