package Repository;

import Modelo.Movimiento;

import java.util.ArrayList;
import java.util.List;

public interface MovimientoRepository {
    List<Movimiento> movimientos = new ArrayList<>();
    Movimiento buscarMovimientos(int id);
    void agregarMovimiento(Movimiento movimiento);
}
