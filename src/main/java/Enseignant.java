public class Enseignant extends Personne {
    private final String email;
    private final String specialite;

    public Enseignant(int id, String nom, String prenom, LocalDate dateNaissance,
                      String telephone, String email, String specialite) {
        super(id, nom, prenom, dateNaissance, telephone);
        this.email = email;
        this.specialite = specialite;
    }

    public String getEmail() { return email; }
    public String getSpecialite() { return specialite; }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                String.format(", email='%s', spécialité='%s'}", email, specialite);
    }
}
