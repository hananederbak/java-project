import java.io.IOException;
import java.util.List;
import java.io.File;

public class AnalyseurCsv {
    public static void main(String[] args) {
        final String DELIMITER = ";";
        File fichier = new File("data/java_project.csv");
        File outputFile = new File("data/résumé.csv");
        LecteurCSV lecteur = new LecteurCsvSimple();

        try {
            List<String> entetes = lecteur.lireEntetes(fichier, DELIMITER);
            List<List<Double>> donnees = lecteur.lireDonnees(fichier, DELIMITER);

            // TODO: Implémenter la logique d'analyse des données
        } catch (IOException e) {
            System.err.println("Erreur lecture : " + e.getMessage());
        }
    }
}




