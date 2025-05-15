package Repository;
import Modelo.Movimiento;
import java.io.*;
import java.text.SimpleDateFormat;

public class ConcreteMovimientoRepository implements MovimientoRepository {
    @Override
    public void agregarMovimiento(Movimiento movimiento){
        try (FileWriter fw = new FileWriter("Movimientos.txt")) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            for (Movimiento m : movimientos) {
                fw.write(sdf.format(m.getFecha()) + "|" +
                        m.getDescripcion() + "|" +
                        m.getMonto() + "|" +
                        m.getCuentaId() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al guardar movimientos");
        }
    }
    @Override
    public Movimiento buscarMovimientos(int id) {
        return movimientos.stream()
                .filter(movimiento->movimiento.getCuentaId() == id)
                .findFirst()
                .orElse(null);
    }
}
