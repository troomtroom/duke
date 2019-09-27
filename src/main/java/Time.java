public class Time {

    int year;
    int month;
    int day;
    int hour;
    int minute;

    Time(int year,int month,int day,int hour,int minute) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    Time() {

    }

    /**
     * returns a printing format of time object with slashes.
     *
     * @return string with time in right format for display.
     */
    public String showtime() {
        return (this.day + "/"
                + this.month + "/"
                + this.year + " "
                + this.hour + ":"
                + this.minute);
    }

    public String toString() {
        return (this.day + " " + this.month + " " + this.year + " " + this.hour + " " + this.minute);
    }
}