"""
This exercise stub and the test suite contain several enumerated constants.

Enumerated constants can be done with a NAME assigned to an arbitrary,
but unique value. An integer is traditionally used because it’s memory
efficient.
It is a common practice to export both constants and functions that work with
those constants (ex. the constants in the os, subprocess and re modules).

You can learn more here: https://en.wikipedia.org/wiki/Enumerated_type
"""

# Possible sublist categories.
# Change the values as you see fit.
SUBLIST = 1
SUPERLIST = 2
EQUAL = 3
UNEQUAL = 0


def sublist(list_one, list_two):
    
    one_str = ','.join(map(str, list_one)) + ','
    two_str = ','.join(map(str, list_two)) + ','

    if one_str == two_str:
        return 3    
    elif one_str.find(two_str) != -1: #1 contains 2
        return 2
    elif two_str.find(one_str) != -1: #2 contains 1
        return 1
    else:
        return 0
