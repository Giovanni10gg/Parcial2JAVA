import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class InterfazBienvenida extends JFrame {
    private final JTextField campoNombre;
    private final JButton botonIngresar;

    public InterfazBienvenida() {
        // Configuración de la ventana principal
        setTitle("Bienvenido Trabajador Pegasus");
        setSize(500, 600); 
        setLayout(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Color de fondo
        getContentPane().setBackground(Color.CYAN);
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.png"));
        setIconImage(icon);  // Asignar el icono al JFrame
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/images/icon.png"));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(15, 20, 100, 100);
        add(logoLabel);

        // Título
        JLabel titulo = new JLabel("Sistema de Control Vacacional PEGASUS S.A", SwingConstants.CENTER);
        titulo.setBounds(50, 150, 400, 30);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        add(titulo);

        // Campo de texto para ingresar el nombre
        JLabel etiquetaNombre = new JLabel("Ingrese su nombre:");
        etiquetaNombre.setBounds(50, 180, 120, 20);
        etiquetaNombre.setForeground(Color.WHITE);
        add(etiquetaNombre);

        campoNombre = new JTextField();
        campoNombre.setBounds(50, 200, 400, 30);
        add(campoNombre);

        // Botón Ingresar
        botonIngresar = new JButton("Ingresar");
        botonIngresar.setBounds(150, 250, 200, 30);
        botonIngresar.setEnabled(false);
        add(botonIngresar);

        // Evento del botón Ingresar
        campoNombre.addActionListener(e -> verificarNombre());
        botonIngresar.addActionListener(e -> abrirTerminos());

        setVisible(true);
    }

    private void verificarNombre() {
        if (!campoNombre.getText().isEmpty()) {
            botonIngresar.setEnabled(true); // Habilita el botón si el campo no está vacío
        } else {
            botonIngresar.setEnabled(false); // Deshabilita el botón si el campo está vacío
        }
    }

    // Método para abrir la pantalla de términos y cerrar esta
    private void abrirTerminos() {
        String nombreUsuario = campoNombre.getText();
        InterfazTerminos interfazTerminos = new InterfazTerminos(nombreUsuario); // Pasar el nombre del usuario
        this.dispose(); // Cierra la pantalla actual
    }

    public static void main(String[] args) {
        new InterfazBienvenida().setVisible(true);
    }
}





