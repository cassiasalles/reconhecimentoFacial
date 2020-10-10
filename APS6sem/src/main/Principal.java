package main;

import controller.*;
import model.Informacoes;
import view.*;

public class Principal {

	public static void main(String[] args) {
		Informacoes info = new Informacoes();
		TelaLogin telaLogin = new TelaLogin();
		TelaInicio telaInicio = new TelaInicio();
		CapturarWebcam capturarWebcam = new CapturarWebcam();
		CompararImagens compararImagens = new CompararImagens();
		ControllerPrincipal cp = new ControllerPrincipal(info, telaLogin, telaInicio, capturarWebcam, compararImagens);
		telaLogin.setVisible(true);

	}

}
