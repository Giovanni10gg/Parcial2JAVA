import javax.swing.*;
import java.awt.*;

public class InterfazTerminos extends JFrame {
    private final JCheckBox aceptarCheck;
    private final JButton botonContinuar;
    private final JButton botonNoACEPTAR;
    private final String nombreUsuario;

    public InterfazTerminos(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        setTitle("Licencia de uso");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.CYAN);
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.png"));
        setIconImage(icon);  // Asignar el icono al JFrame
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/icon.png"));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(15, 20, 100, 100);
        add(logoLabel);

        JLabel titulo = new JLabel("TÉRMINOS Y CONDICIONES", SwingConstants.CENTER);
        titulo.setBounds(50, 150, 400, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.BLACK);
        add(titulo);

        JTextArea areaTerminos = new JTextArea();
        areaTerminos.setBounds(50, 200, 400, 180);
        areaTerminos.setText("Términos y Condiciones:\n" +
                "A. Prohibida la venta o distribución sin autorización.\n" +
                "B. Prohibida la alteración del código fuente o diseño.\n" +
                "C. No nos hacemos responsables del mal uso del software.");
        areaTerminos.setFont(new Font("Arial", Font.PLAIN, 12));
        areaTerminos.setEditable(false);
        add(areaTerminos);

        aceptarCheck = new JCheckBox("Yo acepto los términos.");
        aceptarCheck.setBounds(50, 400, 200, 20);
        aceptarCheck.setBackground(Color.LIGHT_GRAY);
        aceptarCheck.setForeground(Color.BLACK);
        add(aceptarCheck);

        botonContinuar = new JButton("ACEPTAR");
        botonContinuar.setBounds(200, 450, 100, 40);
        botonContinuar.setEnabled(false);
        add(botonContinuar);
        
        botonNoACEPTAR = new JButton("No ACEPTAR");
        botonNoACEPTAR.setBounds(100, 450, 100, 40);
        add(botonNoACEPTAR);

        aceptarCheck.addActionListener(e -> verificarCheck());
        botonContinuar.addActionListener(e -> abrirPantallaPrincipal());
        botonNoACEPTAR.addActionListener(e -> CerrarInterfazTerminos());

        setVisible(true);
    }

    private void verificarCheck() {
        botonContinuar.setEnabled(aceptarCheck.isSelected());
    }

    private void abrirPantallaPrincipal() {
        PantallaPrincipal pantallaPrincipal = new PantallaPrincipal(nombreUsuario); // Pasar el nombre del usuario
        this.dispose(); // Cierra esta pantalla de términos
    }

    private void CerrarInterfazTerminos() {
        JOptionPane.showMessageDialog(this, 
            "Dado que los términos no fueron aceptados, el programa no puede ser de su uso. ¡Gracias!", 
            "Términos no aceptados", JOptionPane.WARNING_MESSAGE);
        System.exit(0);
    }
}