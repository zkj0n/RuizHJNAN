package es.albarregas.models;

import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
    public static boolean validar(Ciclo ciclo) {
        boolean correcto = true;
        if (ciclo.getNombre() == null || ciclo.getNombre().trim().isEmpty()) {
            correcto = false;
        }
        if (ciclo.getModulos() == null || ciclo.getModulos().isEmpty()) {
            correcto = false;
        }
        return correcto;
    }
    public static List<Modulo> populateModulos(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
        String[] denominaciones = request.getParameterValues("denominacion");
        String[] ids = request.getParameterValues("idModulo");

        List<Modulo> modulos = new ArrayList<>();

        if (denominaciones != null) {
            for (int i = 0; i < denominaciones.length; i++) {
                String denominacion = denominaciones[i];
                if (!denominacion.isEmpty()) {
                    Modulo modulo = new Modulo();
                    modulo.setDenominacion(denominacion);
                    if (ids != null && i < ids.length && ids[i] != null && !ids[i].isEmpty()) {
                        try {
                            modulo.setIdModulo(Integer.parseInt(ids[i]));
                        } catch (NumberFormatException e) {
                            System.err.println("ID inválido para módulo: " + ids[i]);
                        }
                    }
                    modulos.add(modulo);
                }
            }
        }
        return modulos;
    }


}
