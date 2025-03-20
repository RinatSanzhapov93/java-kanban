import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private int idCounter = 1;
    private final Map<Integer, Task> tasks;
    private final Map<Integer, Epic> epics;
    private final Map<Integer, Subtask> subtasks;

    public TaskManager() {
        tasks = new HashMap<>();
        epics = new HashMap<>();
        subtasks = new HashMap<>();
    }

    public void createTask(String title, String description) {
        Task task = new Task(idCounter++, title, description);
        tasks.put(task.getId(), task);
    }

    public void createEpic(String title, String description) {
        Epic epic = new Epic(idCounter++, title, description);
        epics.put(epic.getId(), epic);
    }

    public void createSubtask(String title, String description, Epic epic) {
        Subtask subtask = new Subtask(idCounter++, title, description, epic);
        subtasks.put(subtask.getId(), subtask);
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public Epic getEpicById(int id) {
        return epics.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public void printAllTasks() {
        for (Task task : tasks.values()) {
            System.out.println(task);
        }
    }

    public void printAllEpics() {
        for (Epic epic : epics.values()) {
            System.out.println(epic);
        }
    }

    public void printAllSubtasks() {
        for (Subtask subtask : subtasks.values()) {
            System.out.println(subtask);
        }
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public void deleteAllEpics() {
        epics.clear();
    }

    public void deleteAllSubtasks() {
        subtasks.clear();
    }

    public void updateTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
    }
}
