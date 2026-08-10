def to_rna(dna_strand):

    rna = str.maketrans("GCTA", "CGAU")

    return dna_strand.translate(rna)
