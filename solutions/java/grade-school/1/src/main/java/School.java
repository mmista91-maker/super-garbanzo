import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;

class School {

    private Map<Integer, List<String>> students = new TreeMap<>();

    boolean add(String student, int grade) {        
        for (List<String> list : students.values()) {
            if (list.contains(student)) {
                return false;
            }
        }
        students.computeIfAbsent(grade, klucz -> new ArrayList<>())
                .add(student);
        return true;        
        }
    
    List<String> roster() {
        List<String> allStudents = new ArrayList<>();
        for (List<String> gradeStudents : students.values()){
            gradeStudents.sort(null);
            allStudents.addAll(gradeStudents);            
        }         
            return allStudents;
    }

    List<String> grade(int grade) {
        
        List<String> result = new ArrayList<>(
                students.getOrDefault(grade, new ArrayList<>())
        );
    
        result.sort(null);
        return result;
}

}
