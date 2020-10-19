import java.awt.event.KeyEvent;
import java.awt.font.NumericShaper;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.FrameGrabber.Exception;
import org.bytedeco.javacv.OpenCVFrameConverter;
import org.bytedeco.javacv.OpenCVFrameGrabber;
import org.bytedeco.opencv.opencv_core.*;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.opencv.utils.Converters;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import static org.bytedeco.opencv.global.opencv_imgproc.resize;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;

public class Captura {
	public static void main(String[] args) throws FrameGrabber.Exception, InterruptedException {
		KeyEvent tecla = null;
		OpenCVFrameConverter.ToMat conversaoMat = new OpenCVFrameConverter.ToMat();
		OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0);
		camera.start();
		// chama a função para startar a webcam e capturar a img

		CascadeClassifier detecta = new CascadeClassifier("src\\recursos\\haarcascade_frontalface_alt.xml");

		CanvasFrame cFrame = new CanvasFrame("Teste Camera!", CanvasFrame.getDefaultGamma() / camera.getGamma());
		// define o titulo e define o tamanho da tela
		Frame frameCaptura = null;

		Mat imagemColorida = new Mat();

		int numAmostras = 25;
		int contAmostra = 1;

		Scanner cadastro = new Scanner(System.in);
		System.out.println("Digite seu ID:");
		int idUser = cadastro.nextInt();

		while ((frameCaptura = camera.grab()) != null) {
			imagemColorida = conversaoMat.convert(frameCaptura);
			Mat imagemCinza = new Mat();
			cvtColor(imagemColorida, imagemCinza, COLOR_BGRA2GRAY);
			// converte a img colorida capturada em img cinza

			RectVector facesDetectadas = new RectVector();
			detecta.detectMultiScale(imagemCinza, facesDetectadas, 1.1, 1, 0, new Size(150, 150), new Size(500, 500));
			
			if(tecla == null) {
				tecla = cFrame.waitKey(5);
			}

			for (int i = 0; i < facesDetectadas.size(); i++) {
				Rect dadosFace = facesDetectadas.get(0);
				rectangle(imagemColorida, dadosFace, new Scalar(0, 0, 255, 0));
				// identifica o rosto e coloca um retangulo vermelho ao redor do rosto detectado

				Mat faceCapturada = new Mat(imagemCinza, dadosFace);
				resize(faceCapturada, faceCapturada, new Size(160, 160));
				
				if(tecla == null) {
					tecla = cFrame.waitKey(5);
				}
				
				// captura a img dentro do retangulo
				if (tecla != null) {
					if (tecla.getKeyChar() == 'q') {
						if (contAmostra <= numAmostras) {
							imwrite("src\\fotos\\pessoa." + idUser + "." + contAmostra + ".jpg", faceCapturada);
							System.out.println("Foto" + contAmostra + "capturada\n");
							contAmostra++;
						}
					}tecla = null;
				}
				
			}
			
			if(tecla == null) {
				tecla = cFrame.waitKey(20);
			}
			
			if (cFrame.isVisible()) {
				cFrame.showImage(frameCaptura);
				// mostra a imagem capturada
			}

			if (contAmostra > numAmostras) {
				break;
				// para a captura das fotos
			}

		}

		cFrame.dispose();
		camera.stop();
	}
}
