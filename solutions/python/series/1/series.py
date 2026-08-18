def slices(series, length):
    
    if length == 0:
        raise ValueError("slice length cannot be zero")
    if length < 0:
        raise ValueError("slice length cannot be negative")
    if series == "":
        raise ValueError("series cannot be empty")
    if len(series) < length:
        raise ValueError("slice length cannot be greater than series length")

    i = 0
    temp_length = length
    pieces = []
    for char in series:
        pieces.append(series[i:temp_length:])
        i += 1
        temp_length +=1
        if temp_length > len(series):
            break
            
        
        
    
    return pieces  

    
        
