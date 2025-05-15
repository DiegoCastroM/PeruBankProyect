package Vista;

import Controlador.CrearCuentaControlador;
import Controlador.VerMovimientoControlador;
import Modelo.ServicioBancario;
import javax.swing.*;
import java.awt.*;
public class CrearCuentaPanelView extends JPanel {
    public CrearCuentaPanelView(ServicioBancario servicio) {
        CrearCuentaControlador CrearCuenta = new CrearCuentaControlador(servicio);
        setLayout(new GridLayout(3,2,5,5));

        JComboBox<String> tipoCombo = new JComboBox<>(new String[]{"Ahorro", "Corriente"});
        JTextField saldoField = new JTextField(10);
        JTextField dniField = new JTextField(10);
        JTextField nombreField = new JTextField(20);

        JButton crearBtn = new JButton("Crear");
        add(new JLabel("Tipo de cuenta:"));
        add(tipoCombo);
        add(new JLabel("Saldo inicial:"));
        add(saldoField);
        add(new JLabel());
        add(crearBtn);

        crearBtn.addActionListener(e -> {
            try {
                CrearCuenta.crearCuenta(
                        (String) tipoCombo.getSelectedItem(),
                        Double.parseDouble(saldoField.getText()),
                        dniField.getText(),
                        nombreField.getText()
                );
                JOptionPane.showMessageDialog(null, "Cuenta creada con exito");
                saldoField.setText("");
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this,"Ingrese monto válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    private void actualizarOtrasVistas(Component componenteActual) {
        // Obtener el JTabbedPane padre
        Container parent = componenteActual.getParent();
        while (parent != null && !(parent instanceof JTabbedPane)) {
            parent = parent.getParent();
        }

        if (parent != null) {
            JTabbedPane tabbedPane = (JTabbedPane) parent;

            // Recorrer todas las pestañas
            for (int i = 0; i < tabbedPane.getTabCount(); i++) {
                Component tab = tabbedPane.getComponentAt(i);

                if (tab instanceof TransferenciaPanelView) {
                    ((TransferenciaPanelView) tab).actualizarCombos();
                } else if (tab instanceof VerMovimientoPanelView) {
                    ((VerMovimientoPanelView) tab).actualizarCombos();
                }
            }
        }
}}