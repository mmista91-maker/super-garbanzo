def is_valid(isbn):    
    
    sum = 0
    chars = [x for x in isbn.replace("-", "")]

    for x in chars[:-1]:
        if not x.isdigit():
            return False
    
    if len(chars) != 10:
        return False
    if chars [-1].isdigit():
        pass   
    elif chars[-1] == 'X':
        chars[-1] = '10'             
    else: 
        return False
    
    
    digits =  [int(x) for x in chars]
    
    factor = 10
    
    for digit in digits:
        sum = sum + digit*factor        
        factor -= 1
           
    return sum % 11 == 0
