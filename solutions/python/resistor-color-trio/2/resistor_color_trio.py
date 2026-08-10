values = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]

def label(colors):

    all = ""
    zeros = ""      
       
    for color in colors[:2]:
        all += str(values.index(color))
    
    zeros = "0" * values.index(colors[2])    
   
    total =  all+zeros    
    result = int(total)

    prefixes = [" ohms", " kiloohms", " megaohms", " gigaohms"]
    prefix_index = 0
    while result >= 1000:
        result = result // 1000
        prefix_index += 1

    
    label = f"{result}{prefixes[prefix_index]}"
   
    return label
    