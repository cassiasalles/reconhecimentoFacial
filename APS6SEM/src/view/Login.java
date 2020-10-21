package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Login extends JFrame {

	private JPanel painel;
	private JTextField user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 455);
		painel = new JPanel();
		painel.setForeground(UIManager.getColor("textHighlight"));
		painel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		JLabel label1 = new JLabel("Atividade Pr\u00E1tica Supervisionada");
		label1.setFont(new Font("Serif", Font.BOLD, 20));
		label1.setBounds(195, 16, 296, 29);
		painel.add(label1);
		
		JLabel label2 = new JLabel("Ci\u00EAncia da Computa\u00E7\u00E3o 6\u00B0 Semestre");
		label2.setFont(new Font("Serif", Font.BOLD, 20));
		label2.setBounds(186, 61, 305, 29);
		painel.add(label2);
		
		JLabel label3 = new JLabel("Aplica\u00E7\u00E3o com autentica\u00E7\u00E3o utilizando reconhecimento facial");
		label3.setFont(new Font("Serif", Font.BOLD, 20));
		label3.setBounds(91, 112, 522, 29);
		painel.add(label3);
		
		user = new JTextField();
		user.setForeground(new Color(0, 0, 0));
		user.setBounds(91, 237, 522, 38);
		painel.add(user);
		user.setColumns(10);
		
		JLabel label4 = new JLabel("Digite seu usu\u00E1rio");
		label4.setFont(new Font("Serif", Font.BOLD, 20));
		label4.setBounds(91, 206, 150, 29);
		painel.add(label4);
		
		JButton entrarBtn = new JButton("Entrar");
		entrarBtn.setForeground(SystemColor.textHighlight);
		entrarBtn.setBackground(SystemColor.textHighlight);
		
			entrarBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			entrarBtn.setFont(new Font("Serif", Font.BOLD, 18));
			entrarBtn.setBounds(91, 291, 522, 29);
			painel.add(entrarBtn);
	}
}
