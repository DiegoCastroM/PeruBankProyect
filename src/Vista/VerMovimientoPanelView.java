package Vista;

import Controlador.VerMovimientoControlador;
import Modelo.Cuenta;
import Modelo.ServicioBancario;

import javax.swing.*;
import java.awt.*;

public class VerMovimientoPanelView extends JPanel {
    private ServicioBancario servicio;
    private JComboBox<Cuenta> cuentaCombo;
    private JTextArea movimientosArea;
    public VerMovimientoPanelView (ServicioBancario){
        this.servicio = servicio;
        VerMovimientoControlador controlador = new VerMovimientoControlador(servicio);
        setLayout(new BorderLayout(5, 5));

        cuentaCombo = new JComboBox<>();
        movimientosArea = new JTextArea(10, 30);
        movimientosArea.setEditable(false);
        JButton mostrarBtn = new JButton("Mostrar");
        JButton actualizarBtn = new JButton("Actualizar Cuentas");


        JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panelSuperior.add(new JLabel("Cuenta:"));
        panelSuperior.add(cuentaCombo);
        panelSuperior.add(mostrarBtn);
        panelSuperior.add(actualizarBtn);


        cuentaCombo.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
            int index, boolean isSelected,
            boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cuenta) {
                    Cuenta cuenta = (Cuenta) value;
                    setText(String.format("%d - %s ($%.2f)",
                            cuenta.getId(), cuenta.getTipo(), cuenta.getSaldo()));
                }
                return c;
            }
        });

        actualizarCombos();

        actualizarBtn.addActionListener(e -> actualizarCombos());

        mostrarBtn.addActionListener(e -> {
            movimientosArea.setText("");
            Cuenta seleccionada = (Cuenta) cuentaCombo.getSelectedItem();
            if(seleccionada != null) {
                controlador.buscarMovimientos(seleccionada.getId())
                        .forEach(m -> movimientosArea.append(
                                String.format("%tF - %s: $%.2f\n",
                                        m.getFecha(), m.getDescripcion(), m.getMonto())
                        ));
            }
        });

        add(panelSuperior, BorderLayout.NORTH);
        add(new JScrollPane(movimientosArea), BorderLayout.CENTER);
    }

    public void actualizarCombos() {
        SwingUtilities.invokeLater(() -> {
            cuentaCombo.removeAllItems();
            servicio.buscarCuenta().forEach(cuentaCombo::addItem);
        });
    }
    }

}
