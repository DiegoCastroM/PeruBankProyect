package Controlador;
import java.util.List;
import Modelo.*;
import Modelo.ServicioBancario;

public class BancoControlador {
    private ServicioBancario servicioBancario;
    public BancoControlador(ServicioBancario servicioBancario) {
        this.servicioBancario = servicioBancario;
    }
    public Cuenta buscarCuentas(int cuentaId) {
        return servicioBancario.buscarCuenta(cuentaId);
    }
}
