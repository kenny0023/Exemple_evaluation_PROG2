import java.util.List;

public static double getCourseGrade(Course course, Exam student, Instant t) {
    List<Exam> examens = GestionNotes.getExamensDuCours(course);
    if (examens.isEmpty()) return 0.0;

    double sommePonderee = 0.0;
    int sommeCoefficients = 0;

    for (Exam exam : examens) {
        double note = getExamGrade(exam, student, t);
        sommePonderee += note * exam.getCoefficient();
        sommeCoefficients += exam.getCoefficient();
    }

    return sommeCoefficients == 0 ? 0.0 : sommePonderee / sommeCoefficients;
}
