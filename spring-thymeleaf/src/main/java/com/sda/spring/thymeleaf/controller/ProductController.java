package com.sda.spring.thymeleaf.controller;

import com.sda.spring.thymeleaf.model.Product;
import com.sda.spring.thymeleaf.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // products -> index
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String viewProductsPage(Model model) {
        log.info("List all products...");

        // get list
        List<Product> products = productService.findAll();

        // add list to model
        model.addAttribute("products", products);

        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewProductPage(Model model) {
        log.info("Show new product page...");

        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(
            @ModelAttribute("product") Product product
    ) {
        log.info("Save new product...");
        productService.save(product);

        return "redirect:/products";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        log.info("Edit product with id {}", id);
        ModelAndView modelAndView = new ModelAndView("edit_product");
        Product product = productService.findById(id);
        modelAndView.addObject("product", product);

        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable(name = "id") int id) {
        log.info("Delete product with id {}", id);
        productService.delete(id);

        return "redirect:/products";
    }
}
