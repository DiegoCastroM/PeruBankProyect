package Repository;
import Modelo.Cuenta;
import java.io.*;
public class ConcreteCuentaRepository implements CuentaRepository{
    @Override
    public void agregarCuentas(Cuenta cuenta) {
        try (FileWriter fw = new FileWriter("Cuentas.txt")) {
            for (Cuenta c : cuentas) {
                if (c.getTipo().equals("Crédito")) {
                    fw.write(c.getId() + "||" + c.getTipo() + "||" +
                            c.getSaldo() + "||" + c.getLimite() + "\n");
                } else if (c.getTipo().equals("Corriente")) {
                    fw.write(c.getId() + "|" + c.getTipo() + "|" +
                            c.getSaldo() + "|" + c.getLimite() + "\n");
                } else {
                    fw.write(c.getId() + "|" + c.getTipo() + "|" + c.getSaldo() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al guardar cuentas");
        }
    }
    @Override
    public Cuenta buscarCuenta(int id) {
        return cuentas.stream()
                .filter(cuenta->cuenta.getId() == id)
                .findFirst()
                .orElse(null);
    }
    @Override
    public void eliminarCuenta(int id) {
        cuentas.removeIf(cuenta->cuenta.getId() == id);
    }
    }
