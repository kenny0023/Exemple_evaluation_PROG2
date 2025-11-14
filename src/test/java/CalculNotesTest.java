import org.junit.jupiter.api.*;
import java.time.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class CalculNotesTest {

    private static Etudiant etudiant;
    private static Enseignant enseignant;
    private static Tuteur tuteur;
    private static Cours cours;
    private static Examen examen1, examen2;
    private static Note note1, note2;

    @BeforeAll
    static void init() {
        // Tuteur
        tuteur = new Tuteur(1, "Dupont", "Marie", LocalDate.of(1980, 5, 15),
                "marie.dupont@email.com", "0123456789", "mère");

        // Étudiant
        etudiant = new Etudiant(100, "Martin", "Luc", LocalDate.of(2002, 3, 20),
                "luc.martin@etu.fr", "0600000000", "G1", tuteur);

        // Enseignant
        enseignant = new Enseignant(200, "Durand", "Alice", LocalDate.of(1975, 8, 10),
                "alice.durand@ens.fr", "0611111111", "back-end");

        // Cours
        cours = new Cours(300, "PROG2", 6, enseignant);

        // Examens
        LocalDateTime dateEx1 = LocalDateTime.of(2025, 11, 1, 10, 0);
        LocalDateTime dateEx2 = LocalDateTime.of(2025, 11, 8, 14, 0);
        examen1 = new Examen(1, "TP1", cours, dateEx1, 2);
        examen2 = new Examen(2, "DS", cours, dateEx2, 3);

        // Ajouter les examens à la base
        BaseExamens.add(examen1);
        BaseExamens.add(examen2);

        // Notes avec motif
        note1 = new Note(etudiant, examen1, 10.0, "Note initiale");
        note2 = new Note(etudiant, examen2, 15.0, "Note initiale");

        // Enregistrer les notes
        GestionNotes.enregistrer(note1);
        GestionNotes.enregistrer(note2);

        // Simuler un changement sur la première note
        note1.setValeur(12.0, "Correction erreur de copie");
    }

    @Test
    @DisplayName("getExamGrade - avant changement")
    void testGetExamGradeAvantChangement() {
        Instant t = LocalDateTime.of(2025, 11, 1, 11, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        double grade = CalculNotes.getExamGrade(examen1, etudiant, t);
        assertEquals(10.0, grade, 0.01, "La note doit être 10.0 avant changement");
    }

    @Test
    @DisplayName("getExamGrade - après changement")
    void testGetExamGradeApresChangement() {
        Instant t = LocalDateTime.of(2025, 11, 2, 10, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        double grade = CalculNotes.getExamGrade(examen1, etudiant, t);
        assertEquals(12.0, grade, 0.01, "La note doit être 12.0 après changement");
    }

    @Test
    @DisplayName("getExamGrade - examen inexistant")
    void testGetExamGradeExamenInexistant() {
        Examen fauxExamen = new Examen(999, "Faux", cours,
                LocalDateTime.now(), 1);

        double grade = CalculNotes.getExamGrade(fauxExamen, etudiant, Instant.now());
        assertEquals(0.0, grade, 0.01, "Doit retourner 0.0 si pas de note");
    }

    @Test
    @DisplayName("getCourseGrade - moyenne pondérée correcte")
    void testGetCourseGradeMoyennePonderee() {
        Instant t = LocalDateTime.of(2025, 11, 10, 0, 0)
                .atZone(ZoneId.systemDefault())
                .toInstant();

        // (12 * 2 + 15 * 3) / (2 + 3) = (24 + 45) / 5 = 69 / 5 = 13.8
        double expected = 13.8;

        double grade = CalculNotes.getCourseGrade(cours, etudiant, t);
        assertEquals(expected, grade, 0.01,
                "La moyenne pondérée doit être 13.8");
    }

    @Test
    @DisplayName("getCourseGrade - aucun examen")
    void testGetCourseGradeAucunExamen() {
        Cours coursVide = new Cours(999, "MATH", 4, enseignant);
        Instant t = Instant.now();

        double grade = CalculNotes.getCourseGrade(coursVide, etudiant, t);
        assertEquals(0.0, grade, 0.01, "Doit retourner 0.0 si aucun examen");
    }

    @Test
    @DisplayName("getCourseGrade - coefficient total nul")
    void testGetCourseGradeCoefficientNul() {
        Examen exZero = new Examen(3, "Test", cours,
                LocalDateTime.now(), 0);
        BaseExamens.add(exZero);
        Note noteZero = new Note(etudiant, exZero, 20.0, "Test");
        GestionNotes.enregistrer(noteZero);

        Instant t = Instant.now();
        double grade = CalculNotes.getCourseGrade(cours, etudiant, t);

        // Doit ignorer les coefficients nuls → calcul basé sur les autres examens
        double expected = (12.0 * 2 + 15.0 * 3) / 5.0; // 13.8
        assertEquals(expected, grade, 0.01);
    }

    @AfterAll
    static void tearDown() {
        // Nettoyage (optionnel)
        BaseExamens.getAll().clear();
    }
}
