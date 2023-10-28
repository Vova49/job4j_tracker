package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Удалить заявку`";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Удаление заявки ===");
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки. Возможно, заявка с таким ID не существует.");
        }
        return true;
    }
}
