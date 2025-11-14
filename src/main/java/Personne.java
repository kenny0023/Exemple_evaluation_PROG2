import java.time.LocalDate;

public abstract class Personne {
    private final int id;
    private final String nom;
    private final String prenom;
    private final LocalDate dateNaissance;
    protected final String email;
    private final String telephone;

    public Personne(int id, String nom, String prenom, LocalDate dateNaissance, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.telephone = telephone;
    }

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public LocalDate getDateNaissance() { return dateNaissance; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }

    @Override
    public String toString() {
        return String.format("%s{id=%d, nom='%s', prenom='%s', dateNaiss=%s, email='%s', tel='%s'}",
                getClass().getSimpleName(), id, nom, prenom, dateNaissance, email, telephone);
    }
}
