package view;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.github.sarxos.webcam.*;

public class TelaWebcam extends JFrame {

	public JPanel painel;
	public JLabel lblWebcamLabel;
	public JButton btnVoltar;

	public TelaWebcam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		
		painel = new JPanel();
		painel.setForeground(UIManager.getColor("textHighlight"));
		painel.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
		
		lblWebcamLabel = new JLabel();
		lblWebcamLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWebcamLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblWebcamLabel.setText("Carregando...");
		lblWebcamLabel.setBounds(10, 11, 604, 357);
		painel.add(lblWebcamLabel);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Serif", Font.BOLD, 18));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(SystemColor.textHighlight);
		btnVoltar.setBounds(10, 395, 96, 35);
		painel.add(btnVoltar);
		
	}
	
	public void addVoltarListener(ActionListener voltar) {
		btnVoltar.addActionListener(voltar);
	}
}
