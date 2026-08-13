from datetime import datetime, timedelta

gigasecond = 1e9

def add(moment):
    return moment + timedelta(seconds=gigasecond)        
    
