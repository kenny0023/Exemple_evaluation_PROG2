import java.time.LocalDateTime;

public class Exam {
    private final int id;
    private final String titre;
    private final Course cours;
    private final LocalDateTime dateHeure;
    private final int coefficient;

    public Exam(int id, String titre, Course cours, LocalDateTime dateHeure, int coefficient) {
        this.id = id;
        this.titre = titre;
        this.cours = cours;
        this.dateHeure = dateHeure;
        this.coefficient = coefficient;
    }

    public int getId() { return id; }
    public String getTitre() { return titre; }
    public Course getCours() { return cours; }
    public LocalDateTime getDateHeure() { return dateHeure; }
    public int getCoefficient() { return coefficient; }

    @Override
    public String toString() {
        return String.format("Exam{id=%d, titre='%s', cours=%s, date=%s, coeff=%d}",
                id, titre, cours.getLabel(), dateHeure, coefficient);
    }
}
