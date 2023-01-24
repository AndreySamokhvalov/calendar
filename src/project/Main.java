package calendar.src.project;

import calendar.src.project.file.FileHandler;
import calendar.src.project.file.Service;
import calendar.src.project.model.Diary;
import calendar.src.project.presenter.Presenter;
import calendar.src.project.console.Console;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        Service service = new Service(fileHandler);
        Presenter presenter = new Presenter(service);
        Console consoleUI = new Console(presenter);
        console.go();
    }
}