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
	private JTextPane txtpnObs;

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
		fieldUser.setFont(new Font("Serif", Font.PLAIN, 16));
		fieldUser.setForeground(new Color(0, 0, 0));
		fieldUser.setBounds(91, 231, 116, 38);
		painel.add(fieldUser);
		fieldUser.setColumns(10);
		
		lblUsuario = new JLabel("Digite seu ID");
		lblUsuario.setFont(new Font("Serif", Font.BOLD, 20));
		lblUsuario.setBounds(91, 201, 152, 29);
		painel.add(lblUsuario);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(SystemColor.textHighlight);	
		btnEntrar.setFont(new Font("Serif", Font.BOLD, 18));
		btnEntrar.setBounds(91, 280, 152, 29);
		painel.add(btnEntrar);
		
		txtpnObs = new JTextPane();
		txtpnObs.setFont(new Font("Serif", Font.PLAIN, 16));
		txtpnObs.setText(". Escolha um ambiente com boa ilumina\u00E7\u00E3o\r\n. Se posicione a curta dist\u00E2ncia da c\u00E2mera\r\n. Digite o ID do seu usu\u00E1rio no campo acima, pois o login s\u00F3 ser\u00E1 efetuado \r\n  se o usu\u00E1rio identificado for o mesmo do especificado no campo");
		txtpnObs.setEditable(false);
		txtpnObs.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		txtpnObs.setBounds(91, 320, 492, 96);
		painel.add(txtpnObs);
	}
	
	public void addEntrarListener(ActionListener entrar) {
		btnEntrar.addActionListener(entrar);
	}
}