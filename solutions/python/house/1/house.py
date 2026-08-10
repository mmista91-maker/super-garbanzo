def recite(start_verse, end_verse):
    
    phrases = [
        "the horse and the hound and the horn that belonged to ",
        "the farmer sowing his corn that kept ",
        "the rooster that crowed in the morn that woke ",
        "the priest all shaven and shorn that married ",
        "the man all tattered and torn that kissed ",
        "the maiden all forlorn that milked ",
        "the cow with the crumpled horn that tossed ",
        "the dog that worried ",
        "the cat that killed ",
        "the rat that ate ",
        "the malt that lay in ",
        "the house that Jack built."
    ]

    result = []

    for n in range(start_verse, end_verse + 1):
        verse_phrases = phrases[-n:]
        
        verse = "This is " + "".join(verse_phrases)
        result.append(verse)

    return result