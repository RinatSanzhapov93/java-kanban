import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private static final int MAX_HISTORY_SIZE = 10;
    private final LinkedList<Task> history = new LinkedList<>();

    @Override
    public void add(Task task) {
        if (task == null) {
            return;
        }

        Iterator<Task> iterator = history.iterator();
        while (iterator.hasNext()) {
            Task existingTask = iterator.next();
            if (existingTask.equals(task)) {
                iterator.remove();
                break;
            }
        }
        history.addLast(task);

        if (history.size() > MAX_HISTORY_SIZE) {
            history.removeFirst();
        }
    }

    @Override
    public void remove(int id) {
        Iterator<Task> iterator = history.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if (task.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>(history);
    }
}