package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.SystemColor;

public class Home extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 451);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label1 = new JLabel("Seja Bem vindo (a)");
		label1.setFont(new Font("Serif", Font.BOLD, 30));
		label1.setBounds(104, 35, 247, 39);
		contentPane.add(label1);
		
		JLabel user_username = new JLabel("Usu\u00E1rio");
		user_username.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
		user_username.setBounds(352, 35, 212, 39);
		contentPane.add(user_username);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Serif", Font.BOLD, 18));
		btnSair.setForeground(SystemColor.textHighlight);
		btnSair.setBackground(SystemColor.textHighlight);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSair.setBounds(517, 350, 164, 29);
		contentPane.add(btnSair);
		
		JLabel lblInformaesCadastrais = new JLabel("Informa\u00E7\u00F5es cadastrais:");
		lblInformaesCadastrais.setFont(new Font("Serif", Font.BOLD, 26));
		lblInformaesCadastrais.setBounds(15, 125, 283, 29);
		contentPane.add(lblInformaesCadastrais);
		
		JLabel lblNome = new JLabel("Usu\u00E1rio:");
		lblNome.setFont(new Font("Serif", Font.BOLD, 18));
		lblNome.setBounds(16, 155, 69, 29);
		contentPane.add(lblNome);
		
		JLabel user_name = new JLabel("Usu\u00E1rio X");
		user_name.setFont(new Font("Serif", Font.ITALIC, 18));
		user_name.setBounds(87, 157, 248, 24);
		contentPane.add(user_name);
		
		JLabel lblNewLabel = new JLabel("N\u00EDvel de acesso:");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel.setBounds(17, 184, 131, 20);
		contentPane.add(lblNewLabel);
		
		JLabel user_acesso = new JLabel("N\u00EDvel X");
		user_acesso.setFont(new Font("Serif", Font.ITALIC, 18));
		user_acesso.setBounds(146, 182, 201, 24);
		contentPane.add(user_acesso);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Serif", Font.BOLD, 18));
		lblCargo.setBounds(15, 204, 53, 24);
		contentPane.add(lblCargo);
		
		JLabel user_cargo = new JLabel("Cargo X");
		user_cargo.setFont(new Font("Serif", Font.ITALIC, 18));
		user_cargo.setBounds(75, 202, 72, 29);
		contentPane.add(user_cargo);
	}
}
