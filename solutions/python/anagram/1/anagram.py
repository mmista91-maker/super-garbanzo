def find_anagrams(word, candidates):

    anagrams = []
    word_lower = word.lower()
    word_sorted = sorted(word_lower)
    
    for candidate in candidates:       
        candidate_lower = candidate.lower()
        if sorted(candidate_lower) == word_sorted and candidate_lower != word_lower:
            anagrams.append(candidate)
    return anagrams