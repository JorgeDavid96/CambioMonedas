package controladores;

import vistas.MonedasVista;

import java.time.LocalDate;
import java.time.ZoneId;

public class MonedasControlador {

    private final MonedasVista vista;

    public MonedasControlador(MonedasVista vista) {
        this.vista = vista;

        this.vista.setGraficarClick(evento -> graficar());
        this.vista.setCalcularEstadisticasClick(evento -> calcularEstadisticas());
    }

    private void graficar() {
        if (vista.getIndiceMonedaSeleccionada() >= 0) {
            LocalDate desde = vista.getFechaDesde();
            LocalDate hasta = vista.getFechaHasta();

        }
        // Cambiar a la pestaña de Grafica
        vista.activarPestaña(0);
    }

    private void calcularEstadisticas() {
        if (vista.getIndiceMonedaSeleccionada() >= 0) {

            LocalDate desde = vista.getFechaDesde();
            LocalDate hasta = vista.getFechaHasta();

        }
        // Cambiar a la pestaña de estadísticas
        vista.activarPestaña(1);

    }


}
