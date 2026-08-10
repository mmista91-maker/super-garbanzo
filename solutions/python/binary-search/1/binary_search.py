def find(search_list, value):

    start_index = 0
    stop_index = len(search_list) - 1    

    
    while start_index <= stop_index:
        
        middle_index = (stop_index + start_index) // 2
        current_val = search_list[middle_index]
        
        if value == current_val: 
            return middle_index
        elif value < current_val:
            stop_index = middle_index - 1          
        else:
            start_index = middle_index + 1        
    
    raise ValueError("value not in array")