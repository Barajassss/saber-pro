package com.uts.saberpro.service;

import com.uts.saberpro.model.Estudiante;
import org.springframework.stereotype.Service;

@Service
public class BeneficioService {

    public String obtenerBeneficio(Estudiante e) {

        if (e.getPuntajeTotal() == null)
            return "Sin información";

        int p = e.getPuntajeTotal();

        if (p >= 241) {
            return "Exoneración total + Nota 5.0 + 100% derechos de grado";
        } else if (p >= 211) {
            return "Exoneración + Nota 4.7 + 50% derechos de grado";
        } else if (p >= 180) {
            return "Exoneración + Nota 4.5";
        } else if (p < 80) {
            return "NO puede graduarse";
        } else {
            return "Sin beneficio";
        }
    }
}
