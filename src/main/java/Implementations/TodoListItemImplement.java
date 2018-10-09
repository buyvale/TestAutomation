package Implementations;

import Interfaces.Togglable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodoListItemImplement implements Togglable {

    private String title;
    private boolean toggled;
    private LocalDateTime dueDate;

    public String getToDoItemDescription() {
        return toDoItemDescription;
    }

    public void setToDoItemDescription(String toDoItemDescription) {
        if (toDoItemDescription.length() <= 150) {
            this.toDoItemDescription = toDoItemDescription;
        } else {
            IllegalArgumentException e = new IllegalArgumentException("Description should be less than 150 symbols");
            throw e;
        }
    }

    private String toDoItemDescription;

    public String getTitle() {
        return title;
    }

    public TodoListItemImplement setTitle(String title) {
        if (isWrongArguments(title)) {
            throwExceptionIfArgumentsIsWrong();
        } else
            this.title = title;
        return this;
    }

    public TodoListItemImplement() {
    }

    public TodoListItemImplement(String title) {

        if (isWrongArguments(title)) {
            throwExceptionIfArgumentsIsWrong();
        } else {
            this.title = title;
            toggled = false;
            dueDate = dueDate.now();

        }
    }

    public void toggle() {
        toggled = !toggled;
    }

    public boolean isToggled() {
        return toggled;
    }

    public boolean isWrongArguments(String title) {
        return (title == "" || title == null);
    }

    public void throwExceptionIfArgumentsIsWrong() {
        IllegalArgumentException e = new IllegalArgumentException();

        throw e;
    }

    public String toDoListItemDateFormatter(String localDateTime) {
        localDateTime = dueDate.format(DateTimeFormatter.ofPattern("hh:mm dd:mm:yyyy"));
        return localDateTime;
    }

    public void addItem(TodoListItemImplement todo) {

    }
}
