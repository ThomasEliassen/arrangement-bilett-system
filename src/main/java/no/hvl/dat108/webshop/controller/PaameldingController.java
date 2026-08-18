package no.hvl.dat108.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import no.hvl.dat108.webshop.model.Deltager;
import no.hvl.dat108.webshop.model.PaameldingForm;
import no.hvl.dat108.webshop.util.DeltagerRepository;
import no.hvl.dat108.webshop.util.PasswordUtil;
import no.hvl.dat108.webshop.util.DeltagerSessionUtil;

@Controller
@RequestMapping("/paamelding")
public class PaameldingController {

    private final DeltagerRepository repository;

    public PaameldingController(DeltagerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String visSkjema(Model model) {
        if (!model.containsAttribute("paameldingForm")) {
            model.addAttribute("paameldingForm", new PaameldingForm());
        }
        return "Paamelding";
    }

    @PostMapping
    public String meldPaa(@Valid @ModelAttribute PaameldingForm paameldingForm,
            BindingResult bindingResult, HttpServletRequest request) {
        if (paameldingForm.getMobil() != null
                && repository.existsById(paameldingForm.getMobil())) {
            bindingResult.rejectValue("mobil", "duplicate", "Mobilnummeret er allereie registrert");
        }
        if (bindingResult.hasErrors()) {
            return "Paamelding";
        }

        String salt = PasswordUtil.generateSalt();
        Deltager deltager = new Deltager(paameldingForm.getMobil(),
                PasswordUtil.hash(paameldingForm.getPassord(), salt), salt,
                paameldingForm.getFornavn(), paameldingForm.getEtternavn(),
                paameldingForm.getKjonn());
        repository.save(deltager);

        DeltagerSessionUtil.loggInn(request, deltager);
        return "redirect:/paamelding/bekreftelse";
    }

    @GetMapping("/bekreftelse")
    public String visBekreftelse(HttpSession session) {
        return session.getAttribute("deltagerMobil") == null
                ? "redirect:/paamelding" : "paameldt";
    }
}
