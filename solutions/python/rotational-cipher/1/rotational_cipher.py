def rotate(text, key):
    
    alphabet_lower = 'abcdefghijklmnopqrstuvwxyz'
    alphabet_upper = alphabet_lower.upper() 
    
    ciphertext = ''
    
    for char in text:
        if char in alphabet_lower:
            ciph_char = alphabet_lower[(alphabet_lower.index(char) + key) % 26]
            ciphertext += ciph_char
        elif char in alphabet_upper:
            ciph_char = alphabet_upper[(alphabet_upper.index(char) + key) % 26]
            ciphertext += ciph_char
        else:
            ciphertext += char

    return ciphertext
        
