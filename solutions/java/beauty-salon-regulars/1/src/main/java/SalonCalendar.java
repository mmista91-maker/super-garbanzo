import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

class SalonCalendar {

    public LocalDate standingAppointment(int year, Month month, int occurrence, DayOfWeek dayOfWeek) {
        return LocalDate.of(year, month, 1)
                .with(TemporalAdjusters.dayOfWeekInMonth(occurrence, dayOfWeek));
    }

    public LocalDate lastAppointment(int year, Month month, DayOfWeek dayOfWeek) {
        return LocalDate.of(year, month, 1)
                .with(TemporalAdjusters.lastInMonth(dayOfWeek));
    }

    public LocalDate nextAvailable(LocalDate from, DayOfWeek dayOfWeek) {
        return from.with(TemporalAdjusters.nextOrSame(dayOfWeek));
    }

    public LocalDate bookkeepingDay(int year, Month month) {
        LocalDate lastDay = LocalDate.of(year, month, 1)
                .with(TemporalAdjusters.lastDayOfMonth());
        if (lastDay.getDayOfWeek() == DayOfWeek.SATURDAY || lastDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
            lastDay = lastDay.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return lastDay;
    }

    public LocalDate payday(int year, Month month) {

        LocalDate payday = LocalDate.of(year, month, 15);
        if (payday.getDayOfWeek() == DayOfWeek.SATURDAY || payday.getDayOfWeek() == DayOfWeek.SUNDAY) {
            payday = payday.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
        }
        return payday;
    }

    public TemporalAdjuster precedingWorkday() {
        return temporal -> {
            LocalDate date = LocalDate.from(temporal);
            if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                return date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
            }
            return date;
        };
    }
}
