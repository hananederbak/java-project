import java.io.IOException;
import java.util.List;
import java.io.File;

public interface LecteurCSV {
    List<String> lireEntetes(File fichier, String delimiter) throws IOException;
    List<List<Double>> lireDonnees(File fichier, String delimiter) throws IOException;
}
