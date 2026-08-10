def to_rna(dna_strand):

    rna = ""
    for component in dna_strand[::1]:
        if component == "G":
            rna += "C"
        elif component == "T":
            rna += "A"
        elif component == "C":
            rna += "G"
        elif component == "A":
            rna += "U"
        else:
            return "invalid strand"

    return rna
            
            
    pass
