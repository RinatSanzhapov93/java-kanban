public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("Покупка продуктов", "Сходить в магазин");
        Task task2 = new Task("Уборка дома", "Убраться на кухне");

        Epic epic1 = new Epic("Подготовка к отпуску", "Покупка авиабилетов");
        Subtask subtask1 = new Subtask("Купить билеты", "Зайти на aviasales", epic1.getId());

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createEpic(epic1);
        taskManager.createSubtask(subtask1);

        taskManager.printAllTasks();
        taskManager.printAllEpics();
        taskManager.printAllSubtasks();

        System.out.println("Все подзадачи эпика 1:");
        for (Subtask subtask : taskManager.getSubtasksByEpicId(1)) {
            System.out.println(subtask);
        }

        taskManager.deleteAllTasks();
        taskManager.deleteAllEpics();
        taskManager.deleteAllSubtasks();
    }
}