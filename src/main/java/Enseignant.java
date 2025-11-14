public class Enseignant extends Personne {
    private final String specialite;

    public Enseignant(int id, String nom, String prenom, java.time.LocalDate dateNaissance,
                      String email, String telephone, String specialite) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.email = email;
        this.specialite = specialite;
    }

    public String getSpecialite() { return specialite; }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                String.format(", spécialité='%s'}", specialite);
    }
}
