package Controlador;

import Modelo.Cuenta;
import Modelo.Movimiento;
import Modelo.ServicioBancario;
import java.util.Date;

public class TransferenciaControlador {
    private ServicioBancario servicioBancario;

    public TransferenciaControlador(ServicioBancario servicioBancario) {
        this.servicioBancario = servicioBancario;
    }

    public void validarCuenta(int origenId, int destinoId, double monto) {
        // Obtener cuentas seleccionadas
        Cuenta origen = servicioBancario.buscarCuenta(origenId);
        Cuenta destino = servicioBancario.buscarCuenta(destinoId);

        if (origen == null || destino == null) {
            System.out.println("Error: Seleccione ambas cuentas\n");
        }
        if (origen.getId() == destino.getId()) {
            System.out.println("Error: No puede transferir a la misma cuenta\n");
        }
        if (monto <= 0) {
            System.out.println("Error: Monto incorrecto\n");
        }
        if (origen.getSaldo() >= monto) {
            origen.setSaldo(origen.getSaldo() - monto);
            destino.setSaldo(destino.getSaldo() + monto);

            // Registrar movimiento
            Movimiento mov1 = new Movimiento(
                    new Date(),
                    "Transferencia a " + origen.getId(),
                    -monto,
                    origen.getId()
            );

            // Registrar movimiento
            Movimiento mov2 = new Movimiento(
                    new Date(),
                    "Transferencia a " + destino.getId(),
                    +monto,
                    destino.getId()
            );

        }
    }
}
