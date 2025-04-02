import java.util.List;

public interface TaskManager {
    int createTask(Task task);
    int createEpic(Epic epic);
    int createSubtask(Subtask subtask);

    Task getTask(int id);
    Epic getEpic(int id);
    Subtask getSubtask(int id);

    List<Task> getAllTasks();
    List<Epic> getAllEpics();
    List<Subtask> getAllSubtasks();
    List<Subtask> getSubtasksByEpicId(int epicId);

    void updateTask(Task task);
    void updateEpic(Epic epic);
    void updateSubtask(Subtask subtask);

    void deleteTaskById(int id);
    void deleteEpicById(int id);
    void deleteSubtaskById(int id);

    void deleteAllTasks();
    void deleteAllEpics();
    void deleteAllSubtasks();

    List<Task> getHistory();
}