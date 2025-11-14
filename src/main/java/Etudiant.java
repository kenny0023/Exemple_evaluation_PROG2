public class Etudiant extends Personne {
    private final String groupe;
    private final boolean tutorat;

    public Etudiant(int id, String nom, String prenom, LocalDate dateNaissance,
                    String telephone, String groupe, boolean tutorat) {
        super(id, nom, prenom, dateNaissance, telephone);
        this.groupe = groupe;
        this.tutorat = tutorat;
    }

    public String getGroupe() { return groupe; }
    public boolean isTutorat() { return tutorat; }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                String.format(", groupe='%s', tutorat=%b}", groupe, tutorat);
    }
}
