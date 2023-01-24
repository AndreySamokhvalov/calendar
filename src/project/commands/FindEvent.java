package calendar.src.project.commands;

import calendar.src.project.console.Console;

public class FindEvent implements Commands{

    Console console;

    public FindEvent(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.getPresenter().findRecord();
    }

    @Override
    public String description() {
        return "найти запись";
    }
}