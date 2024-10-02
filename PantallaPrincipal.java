import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame {
    private final JTextField nombreField;
    private final JComboBox<String> departamentoCombo;
    private final JComboBox<Integer> antiguedadCombo;
    private final JTextArea resultadoArea;
    private final JButton limpiarButton;
    private final JButton regresarButton;
    private final JButton calcularButton;
    private final String nombreUsuario;

    public PantallaPrincipal(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        setTitle("Pantalla Principal");
        setSize(500, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.CYAN);

        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/logo.png"));
        setIconImage(icon);

        ImageIcon logo = new ImageIcon(getClass().getResource("/images/icon.png"));
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(15, 15, 100, 100);
        add(logoLabel);

        JLabel bienvenidoLabel = new JLabel("Bienvenido " + nombreUsuario, SwingConstants.CENTER);
        bienvenidoLabel.setBounds(50, 80, 400, 30);
        bienvenidoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bienvenidoLabel.setForeground(Color.BLACK);
        add(bienvenidoLabel);

        // Campos de texto
        nombreField = new JTextField();
        nombreField.setBounds(50, 140, 400, 30);
        add(new JLabel("Nombre Completo:")).setBounds(50, 120, 120, 20);
        add(nombreField);

        // ComboBox para seleccionar el departamento
        departamentoCombo = new JComboBox<>(new String[]{"Atención al Cliente", "Logística", "Gerencia"});
        departamentoCombo.setBounds(50, 200, 400, 30);
        add(new JLabel("Selecciona el Departamento:")).setBounds(50, 180, 180, 20);
        add(departamentoCombo);

        // ComboBox para seleccionar la antigüedad
        Integer[] antiguedades = {1, 2, 3, 4, 5, 6, 7};
        antiguedadCombo = new JComboBox<>(antiguedades);
        antiguedadCombo.setBounds(50, 260, 400, 30);
        add(new JLabel("Selecciona la Antigüedad (en años):")).setBounds(50, 240, 220, 20);
        add(antiguedadCombo);

        // Área de resultado
        resultadoArea = new JTextArea();
        resultadoArea.setBounds(50, 360, 400, 80);
        resultadoArea.setEditable(false);
        resultadoArea.setLineWrap(true);
        resultadoArea.setWrapStyleWord(true);
        add(new JLabel("Resultado:")).setBounds(50, 340, 120, 20);
        add(resultadoArea);

        // Botón para calcular
        calcularButton = new JButton("Calcular Vacaciones");
        calcularButton.setBounds(50, 460, 180, 30);
        add(calcularButton);
        calcularButton.addActionListener(e -> calcularVacaciones());

        // Botón para limpiar campos
        limpiarButton = new JButton("Limpiar Campos");
        limpiarButton.setBounds(250, 460, 180, 30);
        add(limpiarButton);
        limpiarButton.addActionListener(e -> limpiarCampos());

        // Botón para regresar
        regresarButton = new JButton("Regresar");
        regresarButton.setBounds(50, 500, 400, 30);
        add(regresarButton);
        regresarButton.addActionListener(e -> regresarInicio());

        setVisible(true);
    }

    private void calcularVacaciones() {
        String nombre = nombreField.getText();
        String departamento = (String) departamentoCombo.getSelectedItem();
        int antiguedad = (int) antiguedadCombo.getSelectedItem();

        if (nombre.isEmpty() || departamento == null || antiguedad == 0) {
            resultadoArea.setText("Por favor complete todos los campos.");
            return;
        }

        // Lógica de cálculo de vacaciones según departamento y antigüedad
        int diasVacaciones = 0;
        switch (departamento) {
            case "Atención al Cliente":
                diasVacaciones = antiguedad >= 1 && antiguedad <= 1 ? 6 : antiguedad >= 2 && antiguedad <= 6 ? 14 : antiguedad >= 7 && antiguedad >= 7 ? 20 : 20;
                break;
            case "Logística":
                diasVacaciones = antiguedad >= 1 && antiguedad <= 1 ? 7 : antiguedad >= 2 && antiguedad <= 6 ? 15 : antiguedad >= 7 && antiguedad >= 7 ? 22 : 22;
                break;
            case "Gerencia":
                diasVacaciones = antiguedad >= 1 && antiguedad <= 1 ? 10 : antiguedad >= 2 && antiguedad <= 6 ? 20 : antiguedad >= 7 && antiguedad >= 7 ? 30 : 30;
                break;
        }

        resultadoArea.setText("Empleado: " + nombre + "\n" +
                "Departamento: " + departamento + "\n" +
                "Antigüedad: " + antiguedad + " años\n" +
                "Días de vacaciones: " + diasVacaciones);
    }

    private void limpiarCampos() {
        nombreField.setText("");
        departamentoCombo.setSelectedIndex(0);
        antiguedadCombo.setSelectedIndex(0);
        resultadoArea.setText("");
    }

    private void regresarInicio() {
        new InterfazBienvenida().setVisible(true);
        this.dispose();
    }
}



