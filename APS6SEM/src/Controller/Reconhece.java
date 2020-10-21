package Controller;
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
import org.opencv.utils.Converters;

import static org.bytedeco.opencv.global.opencv_imgproc.FONT_HERSHEY_PLAIN;
import static org.bytedeco.opencv.global.opencv_imgproc.putText;

public class Reconhece {
	
	public static int main(String[] args) throws FrameGrabber.Exception{
		
		OpenCVFrameConverter.ToMat conversaoMat = new OpenCVFrameConverter.ToMat();
		OpenCVFrameGrabber camera = new OpenCVFrameGrabber(0);
		camera.start();
		//inicia camera
		
		CascadeClassifier detecta = new CascadeClassifier("src\\recursos\\haarcascade_frontalface_alt.xml");
		//detecta rosto com auxilio de recursos
		
		FaceRecognizer reconhecedor = EigenFaceRecognizer.create();
		reconhecedor.read("src\\recursos\\classificadorEigenFaces.yml");
		//metodo reconhecedor utilizado
		
		IntPointer rotulo = new IntPointer(1);
		DoublePointer confianca = new DoublePointer(1);
		reconhecedor.predict(faceCapturada, rotulo, confianca);//
		int predicao = rotulo.get(0);
		//nivel de confiança
		
		System.out.println(confianca.get());
		
		if(confianca.get(0) <= 5000 && predicao == info.getUsuario(){
			return predicao;
		}else {
			return 0;
		}
	}
}
