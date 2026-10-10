import controladores.MonedasControlador;
import vistas.MonedasVista;

public class App {
    public static void main(String[] args) throws Exception {
        var vista = new MonedasVista();
        new MonedasControlador(vista);
        vista.setVisible(true);
    }
}
