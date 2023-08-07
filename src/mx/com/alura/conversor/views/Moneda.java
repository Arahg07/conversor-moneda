package mx.com.alura.conversor.views;

import mx.com.alura.conversor.model.ConversorMoneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Moneda extends JFrame {
    private JLabel titulo;
    private  JLabel subTitulo;
    private  JLabel texto;
    private JLabel resultado;
    private JComboBox<String> monedasCambio;
    private JButton conversar;
    private JButton limpiar;
    private JButton regresar;
    private JTextField pesosMNX;

    public Moneda(){

        Componentes();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(515,330);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        setTitle("Moneda");

    }

    public void Componentes(){

        titulo  = new JLabel();
        titulo.setBounds(150,25, 250, 20);
        titulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
        titulo.setText("Conversor Moneda");
        add(titulo);

        subTitulo = new JLabel();
        subTitulo.setBounds(130, 80, 280, 20);
        subTitulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
        subTitulo.setText("Elige tu moneda de cambio:");
        add(subTitulo);

        pesosMNX = new JTextField();
        pesosMNX.setBounds(80, 130, 60, 25);
        pesosMNX.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
        pesosMNX.setText("0");
        add(pesosMNX);

        texto = new JLabel();
        texto.setBounds(150, 130, 60, 20);
        texto.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
        texto.setText("MNX");
        add(texto);

        String [] monedas ={"Dolar","Euro", "Libra", "Yen","Won"};

        monedasCambio = new JComboBox<>(monedas);
        monedasCambio.setBounds(250, 130, 150, 20);
        monedasCambio.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
        add(monedasCambio);


        conversar = new JButton();
        conversar.setBounds(10, 250, 150, 25);
        conversar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
        conversar.setText("Conversar");
        conversar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String regex = "-?\\d+";
                String opcion = (String) monedasCambio.getSelectedItem();
                double resultadoWrap= 0.0;
                String mnxText = pesosMNX.getText();

                if(!mnxText.matches(regex))
                {
                    JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros");
                }
                else {
                    double mnx = Double.parseDouble(pesosMNX.getText());
                    String resultadoConversion = " ";
                    ConversorMoneda conversorMonedaMnx;
                    switch (opcion) {
                        case "Dolar":
                            conversorMonedaMnx = new ConversorMoneda(mnx, 0.059);
                            resultadoWrap = ((double) Math.round(conversorMonedaMnx.convertir() * 100d) / 100d);
                            resultadoConversion = resultadoWrap + " Dolares";
                            break;
                        case "Euro":
                            conversorMonedaMnx = new ConversorMoneda(mnx, 0.054);
                            resultadoWrap = ((double) Math.round(conversorMonedaMnx.convertir() * 100d) / 100d);
                            resultadoConversion = resultadoWrap + " Euros";
                            break;
                        case "Libra":
                            conversorMonedaMnx = new ConversorMoneda(mnx, 0.046);
                            resultadoWrap = ((double) Math.round(conversorMonedaMnx.convertir() * 100d) / 100d);
                            resultadoConversion = resultadoWrap + " Libras";
                            break;
                        case "Yen":
                            conversorMonedaMnx = new ConversorMoneda(mnx, 8.39);
                            resultadoWrap = ((double) Math.round(conversorMonedaMnx.convertir() * 100d) / 100d);
                            resultadoConversion = resultadoWrap + " Yenes";
                            break;
                        case "Won":
                            conversorMonedaMnx = new ConversorMoneda(mnx, 75.96);
                            resultadoWrap = ((double) Math.round(conversorMonedaMnx.convertir() * 100d) / 100d);
                            resultadoConversion = resultadoWrap + " Wones";
                            break;
                        default:
                            resultadoConversion = "Vuelve a intentarlo";

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
                pesosMNX.setText("0");
                monedasCambio.setSelectedIndex(0);

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
