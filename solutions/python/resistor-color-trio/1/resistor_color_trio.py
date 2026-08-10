values = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]

def label(colors):

    sum = ""
    zeros = ""      
       
    for color in colors[:2]:
        sum += str(values.index(color))
    
    zeros = "0" * values.index(colors[2])    
   
    total =  sum+zeros    
    result = int(total)

    prefixes = [" ohms", " kiloohms", " megaohms", " gigaohms"]
    prefix_index = 0
    while result >= 1000:
        result = result // 1000
        prefix_index += 1

    
    label = f"{result}{prefixes[prefix_index]}"
   
    return label
    