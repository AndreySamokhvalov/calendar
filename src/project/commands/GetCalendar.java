package calendar.src.project.commands;

import calendar.src.project.console.Console;

public class GetCalendar implements Commands{

    Console console;

    public GetCalendar(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
//        печать календаря
        console.getPresenter().printDiary(console.getDiary());
    }

    @Override
    public String description() {
        return "показать весь календарь";
    }
}