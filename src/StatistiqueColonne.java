import java.util.Collections;
import java.util.List;

public class StatistiqueColonne implements Statistique {
    private List<Double> valeurs;

    public StatistiqueColonne(List<Double> valeurs) {
        this.valeurs = valeurs;
    }

    @Override
    public Double moyenne() {
        if (valeurs.isEmpty()) return 0.0;
        double somme = 0;
        for (double v : valeurs) somme += v;
        return somme / valeurs.size();
    }

    @Override
    public Double min() {
        return valeurs.isEmpty() ? Double.NaN : Collections.min(valeurs);
    }

    @Override
    public Double max() {
        return valeurs.isEmpty() ? Double.NaN : Collections.max(valeurs);
    }
}

