package controller;

import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;

public class ControllerPrincipal {
	public Informacoes info;
	public TelaLogin telaLogin;
	public TelaInicio telaInicio;
	public CapturarWebcam cWebcam;
	public CompararImagens cImagens;
	
	public ControllerPrincipal(Informacoes i, TelaLogin tLogin, TelaInicio tInicio, CapturarWebcam cw, CompararImagens cImg) {
		info = i;
		telaLogin = tLogin;
		telaInicio = tInicio;
		cWebcam = cw;
		cImagens = cImg;
	}
	
	class Entrar implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			info.setUser(telaLogin.usuarioField.getText());
			info.setArquivo_capturado(cWebcam.capturar());
			boolean usuario_valido = cImagens.comparar();
			if(usuario_valido){
				switch(info.getUsuario()){
					case "gabriel_santos":
					case "leonardo_ferreira":
						String[] acoes_permitidas_func = {"Propriedades", "Tipos de agrtóxico"};
						info.setNvl_acesso(1);
						info.setCargo("Funcionário");
						info.setAcoes_permitidas(acoes_permitidas_func);
						break;
					case "maxwell_oliveira":
						String[] acoes_permitidas_cien = {"Propriedades", "Tipos de agrtóxico", "Impactos"};
						info.setNvl_acesso(2);
						info.setCargo("Cientista");
						info.setAcoes_permitidas(acoes_permitidas_cien);
						break;
					case "cassia_rezende":
						String[] acoes_permitidas_min = {"Propriedades", "Tipos de agrtóxico", "Impactos", "Funcionarios"};
						info.setNvl_acesso(3);
						info.setCargo("Ministro do Meio Ambiente");
						info.setAcoes_permitidas(acoes_permitidas_min);
						break;
				}
				telaInicio.usuarioLabel.setText(info.getUsuario());
				telaInicio.nvlAcessoLabel.setText(info.getNvl_acesso());
				telaInicio.cargoLabel.setText(info.getCargo());
				telaInicio.nomeLabel.setText(info.getNome());
				telaInicio.acoesLabel(info.getAcoes_permitidas());
				telaLogin.dispose();
				telaInicio.setVisible(true);
			}
		}
	}
	
	class Sair implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			telaInicio.dispose();
            System.exit(0);
		}
	}
}
