package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class TelaLogin extends JFrame {

	private JPanel painel;
	public JTextField fieldUser;
	private JLabel lblAPS;
	private JLabel lblCC;
	private JLabel lblApp;
	private JLabel lblUsuario;
	public JButton btnEntrar;

	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 455);
		painel = new JPanel();
		painel.setForeground(UIManager.getColor("textHighlight"));
		painel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		lblAPS = new JLabel("Atividade Pr\u00E1tica Supervisionada");
		lblAPS.setFont(new Font("Serif", Font.BOLD, 20));
		lblAPS.setBounds(195, 16, 296, 29);
		painel.add(lblAPS);
		
		lblCC = new JLabel("Ci\u00EAncia da Computa\u00E7\u00E3o 6\u00B0 Semestre");
		lblCC.setFont(new Font("Serif", Font.BOLD, 20));
		lblCC.setBounds(186, 61, 346, 29);
		painel.add(lblCC);
		
		lblApp = new JLabel("Aplica\u00E7\u00E3o com autentica\u00E7\u00E3o utilizando reconhecimento facial");
		lblApp.setFont(new Font("Serif", Font.BOLD, 20));
		lblApp.setBounds(91, 112, 578, 29);
		painel.add(lblApp);
		
		fieldUser = new JTextField();
		fieldUser.setForeground(new Color(0, 0, 0));
		fieldUser.setBounds(91, 237, 522, 38);
		painel.add(fieldUser);
		fieldUser.setColumns(10);
		
		lblUsuario = new JLabel("Digite seu usu\u00E1rio");
		lblUsuario.setFont(new Font("Serif", Font.BOLD, 20));
		lblUsuario.setBounds(91, 206, 211, 29);
		painel.add(lblUsuario);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(SystemColor.textHighlight);	
		btnEntrar.setFont(new Font("Serif", Font.BOLD, 18));
		btnEntrar.setBounds(91, 291, 522, 29);
		painel.add(btnEntrar);
	}
	
	public void addEntrarListener(ActionListener entrar) {
		btnEntrar.addActionListener(entrar);
	}
}