/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.controller;

import com.tabeldata.pln.model.Pelanggan;
import com.tabeldata.pln.model.PelangganToken;
import com.tabeldata.pln.model.repository.PelangganRepository;
import com.tabeldata.pln.model.repository.PelangganTokenRepository;
import com.tabeldata.pln.model.repository.TokenRepository;
import com.tabeldata.pln.model.repository.UserRepository;
import java.sql.Date;
import java.time.LocalDate;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/new")
    public String newPelanggan(Pelanggan pelanggan, Model model) {
        model.addAttribute("p", pelanggan);
        model.addAttribute("listToken", tokenRepository.findAll());

        return "/pelanggan/addPelanggan";
    }

    @GetMapping("/add-saldo")
    public String beliSaldo(@RequestParam(name = "id", required = true) Pelanggan pelanggan, Model model) {
        model.addAttribute("p", pelanggan);
        model.addAttribute("listToken", tokenRepository.findAll());

        return "/pelanggan/tambahSaldo";
    }

    @PostMapping("/new")
    public String submitNewTransaksi(Pelanggan pelanggan) {
        pelangganRepository.save(pelanggan);

        System.out.println(pelanggan.toString());
        return "redirect:/home";
    }

    @GetMapping("/list")
    public String listPelanggan(Model model) {

        model.addAttribute("listPelanggan", pelangganRepository.findAll());
        model.addAttribute("listToken", tokenRepository.findAll());
        model.addAttribute("listPelangganToken", pelangganTokenRepository.findAll());
        return "/pelanggan/listPelanggan";

    }

    @GetMapping("/add-token")
    public String beliToken(PelangganToken pelangganToken, Model model) {
//        System.out.println(pelangganToken.getPelanggan().toString());
//        pelangganToken = pelangganTokenRepository.findByPelangganId(pelanggan.getId());
        
        model.addAttribute("p", pelangganToken);
        model.addAttribute("listPelanggan", pelangganRepository.findAll());
        model.addAttribute("listToken", tokenRepository.findAll());

        return "/pelanggan/tambahToken";
    }
        

    @PostMapping("/beli")
    public String prosesToken(PelangganToken pelangganToken) {
        pelangganTokenRepository.save(pelangganToken);

        System.out.println(pelangganToken.toString());
        return "redirect:/home";

    }

    @GetMapping("/kartu")
    public String listTransaksi(Model model) {

        model.addAttribute("listPelangganToken", pelangganTokenRepository.findAll());
        return "/pelanggan/listTransaksi";

    }
    
    @GetMapping("/report")
    public ModelAndView showReport(Authentication auth){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Report_dataPelanggan");
        mav.addObject("format", "pdf");
        mav.addObject("tanggalCetak", Date.valueOf(LocalDate.now()));
        mav.addObject("datasource", new JRBeanCollectionDataSource(pelangganRepository.findAll()));
        mav.addObject("Principal", auth.getName());
        return mav;
    
    }

}
