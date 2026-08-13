from datetime import timedelta

GIGASECOND = 1e9

def add(moment):
    return moment + timedelta(seconds=GIGASECOND)        
    
