package be.ehb.recap.controller;

import be.ehb.recap.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class aboutController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(ModelMap map){
        return "about";
    }
}
