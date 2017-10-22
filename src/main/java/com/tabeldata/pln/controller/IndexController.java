package com.tabeldata.pln.controller;

import com.tabeldata.pln.model.repository.PelangganRepository;
import com.tabeldata.pln.model.repository.PelangganTokenRepository;
import com.tabeldata.pln.model.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    PelangganRepository pelangganRepository;

    @Autowired
    TokenRepository tokenRepository;

    @Autowired
    PelangganTokenRepository pelangganTokenRepository;

    @GetMapping("/home")
    public String indexHtml(Model model) {

        model.addAttribute("listPelanggan", pelangganRepository.findAll());
        model.addAttribute("listToken", tokenRepository.findAll());
        model.addAttribute("listPelangganToken", pelangganTokenRepository.findAll());

        return "/index";
    }

    @GetMapping("/login-form")
    public String showFormLogin() {
        return "/login";
    }
}
