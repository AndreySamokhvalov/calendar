package calendar.src.project.commands;

import calendar.src.project.console.Console;

public class GetDayRecords implements Commands{

    Console console;

    public GetDayRecords(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.getPresenter().getDayRecords();
    }

    @Override
    public String description() {
        return "Записи на конкретный день";
    }
}