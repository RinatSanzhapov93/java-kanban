public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("Покупка продуктов", "Сходить в магазин");
        Task task2 = new Task("Уборка дома", "Убраться в квартире");

        Epic epic1 = new Epic("Подготовка к отпуску", "Собрать вещи");
        Epic epic2 = new Epic("Чекап здоровья", "Посетить врачей");

        Subtask subtask1 = new Subtask("Собрать чемодан", "Упаковать вещи", epic1);
        Subtask subtask2 = new Subtask("Купить билеты", "Зайти на Aviasales", epic1);

        Subtask subtask3 = new Subtask("Провериться у окулиста", "Проверить зрение", epic2);

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createEpic(epic1);
        taskManager.createEpic(epic2);
        taskManager.createSubtask(subtask1);
        taskManager.createSubtask(subtask2);
        taskManager.createSubtask(subtask3);

        System.out.println("Задачи:");
        taskManager.printAllTasks();

        System.out.println("\nЭпики:");
        taskManager.printAllEpics();

        System.out.println("\nПодзадачи:");
        taskManager.printAllSubtasks();

        task1.setStatus(Task.TaskStatus.IN_PROGRESS);
        task2.setStatus(Task.TaskStatus.DONE);
        subtask1.setStatus(Task.TaskStatus.NEW);
        subtask2.setStatus(Task.TaskStatus.IN_PROGRESS);
        subtask3.setStatus(Task.TaskStatus.DONE);

        System.out.println("\nОбновленные статусы:");

        System.out.println("Задачи:");
        taskManager.printAllTasks();

        System.out.println("\nПодзадачи:");
        taskManager.printAllSubtasks();

        epic1.updateStatus();
        epic2.updateStatus();

        System.out.println("\nСтатусы эпиков:");
        taskManager.printAllEpics();

        taskManager.deleteTask(1);
        taskManager.deleteEpic(2);

        System.out.println("\nПосле удаления:");
        System.out.println("Задачи:");
        taskManager.printAllTasks();

        System.out.println("\nЭпики:");
        taskManager.printAllEpics();
    }
}
