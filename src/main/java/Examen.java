import java.time.LocalDateTime;

public class Examen {
    private final int id;
    private final String titre;
    private final Cours cours;
    private final LocalDateTime dateHeure;
    private final int coefficient;

    public Examen(int id, String titre, Cours cours, LocalDateTime dateHeure, int coefficient) {
        this.id = id;
        this.titre = titre;
        this.cours = cours;
        this.dateHeure = dateHeure;
        this.coefficient = coefficient;
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public Cours getCours() { return cours; }
    public LocalDateTime getDateHeure() { return dateHeure; }
    public int getCoefficient() { return coefficient; }

    @Override
    public String toString() {
        return String.format("Examen{id=%d, titre='%s', cours=%s, date=%s, coeff=%d}",
                id, titre, cours.getLabel(), dateHeure, coefficient);
    }
}
