package no.hvl.dat108.webshop.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.webshop.model.Billettkjop;
import no.hvl.dat108.webshop.model.Billettype;
import no.hvl.dat108.webshop.model.Deltager;
import no.hvl.dat108.webshop.util.BillettkjopRepository;
import no.hvl.dat108.webshop.util.DeltagerRepository;
import no.hvl.dat108.webshop.util.DeltagerSessionUtil;

@Controller
@RequestMapping("/butikk")
public class BillettController {

    private final DeltagerRepository deltagerRepository;
    private final BillettkjopRepository billettkjopRepository;

    public BillettController(DeltagerRepository deltagerRepository,
            BillettkjopRepository billettkjopRepository) {
        this.deltagerRepository = deltagerRepository;
        this.billettkjopRepository = billettkjopRepository;
    }

    @GetMapping
    public String visBillettar(HttpSession session, Model model) {
        String mobil = DeltagerSessionUtil.innloggetMobil(session);
        if (mobil == null) {
            return "redirect:/innlogging";
        }
        model.addAttribute("billettypar", Billettype.values());
        billettkjopRepository.findByDeltagerMobil(mobil)
                .ifPresent(kjop -> model.addAttribute("eksisterandeKjop", kjop));
        return "billettbutikk";
    }

    @PostMapping("/kjop")
    public String kjopBillett(@RequestParam String billettype, HttpSession session,
            RedirectAttributes redirectAttributes) {
        String mobil = DeltagerSessionUtil.innloggetMobil(session);
        if (mobil == null) {
            return "redirect:/innlogging";
        }
        if (billettkjopRepository.existsByDeltagerMobil(mobil)) {
            return "redirect:/deltagerliste";
        }

        Billettype type = Billettype.fraKode(billettype).orElse(null);
        Deltager deltager = deltagerRepository.findById(mobil).orElse(null);
        if (type == null || deltager == null) {
            redirectAttributes.addFlashAttribute("feilmelding", "Vel ein gyldig billett");
            return "redirect:/butikk";
        }

        try {
            billettkjopRepository.saveAndFlush(new Billettkjop(deltager, type));
        } catch (DataIntegrityViolationException e) {
            return "redirect:/deltagerliste";
        }
        return "redirect:/butikk/stadfesting";
    }

    @GetMapping("/stadfesting")
    public String visStadfesting(HttpSession session, Model model) {
        String mobil = DeltagerSessionUtil.innloggetMobil(session);
        if (mobil == null) {
            return "redirect:/innlogging";
        }
        Billettkjop kjop = billettkjopRepository.findByDeltagerMobil(mobil).orElse(null);
        if (kjop == null) {
            return "redirect:/butikk";
        }
        model.addAttribute("kjop", kjop);
        return "kjopsstadfesting";
    }
}
