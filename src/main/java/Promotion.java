import java.util.*;

public class Promotion {
    private final String nom;
    private final Set<String> groupes;

    public Promotion(String nom) {
        this.nom = nom;
        this.groupes = new HashSet<>();
    }

    public void ajouterGroupe(String g) { groupes.add(g); }
    public boolean contientGroupe(String g) { return groupes.contains(g); }
    public Set<String> getGroupes() { return Collections.unmodifiableSet(groupes); }

    @Override
    public String toString() {
        return String.format("Promotion{nom='%s', groupes=%s}", nom, groupes);
    }
}
