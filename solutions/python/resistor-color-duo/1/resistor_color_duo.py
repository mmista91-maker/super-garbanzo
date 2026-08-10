codes = {
    "black": 0, 
    "brown": 1, 
    "red": 2, 
    "orange": 3, 
    "yellow": 4, 
    "green": 5, 
    "blue": 6, 
    "violet": 7, 
    "grey": 8, 
    "white": 9
}

def value(colors):
    
    digits = ""    

    for color in colors[:2]:
        digits += str(codes[color])    
    
    return int(digits)
