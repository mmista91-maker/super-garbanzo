def is_armstrong_number(number):
    number_string = str(number)
    digits = [int(digit) for digit in number_string]
    digits_sq = []
    for digit in digits:
        digits_sq.append(digit ** len(number_string))
    
    return sum(digits_sq) == number
    
    
