package Util;

import java.util.Random;
import Modelo.Cuenta;
public class CuentaAhorro implements CuentaBuilder{
    private Cuenta cuentaProducto = new Cuenta();
    Random aleatorio = new Random(System.currentTimeMillis());
    @Override
    public void idCuenta() {
        cuentaProducto.setId(aleatorio.nextInt(1000));
    }
    @Override
    public void tipoCuenta() {
        cuentaProducto.setTipo("Ahorro");
    }
    @Override
    public void saldoInicial() {
        cuentaProducto.setSaldo(20);
    }
    @Override
    public void limite() {

    }
}
