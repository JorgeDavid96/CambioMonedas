package controladores;

import servicios.MonedasServicio;
import vistas.MonedasVista;

import java.time.LocalDate;
import java.util.List;

import modelos.CambioMoneda;

public class MonedasControlador {

    private final MonedasVista vista;
    private List<String> monedas;
    private List<CambioMoneda> cambiosMoneda;

    public MonedasControlador(MonedasVista vista) {
        this.vista = vista;

        this.vista.setGraficarClick(evento -> graficar());
        this.vista.setCalcularEstadisticasClick(evento -> calcularEstadisticas());
        cargarDatos();
    }

    private void cargarDatos(){
        String nombreArchivo = System.getProperty("user.dir") + "/src/datos/Cambios Monedas.csv";
        cambiosMoneda=MonedasServicio.getDatos(nombreArchivo);
        monedas = MonedasServicio.getMonedas(cambiosMoneda);
        vista.setMonedas(monedas);
    }

    private void graficar() {
        if (vista.getIndiceMonedaSeleccionada() >= 0) {
            LocalDate desde = vista.getFechaDesde();
            LocalDate hasta = vista.getFechaHasta();
            var moneda = monedas.get(vista.getIndiceMonedaSeleccionada());
            var datosFiltrados = MonedasServicio.filtrar(cambiosMoneda, moneda, desde, hasta);
            var getDatosGrafica = MonedasServicio.getDatosGrafica(datosFiltrados);
        }
        // Cambiar a la pestaña de Grafica
        vista.activarPestaña(0);
    }

    private void calcularEstadisticas() {
        if (vista.getIndiceMonedaSeleccionada() >= 0) {

            LocalDate desde = vista.getFechaDesde();
            LocalDate hasta = vista.getFechaHasta();
            var moneda = monedas.get(getIndiceMonedaSeleccionada());
            var datosFiltrados = MonedasServicio.filtrar(cambioMonedas, moneda, desde, hasta);
            var valoresCambios = MonedasServicio.getValores(datosFiltrados);
            var estadisticas = MonedasServicio.getEstadisticas(valoresCambios);

        }
        // Cambiar a la pestaña de estadísticas
        vista.activarPestaña(1);

    }


}
