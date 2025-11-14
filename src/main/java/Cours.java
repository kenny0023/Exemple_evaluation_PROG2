public class Cours {
    private final int id;
    private final String label;
    private final int credits;
    private final Enseignant enseignant;

    public Cours(int id, String label, int credits, Enseignant enseignant) {
        this.id = id;
        this.label = label;
        this.credits = credits;
        this.enseignant = enseignant;
    }

    public int getId() { return id; }
    public String getLabel() { return label; }
    public int getCredits() { return credits; }
    public Enseignant getEnseignant() { return enseignant; }

    @Override
    public String toString() {
        return String.format("Cours{id=%d, label='%s', crédits=%d, enseignant=%s %s}",
                id, label, credits, enseignant.getPrenom(), enseignant.getNom());
    }
}
