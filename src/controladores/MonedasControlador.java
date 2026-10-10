package controladores;

import servicios.MonedasServicio;
import vistas.MonedasVista;

import java.time.LocalDate;
import java.time.ZoneId;

public class MonedasControlador {

    private final MonedasVista vista;

    public MonedasControlador(MonedasVista vista) {
        this.vista = vista;

        this.vista.setGraficarClick(evento -> graficar());
        this.vista.setCalcularEstadisticasClick(evento -> calcularEstadisticas());
        cargarDatos();
    }

    private void cargarDatos(){
        String nombreArchivo = System.getProperty("user.dir") + "/src/datos/Cambios Monedas.csv";
        var cambiosMoneda=MonedasServicio.getDatos(nombreArchivo);

        for(var cambioMoneda:cambiosMoneda){
            System.out.println("Moneda:"+cambioMoneda.getMoneda()+" Fecha:"+cambioMoneda.getFecha());
        }
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
