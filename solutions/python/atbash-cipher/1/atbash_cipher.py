Plain = 'abcdefghijklmnopqrstuvwxyz'
Cipher = 'zyxwvutsrqponmlkjihgfedcba'

TRANS_TABLE = str.maketrans(Plain, Cipher)

def encode(plain_text):
    
    clean_text = ''.join(ch.lower() for ch in plain_text if ch.isalnum())
    cipher_text = clean_text.translate(TRANS_TABLE)
    return ' '.join(cipher_text[i : i + 5] for i in range(0, len(cipher_text), 5))


def decode(ciphered_text):
    decoded = ciphered_text.translate(TRANS_TABLE)
    return decoded.replace(' ','')