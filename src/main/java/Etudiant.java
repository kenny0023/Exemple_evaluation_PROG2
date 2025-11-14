public class Etudiant extends Personne {
    private final String groupe;
    private final Tuteur tuteur;

    public Etudiant(int id, String nom, String prenom, java.time.LocalDate dateNaissance,
                    String email, String telephone, String groupe, Tuteur tuteur) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.groupe = groupe;
        this.tuteur = tuteur;
    }

    public String getGroupe() { return groupe; }
    public boolean isTuteur() { return tuteur; }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                String.format(", groupe='%s', tuteurt=%b}", groupe, tuteur.getNom());
    }
}
