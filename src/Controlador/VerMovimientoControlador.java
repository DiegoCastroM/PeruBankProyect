package Controlador;

import Modelo.Cuenta;
import Modelo.Movimiento;
import Modelo.ServicioBancario;

public class VerMovimientoControlador {
    private ServicioBancario servicioBancario;
    public VerMovimientoControlador(ServicioBancario servicioBancario) {
        this.servicioBancario = servicioBancario;
    }
    public Movimiento buscarMovimientos(int cuentaId) {
        return servicioBancario.buscarMovimiento(cuentaId);
    }
}
