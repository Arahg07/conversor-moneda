package mx.com.alura.conversor.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

	private JLabel titulo;
	private  JLabel subTitulo;
	private JComboBox<String> menu;

	JButton comenzar;

	/**
	 * 
	 */
	public MenuPrincipal(){

		Componentes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,250);
		setLocationRelativeTo(null);
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setTitle("Menu Principal");

	}

	public void Componentes(){
		titulo  = new JLabel();
		titulo.setBounds(130,25, 150, 20);
		titulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		titulo.setText("Conversor");
		add(titulo);

		subTitulo = new JLabel();
		subTitulo.setBounds(20, 90, 180, 20);
		subTitulo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		subTitulo.setText("Elige una opción:");
		add(subTitulo);

		String [] menuConversor ={"Moneda", "Temperatura"};
		menu = new JComboBox<>(menuConversor);
		menu.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 12));
		menu.setBounds(200, 90, 150, 20);
		add(menu);

		comenzar = new JButton();
		comenzar.setBounds(120, 180, 150, 25);
		comenzar.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 14));
		comenzar.setText("Comenzar");
		comenzar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String opcion = (String) menu.getSelectedItem();

				if(opcion == "Temperatura") {
					System.out.println("Temperatura");
					dispose();
					new Temperatura();
				}
				else {
					System.out.println("Moneda");
					dispose();
					new Moneda();
				}
			}
		});
		add(comenzar);


	}
}
