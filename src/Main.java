import manager.TaskManager;
import storage.FileStorage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        FileStorage fileStorage = new FileStorage("tasks.txt");
        TaskManager taskManager = new TaskManager(fileStorage);
        while (true){
            System.out.println("1.Добавить задачу\n2.Покаказть все задачи\n3.Отметить задачу выполненной\n4.Удалить задачу\n5.Выход");
            System.out.print("Выберите пункт: ");
            try {
            int choice = scanner.nextInt();
                scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Введите название задачи: ");
                    taskManager.add(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Ваши задачи: ");
                    taskManager.list();
                    break;
                case 3:
                    taskManager.list();
                    System.out.println("Какую задачу выполнили?");
                    taskManager.markDone(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 4:
                    taskManager.list();
                    System.out.println("Какую задачу хотите удалить?");
                    taskManager.remove(scanner.nextInt());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("До свидания!");
                    return;
                default:
                    System.out.println("Неверный пункт. Попробуйте снова.");
                    break;
            }
            }catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число!");
                scanner.nextLine();
            }
        }
    }
}