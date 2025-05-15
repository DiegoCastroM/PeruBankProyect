package Util;

import java.util.Random;
import Modelo.Cuenta;
public class CuentaCredito implements CuentaBuilder {
    private Cuenta cuentaProducto = new Cuenta();
    Random aleatorio = new Random(System.currentTimeMillis());
    @Override
    public void idCuenta() {
        cuentaProducto.setId(aleatorio.nextInt(1000));
    }
    @Override
    public void tipoCuenta() {
        cuentaProducto.setTipo("Crédito");
    }
    @Override
    public void saldoInicial() {

    }
    @Override
    public void limite() {
        cuentaProducto.setLimite(0);
    }
}
