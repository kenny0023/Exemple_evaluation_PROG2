public class Tuteur extends Personne {
    private final String lienEtudiant;

    public Tuteur(int id, String nom, String prenom, java.time.LocalDate dateNaissance,
                  String email, String telephone, String lienEtudiant) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.lienEtudiant = lienEtudiant;
    }

    public String getLienEtudiant() { return lienEtudiant; }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                String.format(", lien='%s'}", lienEtudiant);
    }
}
