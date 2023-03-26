import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MyCalendar {

    static int END_OF_WEEK = 7;
    static int[] MONTHS = {1, 2, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1};
    static String[] week = {"ПН", "ВТ", "СР", "ЧТ", "ПТ", "СБ", "ВС"};

    private final Date date;
    private Calendar cal;
    private int endOfMonth;
    private ArrayList month;
    private int curDay;
    private int firstDay;
    private int curNumber;
    private int curMonth;
    private int curYear;

    public MyCalendar(int monthID) {
        this.date = new Date();
        this.cal = Calendar.getInstance();
        this.month = new ArrayList<Integer>();
        this.curDay = date.getDay();
        this.curNumber = date.getDay();
        this.curMonth = monthID;
        this.curYear = cal.getWeekYear();
        this.firstDay = calcFirstDay();
    }

    public int getCurYear() {
        return curYear;
    }

    public int getCurMonth() {
        return curMonth;
    }

    public int calcFirstDay() {
        int month = curMonth + 1;
        int year = curYear;
        if (month <= 2) {
            month += 10;
            year -= 1;
        } else {
            month -= 2;
        }
        firstDay = (1 + ((31 * month) / 12) + year + (year / 4) - (year / 100) + (year / 400)) % 7;
        return firstDay;
    }

    public ArrayList getMonth() {
        switch (MONTHS[curMonth]) {
            case (0):
                endOfMonth = 30;
                break;
            case (1):
                endOfMonth = 31;
                break;
            case (2):
                endOfMonth = 28;
                break;
        }
        int daysBefore = firstDay - 1;
        if (firstDay == 0) {
            daysBefore = END_OF_WEEK - 1;
        }
        for (int day = 0; day < daysBefore; day++) {
            month.add(-1);
        }
        for (int day = 1; day <= endOfMonth; day++) {
            month.add(day);
        }
        return month;
    }

    public int getCurDay() {
        return curDay;
    }

    public int getCurNumber() {
        return curNumber;
    }

    public void showMonth() {
        getMonth();
        for (String s : week) {
            System.out.print(s + "\t");
        }
        System.out.println();
        int count = 1;
        for (int day = 0; day < this.month.size(); ++day) {
            if (count % END_OF_WEEK != 0) {
                if (this.month.get(day).equals(-1)) {
                    System.out.print("\t");
                    count++;
                } else {
                    System.out.print(this.month.get(day) + "\t");
                    count++;
                }
            } else {
                System.out.print(this.month.get(day) + "\t");
                System.out.println();
                count++;
            }
        }
    }
}
