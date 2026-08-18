def say(number):
   
    if number < 0 or number > 999_999_999_999:
        raise ValueError("input out of range")
    
    if number == 0:
        return "zero"

    LESS_THAN_20 = ["", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                    "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", 
                    "sixteen", "seventeen", "eighteen", "nineteen"]

    TENS = ["", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]
    THOUSANDS = ["", "thousand", "million", "billion"]

    
    def helper(n):
        if n == 0:
            return ""
        elif n < 20:
            return LESS_THAN_20[n] + " "
        elif n < 100:
            rest = helper(n % 10)
            # Jeśli jest reszta (np. 3 w 23), łączymy myślnikiem: "twenty-three"
            return TENS[n // 10] + ("-" + rest.strip() if rest else "") + " "
        else:
            return LESS_THAN_20[n // 100] + " hundred " + helper(n % 100)

    
    parts = []
    i = 0
    while number > 0:
        chunk = number % 1000
        if chunk != 0:
            chunk_text = helper(chunk).strip()
            scale = THOUSANDS[i]
            if scale:
                parts.append(f"{chunk_text} {scale}")
            else:
                parts.append(chunk_text)
        number //= 1000
        i += 1


    parts.reverse()
    return " ".join(parts)