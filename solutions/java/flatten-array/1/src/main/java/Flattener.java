import java.util.ArrayList;
import java.util.List;

class Flattener {

    List<Object> flatten(List<?> list) {

        ArrayList<Object> flattened = new ArrayList<>();

        if (list == null) {
            return flattened;
        }

        for (Object obj: list){

            if (obj == null) {
                continue;
            }
            if (obj instanceof List<?> nestedList) {
                flattened.addAll(flatten(nestedList));
            }
            else {
                flattened.add(obj);
            }
        }
        return flattened;
    }

}