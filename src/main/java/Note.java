import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Note {
    private final Etudiant etudiant;
    private final Examen examen;
    private double valeur;
    private final List<Changement> historique;

    public Note(Etudiant etudiant, Examen examen, double valeurInitiale, String motifInitial) {
        this.etudiant = etudiant;
        this.examen = examen;
        this.valeur = valeurInitiale;
        this.historique = new ArrayList<>();
        historique.add(new Changement(LocalDateTime.now().truncatedTo(ChronoUnit.HOURS), valeurInitiale, motifInitial));
    }

    public void setValeur(double nouvelle, String motif) {
        LocalDateTime maintenant = LocalDateTime.now().truncatedTo(ChronoUnit.HOURS);
        historique.add(new Changement(maintenant, this.valeur, motif));
        this.valeur = nouvelle;
    }

    public Etudiant getEtudiant() { return etudiant; }
    public Examen getExamen() { return examen; }
    public double getValeur() { return valeur; }

    public double getValeurAInstant(LocalDateTime t) {
        return historique.stream()
                .filter(c -> !c.date().isAfter(t))
                .max(Comparator.comparing(Changement::date))
                .map(Changement::valeurPrecedente)
                .orElse(valeur);
    }

    public List<Changement> getHistorique() { return Collections.unmodifiableList(historique); }

    @Override
    public String toString() {
        return String.format("Note{étudiant=%s %s, examen=%s, note=%.2f, hist=%s}",
                etudiant.getPrenom(), etudiant.getNom(), examen.getTitre(), valeur, historique);
    }

    record Changement(LocalDateTime date, double valeurPrecedente, String motif) {}
}
