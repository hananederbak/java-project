import java.io.*;
import java.util.*;

public class Rapport {
    List<List<String>> stats;

    public Rapport() {
        this.stats = new ArrayList<>();
    }

    public void add(String colonne, Double moyenne, Double min, Double max) {
        this.stats.add(Arrays.asList(colonne, moyenne.toString(), min.toString(), max.toString()));
    }

    public void enregistrerCSV(File outputFile, String delimiter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            List<String> entete = Arrays.asList("Colonne", "Moyenne", "Min", "Max");
            writer.write(String.join(delimiter, entete));
            writer.write(System.lineSeparator());

            for (List<String> stat : this.stats) {
                String ligne = String.join(delimiter, stat);
                writer.write(ligne);
                writer.write(System.lineSeparator());
            }

            System.out.println("\nRapport statistique généré dans '" + outputFile + "'");
        } catch (IOException e) {
            System.err.println("Erreur lors de la génération du rapport : " + e.getMessage());
        }
    }
}
