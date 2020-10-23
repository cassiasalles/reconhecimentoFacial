package controller;

import static org.bytedeco.opencv.global.opencv_imgproc.*;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_face.*;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;

import view.*;
import model.Informacoes;

public class ReconhecimentoFacial {
	
	TelaWebcam telaWebcam;
	Informacoes info;
	TelaLogin telaLogin;
	OpenCVFrameConverter.ToMat conversaoMat;
	OpenCVFrameGrabber camera;
	CascadeClassifier detecta;
	FaceRecognizer reconhecedor;
	Frame frameCaptura;
	Mat imagemColorida;
	Mat imagemCinza;
	RectVector facesDetectadas;
	Rect dadosFace;
	Mat faceCapturada;
	IntPointer rotulo;
	DoublePointer confianca;
	CanvasFrame cWebcam;
	int contadorIdentificacao;
	
	public ReconhecimentoFacial(TelaWebcam tWebcam, Informacoes i, TelaLogin tLogin) {
		telaWebcam = tWebcam;
		info = i;
		telaLogin = tLogin;
	}
	
	public boolean reconhecer() throws Exception {
		conversaoMat = new OpenCVFrameConverter.ToMat();
		camera = new OpenCVFrameGrabber(0);
		contadorIdentificacao = 0;
		
		camera.start();
		
		abrirTela();
		
		detecta = new CascadeClassifier("src\\recursos\\haarcascade_frontalface_alt.xml");
		
		reconhecedor = EigenFaceRecognizer.create();
		reconhecedor.read("src\\recursos\\classificadorEigenFaces.yml");
		
		frameCaptura = null;
		imagemColorida = new Mat();
		
		while ((frameCaptura = camera.grab()) != null){
			imagemColorida = conversaoMat.convert(frameCaptura);
			imagemCinza = new Mat();
			cvtColor(imagemColorida, imagemCinza, COLOR_BGRA2GRAY);
			facesDetectadas = new RectVector();
			detecta.detectMultiScale(imagemCinza, facesDetectadas, 1.1, 2, 0, new Size(150, 150), new Size(500, 500));
			
			for (int i = 0; i < facesDetectadas.size(); i++) {
				dadosFace = facesDetectadas.get(i);
				destaqueFace();
				
				rotulo = new IntPointer(1);
				confianca = new DoublePointer(1);
				
				reconhecedor.predict(faceCapturada, rotulo, confianca);

				if(contadorIdentificacao > 30) {
					contadorIdentificacao = 0;
					if(confianca.get(0) <= 4500 && rotulo.get(0) == info.getUsuario()){
						camera.stop();
						fecharTela();
						return true;
					}
					else{
						if(telaWebcam.identificacaoUsuario()){
							voltarLogin();
						}
					}
				}
			}
			mostrarWebcam();
			contadorIdentificacao++;
		}
		camera.stop();
		return false;
	}
	
	public void abrirTela(){
		cWebcam = new CanvasFrame("", CanvasFrame.getDefaultGamma() / camera.getGamma());
		cWebcam.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
	}
	
	public void mostrarWebcam() {
		cWebcam.showImage(frameCaptura);
	}
	
	public void destaqueFace() {
		rectangle(imagemColorida, dadosFace, new Scalar(215, 120, 0, 0));
		faceCapturada = new Mat(imagemCinza, dadosFace);
		resize(faceCapturada, faceCapturada, new Size(160, 160));
	}
	
	public void fecharTela(){
		cWebcam.setVisible(false);
	}
	
	public void voltarLogin() throws Exception{
		camera.stop();
		cWebcam.setVisible(false);
		telaLogin.setVisible(true);
	}
}
