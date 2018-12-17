package be.ehb.recap.controller;

import be.ehb.recap.model.Product;
import be.ehb.recap.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AddController {

    @Autowired
    private ProductRepository productRepository;

    @ModelAttribute(value = "product")
    public Product addproduct(){
        return new Product();
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.GET)
    public String addNewProduct(){
        return "addProduct";
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public String saveAddProduct(@ModelAttribute(value = "product")@Valid Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "addProduct";
        }
        productRepository.save(product);
        return "redirect:/products";
    }
}
