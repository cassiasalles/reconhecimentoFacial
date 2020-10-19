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
import static org.bytedeco.opencv.global.opencv_imgproc.FONT_HERSHEY_PLAIN;
import static org.bytedeco.opencv.global.opencv_imgproc.putText;

public class Reconhecimento {
	
	public static void main(String[] args) throws FrameGrabber.Exception {
		
		OpenCVFrameConverter.ToMat conversaoMat = new OpenCVFrameConverter.ToMat();
		OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0);
		String[] pessoas = {" ", "Max", "Bigode"};
		camera.start();
		
		CascadeClassifier detecta = new CascadeClassifier("src\\recursos\\haarcascade_frontalface_alt.xml");
		
		FaceRecognizer reconhecedor = EigenFaceRecognizer.create();
		reconhecedor.read("src\\recursos\\classificadorEigenFaces.yml");
		
		CanvasFrame cFrame = new CanvasFrame("Reconhecimento!", CanvasFrame.getDefaultGamma() / camera.getGamma());
		Frame frameCaptura = null;
		Mat imagemColorida = new Mat();
		
		while ((frameCaptura = camera.grab()) != null) {
			imagemColorida = conversaoMat.convert(frameCaptura);
			Mat imagemCinza = new Mat();
			cvtColor(imagemColorida, imagemCinza, COLOR_BGRA2GRAY);
			RectVector facesDetectadas = new RectVector();
			detecta.detectMultiScale(imagemCinza, facesDetectadas, 1.1, 2, 0, new Size(150, 150), new Size(500, 500));
			for (int i = 0; i < facesDetectadas.size(); i++) {
				Rect dadosFace = facesDetectadas.get(i);
				rectangle(imagemColorida, dadosFace, new Scalar(0, 255, 0, 0));
				Mat faceCapturada = new Mat(imagemCinza, dadosFace);
				resize(faceCapturada, faceCapturada, new Size(160, 160));
				
				IntPointer rotulo = new IntPointer(1);
				DoublePointer confianca = new DoublePointer(1);
				reconhecedor.predict(faceCapturada, rotulo, confianca);
				int predicao = rotulo.get(0);
				String nome;
				if(predicao == -1) {
					nome = "Desconhecido";
				}else {
					nome = pessoas[predicao] + " - " + confianca.get(0);
				}
				
				int x = Math.max(dadosFace.tl().x() -10, 0);
				int y = Math.max(dadosFace.tl().y() -10, 0);
				putText(imagemColorida, nome, new Point(x, y), FONT_HERSHEY_PLAIN, 1.4, new Scalar(0, 255, 0, 0));		
				}
			if (cFrame.isVisible()) {
				cFrame.showImage(frameCaptura);
				// mostra a imagem capturada
		}
		
		}
		cFrame.dispose();
		camera.stop();
	}
}
