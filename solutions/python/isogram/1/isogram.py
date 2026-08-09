def is_isogram(phrase):


    clean_phrase = [c.lower() for c in phrase if c.isalpha()]
    return len(clean_phrase) == len(set(clean_phrase))