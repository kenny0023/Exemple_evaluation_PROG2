import java.time.*;
import java.util.*;

public static double getExamGrade(Exam exam, Exam student, Instant t) {
    Note note = GestionNotes.getNote(student, exam);
    if (note == null) return 0.0;

    LocalDateTime instantT = LocalDateTime.ofInstant(t, ZoneId.systemDefault())
            .truncatedTo(ChronoUnit.HOURS);

    return note.getHistorique().stream()
            .filter(c -> !c.date().isAfter(instantT))
            .max(Comparator.comparing(Changement::date))
            .map(Changement::valeurPrecedente)
            .orElse(note.getValeur());
}
