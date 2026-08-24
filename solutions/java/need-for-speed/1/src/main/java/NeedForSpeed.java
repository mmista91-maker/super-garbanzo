class NeedForSpeed {
    
    private int speed;
    private int batteryDrain;
    private int distance = 0;
    private int batteryLevel = 100;
    
    NeedForSpeed(int speed, int batteryDrain) {     
    this.speed = speed;
    this.batteryDrain = batteryDrain;        
       
    }

    public boolean batteryDrained() {
        return this.batteryLevel < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distance;
    }

    public void drive() {
        
        if (!batteryDrained()){
        this.distance += this.speed;
        this.batteryLevel -= this.batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;
    
    RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean canFinishRace(NeedForSpeed car) {
        while(!car.batteryDrained()){
            car.drive();
        }
        return car.distanceDriven() >= this.distance;
    }
    
}


