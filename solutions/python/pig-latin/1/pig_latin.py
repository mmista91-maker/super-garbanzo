import string

vowels = {'a', 'e', 'i', 'o', 'u'}
consonants = set(string.ascii_lowercase) - vowels

def translate_word(word):
    
    if word[0] in vowels or word[:2] == 'xr' or word[:2] == 'yt':
        return word + 'ay'
    
    i = 0    
    while i < len(word) and word[i] in consonants and (word[i] != 'y' or i == 0):
        i += 1    
    
    if i < len(word) and word[i] == 'u' and i > 0 and word[i-1] == 'q':
        i += 1
        
    return word[i:] + word[:i] + 'ay'


def translate(text):
    return " ".join(translate_word(word) for word in text.split())