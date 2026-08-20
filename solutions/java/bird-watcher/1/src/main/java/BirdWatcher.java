
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public static int[] getLastWeek() {
        return new int[]{0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {        
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        for (int i: birdsPerDay){
            if (i == 0) {
                return true;
            }                    
            }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int total = 0;
        for (int i = 0; i < numberOfDays && i < birdsPerDay.length ; i++){
            total += birdsPerDay[i];
        }
        return total;

    }

    public int getBusyDays() {
        int total = 0;
        for (int i = 0; i < birdsPerDay.length; i++){
            if (birdsPerDay[i] >= 5){
                total += 1;
            }            
        }
        return total;
    }
}
