def square_root(number):
    for factor in range(1, number+1):
        if factor * factor == number:
            return factor
