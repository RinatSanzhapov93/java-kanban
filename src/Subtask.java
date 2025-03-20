public class Subtask extends Task {
    private final Epic epic;

    public Subtask(int id, String title, String description, Epic epic) {
        super(id, title, description);
        this.epic = epic;
    }

    public Epic getEpic() {
        return epic;
    }

    @Override
    public String toString() {
        return super.toString() + ", epic=" + epic.getTitle();
    }
}
