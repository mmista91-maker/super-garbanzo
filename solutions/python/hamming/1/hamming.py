def distance(strand_a, strand_b):
    
    hamm = 0
    if len(strand_a) == len(strand_b):
        hamm = sum(1 for char1, char2 in zip(strand_a, strand_b) if char1 != char2)
    else:
        raise ValueError("Strands must be of equal length.")

    return hamm
        
