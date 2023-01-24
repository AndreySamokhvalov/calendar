package calendar.src.project.console;

import calendar.src.project.commands.*;
import calendar.src.project.commands.Commands;
import calendar.src.project.commands.SaveAndFinish;
import calendar.src.project.model.Day;
import calendar.src.project.model.Diary;
import calendar.src.project.model.Record;
import calendar.src.project.presenter.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Diary diary;
    private Presenter presenter;
    List<Commands> commandsList;

    public Console(Presenter presenter) {
        this.presenter = presenter;
        diary = this.presenter.readDiary();
        commandsList = new ArrayList<>();
        presenter.setConsole(this);
    }

    public Diary getDiary() {
        return diary;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void go() {
        Scanner iScanner = new Scanner(System.in);
//        заполняем список команд UI
        commandsList.add(new SaveAndFinish(this));
        commandsList.add(new GetCalendar(this));
        commandsList.add(new GetDayRecords(this));
        commandsList.add(new AddRecord(this));
        commandsList.add(new FindEvent(this));
        commandsList.add(new DelRecord(this));

        while (true) {
            System.out.println("Выберите действие:");
            for (int i = 0; i < commandsList.size(); i++) {
                System.out.println(i + " - " + commandsList.get(i).description());
            }
            System.out.print("-->\t");
            String str = iScanner.nextLine();
            try {
                int choice = Integer.parseInt(str);
                if ((choice >= 0) & (choice < commandsList.size())) {
                    commandsList.get(Integer.parseInt(str)).execute();
                } else {
                    System.out.println("Не корректный ввод! Повторите попытку.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод! Повторите попытку.");
            }
        }
    }

    /*
    печать Diary
     */
    public void printDiary(Diary diary) {
        System.out.println(diary);
    }

    /*
    печать всех записей на день дня
     */
    public void printDay(int dayNum, Day day) {
        if (day.getRecords().size() > 0) {
            System.out.printf("Записи %s дня:\n", dayNum);
            System.out.println(day);
        } else {
            System.out.printf("Записей %s дня не обнаружено.\n", dayNum);
        }
    }

    /*
    печать конкретной записи
     */
    public void printRecord(String findedRecord) {
        System.out.println(findedRecord);
    }

    /*
    получить запись от пользователяя 
     */
    public Record getRecord(boolean full) {
        String event;
        int hour = 0;
        Scanner iScanner = new Scanner(System.in);
        if (full) {
            while (true) {
                System.out.print("Укажите время: ");
                String str = iScanner.nextLine();
                try {
                    hour = Integer.parseInt(str);
                    if ((hour >= 0) & (hour < 24)) {
                        break;
                    } else {
                        System.out.println("Время должно быть в диапазоне от 0 до 23! Повторите ввод.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Не корректный ввод! Повторите попытку.");
                }
            }
        }
        System.out.print("Введите событие: ");
        event = iScanner.nextLine();
        return new Record(hour, event);
    }

    /*
    получить номер дня
     */
    public int getDay() {
        Scanner iScanner = new Scanner(System.in);
        int day;
        while (true) {
            System.out.print("Введите день: ");
            String str = iScanner.nextLine();
            try {
                day = Integer.parseInt(str);
                if ((day >= 1) & (day <= 31)) {
                    break;
                } else {
                    System.out.println("День должен быть в диапазоне от 1 до 31! Повторите ввод.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод! Повторите попытку.");
            }
        }
        return day;
    }
}