package threads;

import files.FileEntity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileThreadController implements Runnable {
    private final String FILE_PATH = "C:\\Users\\ilmln\\IdeaProjects\\Synchronized\\src\\main\\java\\files";
    private String fileName;
    private FileEntity fileEntity;
    private Thread thread;
    private File file;

    public FileThreadController(String fileName) {
        thread = new Thread(this);
        this.fileName = fileName;
        file = new File(FILE_PATH + File.separator + fileName);
        fileEntity = new FileEntity();
        thread.start();
    }

    private synchronized void calculate(double num) {
        System.out.println(Thread.currentThread().getName() + " is executing...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fileEntity.executeSum(num);
        System.out.println(Thread.currentThread().getName() + " ends the execution.");
        System.out.println("Current total: " + String.format("%.2f", fileEntity.getTotal()));
    }

    @Override
    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.file))) {
            while (bufferedReader.read() != -1) {
                calculate(Double.parseDouble(bufferedReader.readLine()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("End total: " + fileEntity.getTotal());
        }
    }
}
