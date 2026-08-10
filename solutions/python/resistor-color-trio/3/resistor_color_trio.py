values = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]

def label(colors):

    first_two = ""
    zeros = ""      
       
    for color in colors[:2]:
        first_two += str(values.index(color))
    
    zeros = "0" * values.index(colors[2])    
   
    total =  first_two+zeros    
    result = int(total)

    prefixes = [" ohms", " kiloohms", " megaohms", " gigaohms"]
    prefix_index = 0
    while result >= 1000:
        result = result // 1000
        prefix_index += 1

    
    label = f"{result}{prefixes[prefix_index]}"
   
    return label
    