package Controller;
import static org.bytedeco.opencv.global.opencv_imgcodecs.*;
import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.MatVector;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.FaceRecognizer;
import org.bytedeco.opencv.opencv_face.*;
import static org.bytedeco.opencv.global.opencv_core.*;
import static org.bytedeco.opencv.global.opencv_imgproc.resize;


public class Treinamento {
    public static void main(String args[]) {
        File diretorio = new File("src\\fotos");
        FilenameFilter filtroImagem = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String nome) {
                return nome.endsWith(".jpg");
            }
        };
        
        File[] arquivos = diretorio.listFiles(filtroImagem);
        MatVector fotos = new MatVector(arquivos.length);
        Mat rotulos = new Mat(arquivos.length, 1, CV_32SC1);
        IntBuffer rotulosBuffer = rotulos.createBuffer();
        int contador = 0;
        
        for (File imagem: arquivos) {
            Mat foto = imread(imagem.getAbsolutePath(), IMREAD_GRAYSCALE);
            int login = Integer.parseInt(imagem.getName().split("\\.")[3]);
            resize(foto, foto, new Size(160,160));
            fotos.put(contador, foto);
            rotulosBuffer.put(contador, login);
            contador++;
        }
 
        FaceRecognizer eigenfaces = EigenFaceRecognizer.create(); 
        eigenfaces.train(fotos, rotulos);
        eigenfaces.save("src\\recursos\\classificadorEigenFaces.yml");
        //metodo escolhido pra treinamento 
        
    }
}
