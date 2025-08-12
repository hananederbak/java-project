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

            Rapport rapport = new Rapport();

            for (int i = 0; i < entetes.size(); i++) {
                Statistique stats = new StatistiqueColonne(donnees.get(i));

                Double moyenne = stats.moyenne();
                Double min = stats.min();
                Double max = stats.max();

                System.out.println("Colonne: " + entetes.get(i));
                System.out.println("  Moyenne: " + String.format("%.2f", moyenne));
                System.out.println("  Min: " + min);
                System.out.println("  Max: " + max);
                rapport.add(entetes.get(i), moyenne, min, max);
            }

            // Génération du rapport (bonus)
            rapport.enregistrerCSV(outputFile, DELIMITER);
        } catch (IOException e) {
            System.err.println("Erreur lecture : " + e.getMessage());
        }
    }
}




