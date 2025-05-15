package Util;

import java.util.Random;
import Modelo.Cuenta;
public class CuentaCorriente implements CuentaBuilder{
    private Cuenta cuentaProducto = new Cuenta();
    Random aleatorio = new Random(System.currentTimeMillis());
    @Override
    public void idCuenta() {
        cuentaProducto.setId(aleatorio.nextInt(1000));
    }
    @Override
    public void tipoCuenta() {
        cuentaProducto.setTipo("Corriente");
    }
    @Override
    public void saldoInicial() {
        cuentaProducto.setSaldo(100);
    }

    @Override
    public void limite() {

    }
}
