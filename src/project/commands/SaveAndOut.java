package calendar.src.project.commands;

import calendar.src.project.console.Console;

public class SaveAndOut implements Commands{

    Console console;

    public SaveAndOut(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        console.getPresenter().saveDiary();
        System.exit(0);
    }

    @Override
    public String description() {
        return "сохранение в файл и выход";
    }
}