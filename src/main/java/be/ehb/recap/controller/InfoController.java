package be.ehb.recap.controller;

import be.ehb.recap.model.Product;
import be.ehb.recap.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InfoController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/info/{id}",method = RequestMethod.GET)
    public String showInfo(ModelMap map, @PathVariable(value = "id") int id){
        Product p = productRepository.findById(id).get();
        map.addAttribute("product", p);
        return "info";
    }
    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String back(Mapping map){
        return "index";
    }

}
