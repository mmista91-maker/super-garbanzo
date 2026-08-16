def egg_count(display_value):
    
    binary = bin(display_value)
    bin_str = str(binary)
    
    eggs = 0
    
    for char in bin_str:
        if char == '1':
            eggs += 1

    return eggs
