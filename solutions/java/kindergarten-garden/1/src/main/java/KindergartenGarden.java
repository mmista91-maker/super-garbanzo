import java.util.List;

class KindergartenGarden {

    private String garden;
    private String[] rows;
    private final List<String> students = List.of(
    "Alice",
    "Bob",
    "Charlie",
    "David",
    "Eve",
    "Fred",
    "Ginny",
    "Harriet", 
    "Ileana", 
    "Joseph", 
    "Kincaid", 
    "Larry"        
);

    KindergartenGarden(String garden) {
        this.garden = garden;
        this.rows = garden.split("\n");
}
        
    

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = students.indexOf(student);
        int startingIndex = studentIndex * 2;
        List<Character> plantChars = List.of(
            rows[0].charAt(startingIndex),
            rows[0].charAt(startingIndex + 1),
            rows[1].charAt(startingIndex),
            rows[1].charAt(startingIndex + 1)
);
        return plantChars.stream()
            .map(c -> Plant.getPlant(c))
            .toList();
    }

}
