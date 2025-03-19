public class Subtask extends Task {
    private final Epic parentEpic;

    public Subtask(String title, String description, Epic parentEpic) {
        super(title, description);
        this.parentEpic = parentEpic;
        parentEpic.addSubtask(this);
    }

    @Override
    public String toString() {
        return super.toString() + ", parentEpicId=" + parentEpic.getId();
    }
}
