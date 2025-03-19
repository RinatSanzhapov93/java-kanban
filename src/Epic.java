import java.util.ArrayList;
import java.util.List;

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
        boolean anyNew = false;

        for (Subtask subtask : subtasks) {
            switch (subtask.getStatus()) {
                case DONE:
                    break;
                case IN_PROGRESS:
                    anyInProgress = true;
                    break;
                case NEW:
                    anyNew = true;
                    break;
            }
        }

        if (allDone) {
            setStatus(TaskStatus.DONE);
        } else if (anyInProgress) {
            setStatus(TaskStatus.IN_PROGRESS);
        } else if (anyNew) {
            setStatus(TaskStatus.NEW);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", subtasks=" + subtasks.size();
    }
}
