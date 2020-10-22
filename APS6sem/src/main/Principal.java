package main;

import org.bytedeco.javacv.FrameGrabber.Exception;
import controller.*;
import view.*;
import model.*;

public class Principal {

	public static void main(String[] args) throws Exception {
		Informacoes info = new Informacoes();
		Treinamento treinamento = new Treinamento();
		TelaLogin telaLogin = new TelaLogin();
		TelaWebcam telaWebcam = new TelaWebcam();
		TelaInicio telaInicio = new TelaInicio();
		ReconhecimentoFacial reconhecimentoFacial = new ReconhecimentoFacial(telaWebcam, info);
		ControllerPrincipal controllerPrincipal = new ControllerPrincipal(info, telaLogin, telaInicio, telaWebcam, reconhecimentoFacial);
		treinamento.treino();
		telaLogin.setVisible(true);
	}

}
