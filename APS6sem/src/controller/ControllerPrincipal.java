package controller;

import java.awt.event.*;
import org.bytedeco.javacv.FrameGrabber.Exception;

import model.*;
import view.*;

public class ControllerPrincipal {
	
	public Informacoes info;
	public TelaLogin telaLogin;
	public TelaInicio telaInicio;
	public TelaWebcam telaWebcam;
	public ReconhecimentoFacial reconhecimentoFacial;
	public boolean usuario_valido;

	
	public ControllerPrincipal(Informacoes i, TelaLogin tLogin, TelaInicio tInicio, TelaWebcam tWebcam, ReconhecimentoFacial rFacial) {
		info = i;
		telaLogin = tLogin;
		telaInicio = tInicio;
		telaWebcam = tWebcam;
		reconhecimentoFacial = rFacial;
		
		telaLogin.addEntrarListener(new Entrar());
		telaWebcam.addVoltarListener(new Voltar());
		telaInicio.addSairListener(new Sair());
	}
	
	class Entrar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			telaLogin.dispose();
			info.setUsuario(Integer.parseInt(telaLogin.fieldUser.getText()));
			try {
				usuario_valido = reconhecimentoFacial.reconhecer();
			} catch (Exception e1) {
				
			}
			if(usuario_valido) {
				switch(info.getUsuario()){
					case 1:
						info.setNvl_acesso(1);
						info.setCargo("Funcionário");
						info.setNome("Gabriel Santos");
						break;
					case 2:
						info.setNvl_acesso(1);
						info.setCargo("Funcionário");
						info.setNome("Leonardo Ferreira");
						break;
					case 3:
						info.setNvl_acesso(2);
						info.setNome("Maxwell Oliveira");
						info.setCargo("Diretor de Divisão");
						break;
					case 4:
						info.setNvl_acesso(3);
						info.setNome("Cassia Rezende");
						info.setCargo("Ministro do Meio Ambiente");
						break;
				}
				telaWebcam.dispose();
				telaInicio.lblUsuarioLogado.setText(Integer.toString(info.getUsuario()));
				telaInicio.lblNome.setText(info.getNome());
				telaInicio.lblUsuarioNvlAcesso.setText(Integer.toString(info.getNvl_acesso()));
				telaInicio.lblUsuarioCargo.setText(info.getCargo());
				telaInicio.setVisible(true);
			}
		}
	}
	
	class Voltar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telaWebcam.dispose();
			telaLogin.setVisible(true);
		}
	}
	
	class Sair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telaInicio.dispose();
            System.exit(0);
		}
	}
}
