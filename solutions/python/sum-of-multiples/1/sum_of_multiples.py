def sum_of_multiples(limit, multiples):

    values = set()
    for num in multiples:
        if num == 0:
            continue
        for multiple in range(num, limit, num):
            values.add(multiple)
    
    return sum(values)
            
