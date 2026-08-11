def line_up(name, number):
    
    if 11 <= (number%100) <= 13:
        ending = "th"
    else:
        ending = {1:"st", 2:"nd", 3:"rd"}.get(number % 10, "th") #dic.get(val-to-find-in-dic , optional-default-value)

    return f"{name}, you are the {number}{ending} customer we serve today. Thank you!"
    