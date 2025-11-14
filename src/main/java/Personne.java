import java.time.LocalDate;

public abstract class Personne {
    private final int id;
    private final String nom;
    private final String prenom;
    private final LocalDate dateNaissance;
    private final String telephone;

    public Personne(int id, String nom, String prenom, LocalDate dateNaissance, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.telephone = telephone;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getTelephone() { return telephone; }

    @Override
    public String toString() {
        return String.format("%s{id=%d, nom='%s', prenom='%s', dateNaiss=%s, tel='%s'}",
                getClass().getSimpleName(), id, nom, prenom, dateNaissance, telephone);
    }
}
