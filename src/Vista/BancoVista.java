package Vista;
import Modelo.ServicioBancario;
import Repository.ConcreteCuentaRepository;
import Repository.ConcreteMovimientoRepository;
import Repository.CuentaRepository;
import Repository.MovimientoRepository;
import javax.swing.*;
public class BancoVista extends JFrame {
    private ServicioBancario servicioBancario;
    public BancoVista() {
        setTitle("Sistema Bancario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Crear Cuenta", new CrearCuentaPanelView(servicio));
        tabbedPane.addTab("Transferencias", new TransferenciaPanelView(servicio));
        tabbedPane.addTab("Movimientos", new VerMovimientoPanelView(servicio));

        add(tabbedPane);
        ServicioBancario Servicio = null;
        try{
            CuentaRepository cuentaRepository = new ConcreteCuentaRepository();
            MovimientoRepository movimientoRepository = new ConcreteMovimientoRepository();
            Servicio = new ServicioBancario(cuentaRepository, movimientoRepository);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar cuentas");
            System.exit(1);
        }
    }
}



