package calendar.src.project.file;

import calendar.src.project.model.Diary;

public class Service {

    private final Writable writable;

    public Service(Writable writable) {
        this.writable = writable;
    }

    /*
    сохранить Diary
     */
    public void saveDiary(Diary diary) {
        writable.save(diary);
    }

    /*
    открыть Diary
     */
    public Diary readDiary() {
        if (writable != null) {
            if (writable.read() == null) {
                System.out.println("Diary отсутвует! Генерация нового Diary.");
                return new Diary();
            } else {
                System.out.println("Diary загружен из файла.");
                return (Diary) writable.read();
            }
        } else {
            System.out.println("Ошибка! Файл не загружен!");
            return null;
        }
    }
}