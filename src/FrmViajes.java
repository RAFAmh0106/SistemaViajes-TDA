import javax.swing.*;
import java.awt.*;

public class FrmViajes extends JFrame {

    private JTextField txtNombre;
    private JTextField txtOrigen;
    private JTextField txtDestino;
    private JTextField txtDistancia;
    private JTextField txtCosto;
    private JTextField txtPasajeros;

    private JTextArea txtResultado;

    private JButton btnCalcular;
    private JButton btnRecursivo;
    private JButton btnEspecial;
    private JButton btnLimpiar;



    public FrmViajes() {

        setTitle("Sistema de Viajes");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(10, 10));
        panelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        // Titulo
        JPanel panelEncabezado = new JPanel();
        panelEncabezado.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel(
                "SISTEMA DE VIAJES",
                SwingConstants.CENTER
        );

        lblTitulo.setFont(
                new Font("Arial", Font.BOLD, 24)
        );

        JLabel lblAutor = new JLabel(
                "RAFAEL MARQUEZ HERNANDEZ 4A",
                SwingConstants.CENTER
        );

        lblAutor.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        panelEncabezado.add(
                lblTitulo,
                BorderLayout.NORTH
        );

        panelEncabezado.add(
                lblAutor,
                BorderLayout.SOUTH
        );

        panelPrincipal.add(
                panelEncabezado,
                BorderLayout.NORTH
        );

        // Formulario
        JPanel panelFormulario = new JPanel(
                new GridLayout(6, 2, 8, 8)
        );


        panelFormulario.add(
                new JLabel("Nombre:")
        );

        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);


        panelFormulario.add(
                new JLabel("Origen:")
        );

        txtOrigen = new JTextField();
        panelFormulario.add(txtOrigen);


        panelFormulario.add(
                new JLabel("Destino:")
        );

        txtDestino = new JTextField();
        panelFormulario.add(txtDestino);


        panelFormulario.add(
                new JLabel("Distancia (km):")
        );

        txtDistancia = new JTextField();
        panelFormulario.add(txtDistancia);


        panelFormulario.add(
                new JLabel("Costo por pasajero:")
        );

        txtCosto = new JTextField();
        panelFormulario.add(txtCosto);


        panelFormulario.add(
                new JLabel("Número de pasajeros:")
        );

        txtPasajeros = new JTextField();
        panelFormulario.add(txtPasajeros);


        // Resultado
        txtResultado = new JTextArea();

        txtResultado.setEditable(false);

        txtResultado.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        txtResultado.setLineWrap(true);

        txtResultado.setWrapStyleWord(true);


        JScrollPane scroll = new JScrollPane(
                txtResultado
        );


        // Panel que contiene formulario y resultado
        JPanel panelCentro = new JPanel();

        panelCentro.setLayout(
                new BorderLayout(10, 10)
        );

        panelCentro.add(
                panelFormulario,
                BorderLayout.NORTH
        );

        panelCentro.add(
                scroll,
                BorderLayout.CENTER
        );


        panelPrincipal.add(
                panelCentro,
                BorderLayout.CENTER
        );


        JPanel panelBotones = new JPanel();

        btnCalcular = new JButton(
                "Calcular viaje"
        );

        btnRecursivo = new JButton(
                "Costo recursivo"
        );

        btnEspecial = new JButton(
                "Viaje especial"
        );

        btnLimpiar = new JButton(
                "Limpiar"
        );


        panelBotones.add(btnCalcular);
        panelBotones.add(btnRecursivo);
        panelBotones.add(btnEspecial);
        panelBotones.add(btnLimpiar);

        panelPrincipal.add(
                panelBotones,
                BorderLayout.SOUTH
        );


        // Eventos
        btnCalcular.addActionListener(
                e -> calcularViaje()
        );


        btnRecursivo.addActionListener(
                e -> calcularCostoRecursivo()
        );

        btnEspecial.addActionListener(
                e ->mostrarViajeEspecial()
        );

        btnLimpiar.addActionListener(
                e -> limpiar()
        );

        // Agregar panel principal a la ventana
        add(panelPrincipal);

        // Mostrar ventana
        setVisible(true);
    }


    private void calcularViaje() {

        try {

            String nombre = txtNombre.getText();
            String origen = txtOrigen.getText();
            String destino = txtDestino.getText();

            float distancia =
                    Float.parseFloat(
                            txtDistancia.getText()
                    );

            float costo =
                    Float.parseFloat(
                            txtCosto.getText()
                    );

            int pasajeros =
                    Integer.parseInt(
                            txtPasajeros.getText()
                    );


            tdaViajes viaje = new tdaViajes(
                    nombre,
                    origen,
                    destino,
                    distancia,
                    costo,
                    pasajeros
            );


            txtResultado.setText(
                    viaje.mostrarInformacion()
            );


        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Revisa los datos ingresados.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private void calcularCostoRecursivo() {

        try {
            float costo =
                    Float.parseFloat(
                            txtCosto.getText()
                    );

            int pasajeros =
                    Integer.parseInt(
                            txtPasajeros.getText()
                    );


            tdaViajes viaje = new tdaViajes(
                    "Viaje",
                    "Origen",
                    "Destino",
                    0,
                    costo,
                    pasajeros
            );

            float resultado =
                    viaje.calcularCostorecursivo(
                            pasajeros
                    );

            txtResultado.setText(
                    "CALCULO RECURSIVO\n\n" +
                            "Costo por pasajero: $" + costo +
                            "\nNúmero de pasajeros: " + pasajeros +
                            "\nCosto total: $" + resultado
            );

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    this,
                    "Ingresa un costo y número de pasajeros válidos.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void mostrarViajeEspecial(){
        try {
            String nombre= txtNombre.getText();
            String origen = txtOrigen.getText();
            String destino = txtDestino.getText();

            float distancia = Float.parseFloat(txtDistancia.getText());
            float costo = Float.parseFloat(txtCosto.getText());
            int pasajeros = Integer.parseInt(txtPasajeros.getText());

            ViajeEspecial viaje = new ViajeEspecial(
                    nombre,origen,destino,distancia,costo,pasajeros,"Especial"
            );

            txtResultado.setText(viaje.mostrarInformacion()+"\n"+viaje.mostarViaje());
        } catch (Exception e){
            JOptionPane.showMessageDialog(this,"Revisa los datos ingresados","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {

        txtNombre.setText("");
        txtOrigen.setText("");
        txtDestino.setText("");
        txtDistancia.setText("");
        txtCosto.setText("");
        txtPasajeros.setText("");

        txtResultado.setText("");
    }


    public static void main(String[] args) {

        new FrmViajes();
    }
}