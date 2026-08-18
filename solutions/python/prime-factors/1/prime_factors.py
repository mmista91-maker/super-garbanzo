def factors(value):

    prime_factors = []
    i = 2    
    while i <= value:
        while value % i == 0:
            prime_factors.append(i)
            value //= i
        i += 1    
    
    return prime_factors  
