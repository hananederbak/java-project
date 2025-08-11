import java.io.*;
import java.util.*;
import java.io.File;

// Implémentation de l'interface LecteurCSV pour lire un fichier CSV
public class LecteurCsvSimple implements LecteurCSV {
    @Override
    public List<String> lireEntetes(File fichier, String delimiter) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            String ligne = br.readLine();

            if (ligne == null || ligne.trim().isEmpty()) {
                throw new IOException("Le fichier CSV est vide ou n'a pas d'en-têtes.");
            }

            return Arrays.asList(ligne.split(delimiter));
        } catch (FileNotFoundException e) {
            throw new IOException("Fichier '" + fichier + "' introuvable.");
        }
    }

    @Override
    public List<List<Double>> lireDonnees(File fichier, String delimiter) throws IOException {
        List<List<Double>> colonnes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fichier))) {
            // Lire les en-têtes pour initialiser les listes
            String ligneEntetes = br.readLine();

            if (ligneEntetes == null || ligneEntetes.trim().isEmpty()) {
                throw new IOException("Le fichier CSV est vide ou n'a pas d'en-têtes.");
            }

            String[] entetes = ligneEntetes.split(delimiter); // TODO: utuliser la fonction d'en ahut

            for (int i = 0; i < entetes.length; i++) {
                colonnes.add(new ArrayList<>());
            }


            int numLigne = 2;
            for (String ligne = br.readLine(); ligne != null; ligne = br.readLine(), numLigne++) {
                String[] valeurs = ligne.split(delimiter);

                if (valeurs.length != entetes.length) {
                    System.err.println("Avertissement : Ligne " + numLigne + " mal formatée, ignorée.");
                    continue;
                }

                for (int i = 0; i < valeurs.length; i++) {
                    try {
                        colonnes.get(i).add(Double.parseDouble(valeurs[i]));
                    } catch (NumberFormatException e) {
                        System.out.println("Avertissement ligne " + numLigne + ": La valeur '" + valeurs[i] + "' de la colonne '" + entetes[i] + "' n'est pas formatable.");
                    }
                }
            }

            return colonnes;
        } catch (FileNotFoundException e) {
            throw new IOException("Fichier '" + fichier + "' introuvable.");
        }
    }
}

