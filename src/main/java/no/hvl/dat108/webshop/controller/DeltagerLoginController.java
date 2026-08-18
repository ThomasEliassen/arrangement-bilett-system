package no.hvl.dat108.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.webshop.model.Deltager;
import no.hvl.dat108.webshop.util.DeltagerRepository;
import no.hvl.dat108.webshop.util.DeltagerSessionUtil;
import no.hvl.dat108.webshop.util.PasswordUtil;

@Controller
@RequestMapping("/innlogging")
public class DeltagerLoginController {

    private final DeltagerRepository repository;

    public DeltagerLoginController(DeltagerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String visInnlogging(HttpSession session) {
        return DeltagerSessionUtil.innloggetMobil(session) == null
                ? "loginView" : "redirect:/butikk";
    }

    @PostMapping
    public String loggInn(@RequestParam String mobil, @RequestParam String passord,
            HttpServletRequest request, Model model) {
        Deltager deltager = repository.findById(mobil).orElse(null);
        if (deltager == null
                || !PasswordUtil.matches(passord, deltager.getSalt(), deltager.getHash())) {
            model.addAttribute("feilmelding", "Ugyldig mobilnummer eller passord");
            model.addAttribute("mobil", mobil);
            return "loginView";
        }

        DeltagerSessionUtil.loggInn(request, deltager);
        return "redirect:/butikk";
    }
}
