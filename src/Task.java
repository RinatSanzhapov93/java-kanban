public class Task {
    private static int idCounter = 1;
    private final int id;
    private final String title;
    private final String description;
    private TaskStatus status;

    public enum TaskStatus {
        NEW,
        IN_PROGRESS,
        DONE
    }

    public Task(String title, String description) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{id=" + id + ", title='" + title + "', status=" + status + "}";
    }
}
