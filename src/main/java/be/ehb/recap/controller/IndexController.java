package be.ehb.recap.controller;

import be.ehb.recap.model.Product;
import be.ehb.recap.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute(value = "products")
    public Iterable<Product> allProducts(){
        return productRepository.findAll();
    }

    @RequestMapping(value = {"/","/products"})
    public String showProducts(ModelMap map){
        return "index";
    }
}
