package Modelo;
import Repository.*;

public class ServicioBancario{
    private CuentaRepository cuentaRepository;
    private MovimientoRepository movimientoRepository;

    public ServicioBancario(CuentaRepository cuentaRepository, MovimientoRepository movimientoRepository) {
        this.cuentaRepository = cuentaRepository;
        this.movimientoRepository = movimientoRepository;
    }
    public void agregarCuenta(Cuenta cuenta) {
        cuentaRepository.agregarCuentas(cuenta);
    }
    public Cuenta buscarCuenta(int id) {
        return cuentaRepository.buscarCuenta(id);
    }
    public void eliminarCuenta(int id) {
        cuentaRepository.eliminarCuenta(id);
    }
    public void agregarMovimiento(Movimiento movimiento) {
        movimientoRepository.agregarMovimiento(movimiento);
    }
    public Movimiento buscarMovimiento(int id) {
        return movimientoRepository.buscarMovimientos(id);
    }
}

