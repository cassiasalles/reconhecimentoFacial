package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.awt.*;

public class TelaInicio extends JFrame {

	private JPanel contentPane;
	private JLabel lblBemVindo;
	public JLabel lblNome;
	private JLabel lblInformaesCadastrais;
	private JLabel lblUsuario;
	private JLabel lblNvlAcesso;
	private JLabel lblCargo;
	public JButton btnSair;
	public JLabel lblUsuarioLogado;
	public JLabel lblUsuarioNvlAcesso;
	public JLabel lblUsuarioCargo;

	public TelaInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 451);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblBemVindo = new JLabel("Seja Bem vindo (a)");
		lblBemVindo.setFont(new Font("Serif", Font.BOLD, 30));
		lblBemVindo.setBounds(47, 35, 247, 39);
		contentPane.add(lblBemVindo);
		
		lblNome = new JLabel("");
		lblNome.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		lblNome.setBounds(304, 35, 361, 39);
		contentPane.add(lblNome);
		
		lblInformaesCadastrais = new JLabel("Informa\u00E7\u00F5es cadastrais");
		lblInformaesCadastrais.setFont(new Font("Serif", Font.BOLD, 26));
		lblInformaesCadastrais.setBounds(15, 125, 448, 29);
		contentPane.add(lblInformaesCadastrais);
		
		lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setFont(new Font("Serif", Font.BOLD, 18));
		lblUsuario.setBounds(15, 160, 77, 30);
		contentPane.add(lblUsuario);
		
		lblNvlAcesso = new JLabel("N\u00EDvel de acesso:");
		lblNvlAcesso.setFont(new Font("Serif", Font.BOLD, 18));
		lblNvlAcesso.setBounds(15, 200, 130, 30);
		contentPane.add(lblNvlAcesso);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Serif", Font.BOLD, 18));
		lblCargo.setBounds(15, 240, 61, 30);
		contentPane.add(lblCargo);
		
		lblUsuarioLogado = new JLabel("");
		lblUsuarioLogado.setBounds(92, 160, 350, 30);
		contentPane.add(lblUsuarioLogado);
		
		lblUsuarioNvlAcesso = new JLabel("");
		lblUsuarioNvlAcesso.setBounds(145, 200, 350, 30);
		contentPane.add(lblUsuarioNvlAcesso);
		
		lblUsuarioCargo = new JLabel("");
		lblUsuarioCargo.setBounds(76, 240, 350, 30);
		contentPane.add(lblUsuarioCargo);
		
		btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Serif", Font.BOLD, 18));
		btnSair.setForeground(Color.WHITE);
		btnSair.setBackground(SystemColor.textHighlight);
		btnSair.setBounds(517, 350, 164, 29);
		contentPane.add(btnSair);
	}
	
	public void addSairListener(ActionListener sair) {
		btnSair.addActionListener(sair);
	}
}

