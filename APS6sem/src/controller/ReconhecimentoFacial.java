package controller;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import static org.bytedeco.opencv.global.opencv_imgproc.resize;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Point;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.EigenFaceRecognizer;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;

import view.TelaWebcam;
import model.Informacoes;

public class ReconhecimentoFacial {
	
	TelaWebcam telaWebcam;
	Informacoes info;
	Java2DFrameConverter jfc;
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
	int usuario;
	BufferedImage bfi;
	Image img;
	ImageIcon icon;
	
	public ReconhecimentoFacial(TelaWebcam tWebcam, Informacoes i) {
		telaWebcam = tWebcam;
		info = i;
	}
	
	public boolean reconhecer() throws Exception {
		conversaoMat = new OpenCVFrameConverter.ToMat();
		camera = new OpenCVFrameGrabber(0);
		
		camera.start();
		telaWebcam.setVisible(true);
		
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
			mostrarWebcam();
			
			for (int i = 0; i < facesDetectadas.size(); i++) {
				dadosFace = facesDetectadas.get(i);
				rectangle(imagemColorida, dadosFace, new Scalar(0, 255, 0, 0));
				faceCapturada = new Mat(imagemCinza, dadosFace);
				resize(faceCapturada, faceCapturada, new Size(160, 160));
				
				rotulo = new IntPointer(1);
				confianca = new DoublePointer(1);
				
				reconhecedor.predict(faceCapturada, rotulo, confianca);
				usuario = rotulo.get(0);
				if(confianca.get(0) <= 4500 && usuario == info.getUsuario()){
					System.out.println(confianca.get(0));
					camera.stop();
					return true;
				}
			}
		}
		camera.stop();
		return false;
	}
	
	public void mostrarWebcam(){
		jfc = new Java2DFrameConverter();
		bfi = Java2DFrameConverter.cloneBufferedImage(jfc.convert(frameCaptura));
		img = bfi;
		icon = new ImageIcon(img);
		icon.setImage(icon.getImage().getScaledInstance(telaWebcam.lblWebcamLabel.getWidth(), telaWebcam.lblWebcamLabel.getHeight(), 100));
		telaWebcam.lblWebcamLabel.setIcon(icon);
		telaWebcam.painel.revalidate();
		telaWebcam.painel.repaint();
		System.out.println("A");
	}
}
