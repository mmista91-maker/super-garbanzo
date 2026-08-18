import re

def decode(string):
    decoded = []
    for count, char in re.findall(r"(\d*)([a-zA-Z ])", string):
        n = int(count) if count else 1
        decoded.append(char * n)
        
    return "".join(decoded)        


def encode(string):
    if not string:
            return ""
    
    result = []
    current_char = string[0]
    count = 0
    
    for char in string:
        if char == current_char:
            count += 1
        else:               
            count_str = str(count) if count > 1 else ""
            result.append(f"{count_str}{current_char}")                   
            current_char = char
            count = 1
    
       
    count_str = str(count) if count > 1 else ""
    result.append(f"{count_str}{current_char}")
    
    return "".join(result)