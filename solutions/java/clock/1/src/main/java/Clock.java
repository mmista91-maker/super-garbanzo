import java.util.Objects;

class Clock {

    int hours;
    int minutes;

    Clock(int hours, int minutes) {
        int totalMinutes = Math.floorMod(hours * 60 + minutes, 1440);
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    void add(int addedMinutes) {
        int totalMinutes = Math.floorMod(this.hours * 60 + this.minutes + addedMinutes, 1440);
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Clock other)) {
            return false;
        }
        return this.hours == other.hours && this.minutes == other.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }
}