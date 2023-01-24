package calendar.src.project.file;

import java.io.*;

public class FileHandler implements Writable, Serializable {

    private String filename;

    public FileHandler() {
        this.filename = "calendar.dat";
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }


    @Override
    public void save(Serializable serializable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.printf("Сохранено в %s\n", filename);
            oos.writeObject(serializable);
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return ois.readObject();
        } catch (Exception ex) {
            System.out.println("Ошибка!");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}