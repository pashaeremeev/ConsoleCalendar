public enum DaysOfWeek {
    MONDAY("ПН"),
    TUESDAY("ВТ"),
    WEDNESDAY("СР"),
    THURSDAY("ЧТ"),
    FRIDAY("ПТ"),
    SATURDAY("СБ"),
    SUNDAY("ВС");

    private String name;

    DaysOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


