public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.createTask("Покупка продуктов", "Сходить в магазин");
        taskManager.createTask("Уборка дома", "Убраться в квартире");

        Epic epic1 = new Epic(1, "Подготовка к отпуску", "Собрать вещи");
        taskManager.createEpic("Подготовка к отпуску", "Собрать вещи");

        Subtask subtask1 = new Subtask(1, "Собрать чемодан", "Упаковать вещи", epic1);
        taskManager.createSubtask("Собрать чемодан", "Упаковать вещи", epic1);

        taskManager.printAllTasks();
        taskManager.printAllEpics();
        taskManager.printAllSubtasks();
    }
}
