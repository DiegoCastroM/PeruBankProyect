package Repository;
import java.util.ArrayList;
import java.util.List;
import Modelo.Cuenta;

public interface CuentaRepository {
    List<Cuenta> cuentas = new ArrayList<>();
    void agregarCuentas(Cuenta cuenta);
    Cuenta buscarCuenta(int id);
    void eliminarCuenta(int id);
}
