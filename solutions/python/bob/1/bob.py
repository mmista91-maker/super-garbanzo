def response(hey_bob):
    if hey_bob.endswith('?') and hey_bob.isupper():
        return 'Calm down, I know what I\'m doing!'
    elif hey_bob.strip().endswith('?'):
        return 'Sure.'
    elif hey_bob.isupper():
        return 'Whoa, chill out!'
    elif not hey_bob.strip():
        return 'Fine. Be that way!'
    else:
        return 'Whatever.'
