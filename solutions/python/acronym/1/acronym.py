import re

def abbreviate(words):
    words = re.split(r"[- _]+", words)
    acronym = ""
    for word in words:
        if word:
            acronym += word[0]
    return acronym.upper()
