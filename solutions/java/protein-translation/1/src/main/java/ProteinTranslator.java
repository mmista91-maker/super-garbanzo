import java.util.List;
import java.util.Map;
import java.util.ArrayList;


class ProteinTranslator {

private static final Map<String, String> CODONS = Map.ofEntries(
    Map.entry("AUG", "Methionine"),
    Map.entry("UUU", "Phenylalanine"),
    Map.entry("UUC", "Phenylalanine"),
    Map.entry("UUA", "Leucine"),
    Map.entry("UUG", "Leucine"),
    Map.entry("UCU", "Serine"),
    Map.entry("UCC", "Serine"),
    Map.entry("UCA", "Serine"),
    Map.entry("UCG", "Serine"),
    Map.entry("UAU", "Tyrosine"),
    Map.entry("UAC", "Tyrosine"),
    Map.entry("UGU", "Cysteine"),
    Map.entry("UGC", "Cysteine"),
    Map.entry("UGG", "Tryptophan"),
    Map.entry("UAA", "STOP"),
    Map.entry("UAG", "STOP"),
    Map.entry("UGA", "STOP")
);
    
    List<String> translate(String rnaSequence) {
    
    List<String> proteins = new ArrayList<>();
        
    for (int i = 0; i < rnaSequence.length(); i += 3){
    
    if (i + 3 > rnaSequence.length()){
    throw new IllegalArgumentException("Invalid codon");
    }
    String codon = rnaSequence.substring(i,i+3);
    String protein = CODONS.get(codon);
    if ("STOP".equals(protein)){
        break;
    }
    if (protein == null) {
    throw new IllegalArgumentException("Invalid codon");
    }
    proteins.add(protein);
    }
    return proteins;    
    }
    
}
