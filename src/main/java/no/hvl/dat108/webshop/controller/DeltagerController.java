package no.hvl.dat108.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.webshop.model.Deltager;
import no.hvl.dat108.webshop.util.DeltagerRepository;
import no.hvl.dat108.webshop.util.DeltagerSessionUtil;
import no.hvl.dat108.webshop.util.BillettkjopRepository;

@Controller
public class DeltagerController {

    private final DeltagerRepository repository;
    private final BillettkjopRepository billettkjopRepository;

    public DeltagerController(DeltagerRepository repository,
            BillettkjopRepository billettkjopRepository) {
        this.repository = repository;
        this.billettkjopRepository = billettkjopRepository;
    }

    @GetMapping("/deltagerliste")
    public String visDeltagerliste(HttpSession session, Model model) {
        String mobil = DeltagerSessionUtil.innloggetMobil(session);
        if (mobil == null) {
            return "redirect:/innlogging";
        }

        Deltager innlogget = repository.findById(mobil).orElse(null);
        if (innlogget == null) {
            session.invalidate();
            return "redirect:/innlogging";
        }

        model.addAttribute("innlogget", innlogget);
        model.addAttribute("billettkjop",
                billettkjopRepository.findAllByOrderByDeltagerFornavnAscDeltagerEtternavnAsc());
        return "deltagerliste";
    }

    @PostMapping("/utlogging")
    public String loggUt(HttpSession session) {
        session.invalidate();
        return "redirect:/innlogging";
    }
}
