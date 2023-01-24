package calendar.src.project.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Diary implements Serializable {

    private Map<Integer, Day> days;

    public Diary() {
        this.days = new HashMap<>();
    }

    /*
    добавить новую запись в день
     */
    public void addRecordToDay(int day, Record record) {
        if (!days.containsKey(day)) {
            days.put(day, new Day());
        }
        days.get(day).addRecord(record);
    }

    /*
    получить Day по номеру 
     */
    public Day getDayRecords(int findDay) {
        if (days.containsKey(findDay)) {
            return days.get(findDay);
        } else {
            return new Day();
        }
    }

    /*
    поиск всех записей с событиями
     */
    public String findRecord(String event) {
        StringBuilder findResult = new StringBuilder();
        for (Integer dayNum : days.keySet()) {
            Day day = days.get(dayNum);
            for (Record record : day.getRecords()) {
                if (record.getEvent().equalsIgnoreCase(event)) {
                    findResult.append("День ").append(dayNum.toString()).append(", время: ").append(record.getHour().toString()).append(", событие ").append(record.getEvent()).append("\n");
                }
            }
        }
        return findResult.toString();
    }

    /*
    удаление всех записей с событием
     */
    public int delRecord(String event) {
        int count = 0;
        Iterator<Integer> dayNumIterator = days.keySet().iterator();
        for (Iterator<Integer> it = dayNumIterator; it.hasNext(); ) {
            Integer dayNum = it.next();
            Day day = days.get(dayNum);

            Iterator<Record> dayIterator = day.getRecords().iterator();
            for (Iterator<Record> iter = dayIterator; iter.hasNext(); ) {
                Record record = iter.next();
                if (record.getEvent().equalsIgnoreCase(event)) {
                    count++;
                    if (day.getRecords().size() == 0) {
                        dayNumIterator.remove();
                    }
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder daysRecords = new StringBuilder();
        daysRecords.append("Найдено дней с записями: ").append(this.days.size()).append(":\n");
        for (Integer day : days.keySet()) {
            daysRecords.append("\tДень ").append(day.toString()).append(".").append(days.get(day).toString());
        }
        return daysRecords.toString();
    }
}