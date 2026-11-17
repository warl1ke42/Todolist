package manager;

import model.Task;
import storage.FileStorage;

import java.util.List;

public class TaskManager {
    private List<Task> tasks;
    private FileStorage storage;

    public TaskManager(FileStorage storage) {
        this.storage = storage;
        this.tasks = storage.load();
    }
    public void add(String title){
        int id = Task.getNextId();
        Task task = new Task(id,title,false);
        Task.setNextId(id+1);
        tasks.add(task);
        storage.save(tasks);
    }
    public void list(){
        if(tasks.isEmpty()){
            System.out.println("Список задач пуст");
            return;
        }
        for(int i =0; i <tasks.size(); i++){
            System.out.println((i+1)+". "+tasks.get(i));
        }
    }
    public void markDone(int number) {
        if (number < 1 || number > tasks.size()){
            System.out.println("Неверный номер");
            return;
        }
        Task task = tasks.get(number-1);
        if (task.isDone()){
            System.out.println("Задача уже выполнена");
            return;
        }
        task.setDone(true);
        storage.save(tasks);
        System.out.println("Задача \"" + task.getTitle() + "\" отмечена выполненной!");
    }
    public void remove(int number){
        if ( number < 1 || number > tasks.size()){
            System.out.println("Неверный номер");
            return;
        }
        tasks.remove(number - 1);
        storage.save(tasks);
        System.out.println("Задача удалена");
    }
}
