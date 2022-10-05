package com.example.formulario.Controllers;

import com.example.formulario.Modells.Producto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/01")
public class FormController {


    @GetMapping("/form")
    public String formulario(Model model ){
        Producto producto = new Producto();
        model.addAttribute("producto", producto);
        return "formulario";
    }

    @PostMapping("/form")
    public String resultado(@Valid Producto producto, BindingResult result, Model model ){

        if (result.hasErrors()) {
            return "formulario";
        }

        model.addAttribute("producto", producto);
        return "resultado";
    }
}
