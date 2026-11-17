package storage;

import model.Task;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private String filename;

    public FileStorage(String filename) {
        this.filename = filename;
    }
    public void save(List<Task> tasks){
        File file = new File(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(Task task: tasks){
                writer.write(task.getId()+ "|" +task.getTitle()+"|"+task.isDone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        } ;
    }
    public List<Task> load(){
        File file = new File(filename);
        if(!file.exists()){
            return new ArrayList<>();
        }
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line =reader.readLine()) != null){
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                boolean done = Boolean.parseBoolean(parts[2]);
                tasks.add(new Task(id,title,done));
            }
            int maxId = 0;
            for(Task task : tasks){
                if(task.getId() > maxId){
                    maxId = task.getId();
                }
            }
            Task.setNextId(maxId+1);
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
        return tasks;
    }
}
