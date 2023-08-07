package mx.com.alura.conversor.views;

import mx.com.alura.conversor.model.ConversorMoneda;
import mx.com.alura.conversor.model.ConversorTemperatura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temperatura extends JFrame {
    private JLabel titulo;
    private  JLabel subTitulo;
    private  JLabel texto;
    private JLabel resultado;
    private JComboBox<String> temperaturaCambio;
    private JButton conversar;
    private JButton limpiar;
    private JButton regresar;
    private JTextField temperatura;

    public Temperatura(){
        Componentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(515,330);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Temperatura");
    }

    public void Componentes(){

        titulo  = new JLabel();
        titulo.setBounds(120,25, 280, 20);
        titulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
        titulo.setText("Conversor Temperatura");
        add(titulo);

        subTitulo = new JLabel();
        subTitulo.setBounds(30, 80, 420, 20);
        subTitulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
        subTitulo.setText("Selecciona una opción Fahrenheit - Celsius:");
        add(subTitulo);

        temperatura = new JTextField();
        temperatura.setBounds(80, 120, 60, 25);
        temperatura.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
        temperatura.setText("0");
        add(temperatura);

        texto = new JLabel();
        texto.setBounds(150, 120, 60, 20);
        texto.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
        texto.setText("");
        add(texto);

        String [] unidadesTemperatura ={"Fahrenheit","Celsius"};

        temperaturaCambio = new JComboBox<>(unidadesTemperatura);
        temperaturaCambio.setBounds(210, 120, 150, 25);
        temperaturaCambio.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
        add(temperaturaCambio);

        conversar = new JButton();
        conversar.setBounds(10, 250, 150, 25);
        conversar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
        conversar.setText("Conversar");
        conversar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcion = (String) temperaturaCambio.getSelectedItem();
                double resultadoWrap= 0.0;
                String regex = "-?\\d+";
                String resultadoConversion = " ";
                ConversorTemperatura conversorTemperatura;

                String temperaturaText = temperatura.getText();

                if(!temperaturaText.matches(regex))
                {
                    JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros");
                }
                else {
                    double temperaturaIngresada = Double.parseDouble(temperatura.getText());
                    switch (opcion) {
                        case "Fahrenheit":
                            texto.setText(" C°");
                            conversorTemperatura = new ConversorTemperatura(temperaturaIngresada);
                            resultadoWrap = ((double) Math.round(conversorTemperatura.conversorFahrenheitCelcius() * 100d) / 100d);
                            resultadoConversion = resultadoWrap + " F°";
                            break;
                        case "Celsius":
                            texto.setText(" F°");
                            conversorTemperatura = new ConversorTemperatura(temperaturaIngresada);
                            resultadoWrap = ((double) Math.round(conversorTemperatura.conversorCelciusFahrenheit() * 100d) / 100d);
                            resultadoConversion = resultadoWrap + " C°";
                            break;
                        default:
                            resultadoConversion = "Sucedio un error, vueleve a intentarlo";
                    }

                    resultado.setText(resultadoConversion);
                }
            }
        });
        add(conversar);

        limpiar = new JButton();
        limpiar.setBounds(180, 250, 150, 25);
        limpiar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
        limpiar.setText("Limpiar");
        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado.setText("");
                temperatura.setText("0");
                temperaturaCambio.setSelectedIndex(0);
                texto.setText(" ");

            }
        });
        add(limpiar);

        regresar = new JButton();
        regresar.setBounds(350, 250, 150, 25);
        regresar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
        regresar.setText("Regresar");
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPrincipal();
            }
        });
        add(regresar);

        resultado = new JLabel();
        resultado.setBounds(150, 190, 200, 20 );
        resultado.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 24));
        resultado.setText("");
        add(resultado);



    }



}
