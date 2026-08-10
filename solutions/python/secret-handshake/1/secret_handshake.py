def commands(binary_str):


    actions = ["wink", "double blink", "close your eyes", "jump"]
    sequence = []

    for index, bit in enumerate(binary_str[::-1]):
        if bit == "1":
            if index < 4:
                sequence.append(actions[index])
            if index == 4:
                sequence.reverse()

    return sequence
         
         

    
    
