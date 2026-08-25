import java.util.HashMap;
import java.util.Map;

public class DialingCodes {
    
    public Map<Integer, String> codes = new HashMap<>();
    
    public Map<Integer, String> getCodes() {
        return codes;
    }

    public void setDialingCode(Integer code, String country) {
        codes.put(code, country);
    }

    public String getCountry(Integer code) {
       return codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!codes.containsKey(code) && !codes.containsValue(country)) {
        codes.put(code, country);
    }
    }

    public Integer findDialingCode(String country) {
        for (Map.Entry<Integer, String> entry : codes.entrySet()) {
            if (entry.getValue().equals(country)) {
            return entry.getKey();
        }
    }
    return null; 
        
    }

    public void updateCountryDialingCode(Integer newCode, String country) {
        if (codes.containsValue(country)){
            Integer oldCode = findDialingCode(country);
            codes.remove(oldCode);
            codes.put(newCode, country);
        }
        
    }
    
}