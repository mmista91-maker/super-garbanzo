values = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"]

tolerances = {
    "grey": "0.05%",
    "violet": "0.1%",
    "blue": "0.25%",
    "green": "0.5%",
    "brown": "1%",
    "red": "2%",
    "gold": "5%",
    "silver": "10%"
}

def resistor_label(colors):    

    if len(colors) == 1:
        return f"{values.index(colors[0])} ohms"

    digits_count = 3 if len(colors) == 5 else 2
    
    main_digits = ""
    zeros = ""      
       
    for color in colors[:digits_count]:
        main_digits += str(values.index(color))
    
    multiplier_color = colors[digits_count]
    zeros = "0" * values.index(multiplier_color)
   
    total =  main_digits+zeros    
    result = int(total)

    prefixes = [" ohms", " kiloohms", " megaohms", " gigaohms"]
    prefix_index = 0
    while result >= 1000:
        result = result / 1000
        prefix_index += 1

    if isinstance(result, float) and result.is_integer():
        result = int(result)
    
    if len(colors) >= 4:
        tol_val = tolerances[colors[-1]]
        return f"{result}{prefixes[prefix_index]} ±{tol_val}"

    return f"{result}{prefixes[prefix_index]}"