package Vista;

import Controlador.TransferenciaControlador;
import Modelo.Cuenta;
import Modelo.ServicioBancario;

import javax.swing.*;
import java.awt.*;

public class TransferenciaPanelView extends JPanel {
    private ServicioBancario servicio;
    private JComboBox<Cuenta> origenCombo;
    private JComboBox<Cuenta> destinoCombo;

    public TransferenciaPanelView(ServicioBancario servicio) {
        this.servicio = servicio;
        TransferenciaControlador controlador = new TransferenciaControlador(servicio);

        setLayout(new GridLayout(5, 2, 5, 5));

        origenCombo = new JComboBox<>();
        destinoCombo = new JComboBox<>();
        JTextField montoField = new JTextField();
        JButton transferirBtn = new JButton("Transferir");
        JButton actualizarBtn = new JButton("Actualizar Cuentas");
        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
                                                          int index, boolean isSelected,
                                                          boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Cuenta) {
                    Cuenta cuenta = (Cuenta) value;
                    setText(String.format("%d - %s ($%.2f)",
                            cuenta.getId(), cuenta.getTipo(), cuenta.getSaldo()));
                }
                return this;
            }
        };
        origenCombo.setRenderer(renderer);
        destinoCombo.setRenderer(renderer);
        actualizarBtn.addActionListener(e -> actualizarCombos());

        transferirBtn.addActionListener(e -> {
            try {
                Cuenta origen = (Cuenta) origenCombo.getSelectedItem();
                Cuenta destino = (Cuenta) destinoCombo.getSelectedItem();

                if(origen == null || destino == null) {
                    JOptionPane.showMessageDialog(this, "Seleccione ambas cuentas");
                    return;
                }

                double monto = Double.parseDouble(montoField.getText());
                boolean exito = controlador.validarCuenta(
                        origen.getId(),
                        destino.getId(),
                        monto
                );
                JOptionPane.showMessageDialog(this,
                        exito ? "Transferencia exitosa!" : "Fallo en transferencia");
                actualizarCombos();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto válido");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });
        add(new JLabel("Cuenta Origen:"));
        add(origenCombo);
        add(new JLabel("Cuenta Destino:"));
        add(destinoCombo);
        add(new JLabel("Monto:"));
        add(montoField);
        add(transferirBtn);
        add(actualizarBtn);
    }
    public void actualizarCombos() {
        SwingUtilities.invokeLater(() -> {
            origenCombo.removeAllItems();
            destinoCombo.removeAllItems();

            servicio.buscarCuenta().forEach(cuenta -> {
                origenCombo.addItem(Cuenta);
                destinoCombo.addItem(Cuenta);
            });
        });
    }
}
