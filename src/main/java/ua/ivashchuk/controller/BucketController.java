package ua.ivashchuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ivashchuk.domain.Bucket;
import ua.ivashchuk.domain.Periodical;
import ua.ivashchuk.domain.User;
import ua.ivashchuk.service.BucketService;
import ua.ivashchuk.service.PeriodicalService;
import ua.ivashchuk.service.UserService;

import java.util.Date;

@Controller
public class BucketController {

    @Autowired
    private BucketService bucketService;

    @Autowired
    private UserService userService;

    @Autowired
    private PeriodicalService periodicalService;

    @RequestMapping(value = "/buckets", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public ModelAndView getAllItems(){
        return getBucketItems();
    }

    @RequestMapping(value = "/bucket", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('USER')")
    public ModelAndView create(@RequestParam String periodicalId){
        Periodical periodical = periodicalService.findById(Integer.parseInt(periodicalId));

        Bucket bucket = new Bucket();
        bucket.setPeriodical(periodical);
        bucket.setPurchaseDate(new Date());

       Authentication auth = SecurityContextHolder.getContext().getAuthentication();
       String username = auth.getName();
       User user = userService.findByEmail(username);


        bucketService.add(bucket);
        return getBucketItems();
    }

    @RequestMapping(value = "/bucket", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('USER')")
    public ModelAndView delete(@RequestParam String id) {

        bucketService.delete(new Bucket(Integer.parseInt(id.replaceAll("\\s", ""))));
        return getBucketItems();
    }

    private ModelAndView getBucketItems(){
        ModelAndView map = new ModelAndView("bucket");
        map.addObject("bucketItems", bucketService.getAll());
        return map;
    }
}
