from string import ascii_uppercase

LETTERS = ascii_uppercase

def rows(letter):

    target_idx = ascii_uppercase.index(letter)
    width = target_idx * 2 + 1
    top_half = []

    for i in range(target_idx + 1):
        char = ascii_uppercase[i]
        if i == 0:
            row = char.center(width)
        else:
            inner_spaces = " " * (2 * i - 1)
            row = f"{char}{inner_spaces}{char}".center(width)
        top_half.append(row)

    bottom_half = top_half[:-1][::-1]

    return top_half + bottom_half