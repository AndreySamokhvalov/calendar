package calendar.src.project.presenter;

import calendar.src.project.file.Service;
import calendar.src.project.model.Day;
import calendar.src.project.model.Diary;
import calendar.src.project.model.Record;
import calendar.src.project.console.Console;

public class Presenter {
    private Diary diary;
    private Console console;

    private Service service;

    public Presenter(Service service) {
        this.service = service;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public void printDiary(Diary diary) {
        getConsole().printDiary(diary);
    }

    /*
     * добавить запись
     */
    public void addRecord() {
        diary.addRecordToDay(console.getDay(), console.getRecord(true));
    }

    /*
     * записи по запрошенному дню
     */
    public void getDayRecords() {
        int dayNum = console.getDay();
        Day day = diary.getDayRecords(dayNum);
        console.printDay(dayNum, day);
    }

    /*
     * поиск записи по событию
     */
    public void findRecord() {
        Record record = console.getRecord(false);
        String event = record.getEvent();
        String findedRecord = diary.findRecord(event);
        if (findedRecord.length() == 0) {
            findedRecord = "Событие " + event + " не найдено";
        } else {
            findedRecord = "Нашёл:\n" + findedRecord;
        }
        console.printRecord(findedRecord);
    }

    /*
     * удаление записи по событию
     */
    public void delRecord() {
        Record record = console.getRecord(false);
        String event = record.getEvent();
        String delRecord;
        int count = diary.delRecord(event);
        if (count == 0) {
            delRecord = "Событие " + event + " не найдено. Удалять нечего.";
        } else {
            delRecord = "Удалено " + count + " событий.";
        }
        console.printRecord(delRecord);
    }

    /*
     * сохранение Diary
     */
    public void saveDiary() {
        service.saveDiary(diary);
    }

    /*
     * чтение Diary
     */
    public Diary readDiary() {
        diary = service.readDiary();
        return diary;
    }
}