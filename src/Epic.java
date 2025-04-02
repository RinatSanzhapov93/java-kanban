import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Epic extends Task {
    private final List<Subtask> subtasks;

    public Epic(String title, String description) {
        super(title, description);
        this.subtasks = new ArrayList<>();
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
        updateStatus();
    }

    public void removeSubtask(Subtask subtask) {
        subtasks.remove(subtask);
        updateStatus();
    }

    public void updateStatus() {
        if (subtasks.isEmpty()) {
            setStatus(TaskStatus.NEW);
            return;
        }

        boolean allDone = true;
        boolean anyInProgress = false;

        for (Subtask subtask : subtasks) {
            if (subtask.getStatus() != TaskStatus.DONE) {
                allDone = false;
            }
            if (subtask.getStatus() == TaskStatus.IN_PROGRESS) {
                anyInProgress = true;
            }
        }

        if (allDone) {
            setStatus(TaskStatus.DONE);
        } else if (anyInProgress) {
            setStatus(TaskStatus.IN_PROGRESS);
        } else {
            setStatus(TaskStatus.NEW);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Epic epic = (Epic) o;
        return Objects.equals(subtasks, epic.subtasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subtasks);
    }

    @Override
    public String toString() {
        return "Epic{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                ", subtasksCount=" + subtasks.size() +
                '}';
    }
}