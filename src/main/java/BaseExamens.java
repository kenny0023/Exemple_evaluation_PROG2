import java.util.*;

class BaseExamens {
    private static final List<Examen> ALL = new ArrayList<>();
    static void add(Examen e) { ALL.add(e); }
    static List<Examen> getAll() { return ALL; }
}
