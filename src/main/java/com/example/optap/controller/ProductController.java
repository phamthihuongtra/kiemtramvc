package com.example.optap.controller;

import com.example.optap.model.Product;
import com.example.optap.repository.ProRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProRepository proRepository;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("productList", proRepository.findAll());
        return "/list";
    }

    @GetMapping("/create")
    public String showCreateForm(){
        return "/create";
    }

    @PostMapping("/add")
    public String create(Product product){
        proRepository.save(product);
        return "redirect:/products";
    }

//    @GetMapping("/edit/{id}")
//    public String showCreateForm(@PathVariable Long id, Model model){
//        model.addAttribute("pro", proRepository.findById(id).get());
//        return "/edit";
//    }
//
//    @PostMapping("/edit/{id}")
//    public String save(Product product){
//        proRepository.save(product);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Long id){
//        proRepository.deleteById(id);
//        return "redirect:/products";
//    }
//
//    @GetMapping("/view/{id}")
//    public String showView(@PathVariable Long id, Model model){
//        model.addAttribute("pro", proRepository.findById(id).get());
//        return "/view";
//    }
//
//    @GetMapping("/search")
//    public String search(@RequestParam String name, Model model){
//        model.addAttribute("productList", proRepository.findAllByNameContaining(name));
//        return "/result";
//    }
}
