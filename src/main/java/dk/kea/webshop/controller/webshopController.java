package dk.kea.webshop.controller;

import dk.kea.webshop.model.Product;
import dk.kea.webshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
class WebshopController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("products", productService.getAll());
        return "index";
    }

    @GetMapping("/create")
    public String showCreate()
    {
        return "createProduct";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Product product)
    {
        productService.createProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model)
    {
        productService.deleteProduct(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("product", productService.findProductById(id));
        return "editProduct";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Product product)
    {
        productService.updateProduct(product);
        return "redirect:/";
    }
}