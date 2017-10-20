/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.controller;

import com.tabeldata.pln.model.Pelanggan;
import com.tabeldata.pln.model.PelangganToken;
import com.tabeldata.pln.model.Token;
import com.tabeldata.pln.model.repository.PelangganRepository;
import com.tabeldata.pln.model.repository.PelangganTokenRepository;
import com.tabeldata.pln.model.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Diani
 */
@Controller
@RequestMapping("/pelanggan")
public class PelangganController {

    @Autowired
    private PelangganRepository pelangganRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private PelangganTokenRepository pelangganTokenRepository;

    @GetMapping("/new")
    public String newPelanggan(Pelanggan pelanggan, Model model) {
        model.addAttribute("p", pelanggan);
        model.addAttribute("listToken", tokenRepository.findAll());

        return "/pelanggan/addPelanggan";
    }

    @GetMapping("/add-saldo")
    public String beliSaldo(@RequestParam(name = "id", required = true) Pelanggan pelanggan, Model model) {
        model.addAttribute("pelanggan", pelanggan);
        model.addAttribute("listPelanggan", pelangganRepository.findAll());
        model.addAttribute("listToken", tokenRepository.findAll());

        return "/pelanggan/tambahSaldo";
    }

    @PostMapping("/new")
    public String submitNewTransaksi(Pelanggan pelanggan) {
        pelangganRepository.save(pelanggan);

        System.out.println(pelanggan.toString());
        return "redirect:/pelanggan/list";
    }

    @GetMapping("/list")
    public String listPelanggan(Model model) {

        model.addAttribute("listPelanggan", pelangganRepository.findAll());
        model.addAttribute("listToken", tokenRepository.findAll());
        return "/pelanggan/listPelanggan";

    }

    @GetMapping("/add-token")
    public String beliToken(@RequestParam(name = "id", required = true) Pelanggan pelanggan, Model model, PelangganToken pelangganToken) {
//        System.out.println(pelangganToken.getPelanggan().toString());
//        pelangganTokenRepository.findByPelangganId(pelangganToken.getPelanggan().getId());
        model.addAttribute("pln", pelangganToken);
        model.addAttribute("p", pelanggan);
        model.addAttribute("listPelanggan", pelangganRepository.findAll());
        model.addAttribute("listToken", tokenRepository.findAll());

        return "/pelanggan/tambahToken";
    }

    @PostMapping("/beli")
    public String prosesToken(PelangganToken pelangganToken) {
        pelangganTokenRepository.save(pelangganToken);

        System.out.println(pelangganToken.toString());
        return "redirect:/pelanggan/kartu";

    }

    @GetMapping("/kartu")
    public String listTransaksi(Model model) {

        model.addAttribute("listPelangganToken", pelangganTokenRepository.findAll());
        return "/pelanggan/listTransaksi";

    }

}
