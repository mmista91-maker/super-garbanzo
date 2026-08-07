def equilateral(sides):
    return len(set(sides)) == 1 and sides[0] != 0


def isosceles(sides):
    a, b, c = sorted(sides)    
    return len(set(sides)) <= 2 and 0 not in sides and a + b > c #or equilateral(sides)

def scalene(sides):
    a, b, c = sorted(sides)
    return len(set(sides)) == 3 and 0 not in sides and a + b > c
