public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        //throw new UnsupportedOperationException("Please implement the CarsAssemble.productionRatePerHour() method");
        if (speed < 5){
            return speed * 221;
        }else if (speed >= 5 && speed <= 8){
            return speed * 221 * 0.9;            
        }else if (speed == 9){
            return speed * 221 * 0.8;            
        }else {
            return speed * 221 * 0.77;            
        }
        
    }

    public int workingItemsPerMinute(int speed) {
        //throw new UnsupportedOperationException("Please implement the CarsAssemble.workingItemsPerMinute() method");
        return (int) productionRatePerHour(speed) / 60;
    }
}
