package Controlador;

import Modelo.Cuenta;
import Modelo.ServicioBancario;
import Util.CuentaAhorro;
import Util.CuentaCorriente;

public class CrearCuentaControlador {
    private ServicioBancario servicioBancario;
    public CrearCuentaControlador(ServicioBancario servicioBancario) {
        this.servicioBancario = servicioBancario;
    }
    public void crearCuenta(Cuenta cuenta){
        switch(cuenta.getTipo()){
            case "Ahorro"-> new CuentaAhorro(servicioBancario.agregarCuenta());
            case "Corriente"-> new CuentaCorriente(servicioBancario.agregarCuenta());
            default -> throw new IllegalArgumentException("Tipo de cuenta no válido"+cuenta.getTipo());
        }
    }
}
