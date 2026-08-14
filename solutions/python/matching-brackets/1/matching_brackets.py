def is_paired(input_string):
    matching = {')': '(', ']': '[', '}': '{'}
    stack = []

    for char in input_string:
        if char in matching.values():
            stack.append(char)
        elif char in matching:
            if not stack or stack.pop() != matching[char]:
                return False
    return len(stack) == 0
