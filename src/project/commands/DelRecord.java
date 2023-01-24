package calendar.src.project.commands;

import calendar.src.project.console.Console;

public class DelRecord implements Commands{

    Console console;

    public DelRecord(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.getPresenter().delRecord();
    }

    @Override
    public String description() {
        return "удалить запись";
    }
}