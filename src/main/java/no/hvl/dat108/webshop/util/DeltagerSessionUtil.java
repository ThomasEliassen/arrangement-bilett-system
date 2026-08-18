package no.hvl.dat108.webshop.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import no.hvl.dat108.webshop.model.Deltager;

public final class DeltagerSessionUtil {

    private static final int SESSION_TIMEOUT_SECONDS = 30 * 60;

    private DeltagerSessionUtil() {
    }

    public static void loggInn(HttpServletRequest request, Deltager deltager) {
        HttpSession existing = request.getSession(false);
        if (existing != null) {
            existing.invalidate();
        }
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(SESSION_TIMEOUT_SECONDS);
        session.setAttribute("deltagerMobil", deltager.getMobil());
        session.setAttribute("deltager", deltager);
    }

    public static String innloggetMobil(HttpSession session) {
        return session == null ? null : (String) session.getAttribute("deltagerMobil");
    }
}
