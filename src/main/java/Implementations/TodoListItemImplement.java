package Implementations;

import Interfaces.Togglable;

public class TodoListItemImplement implements Togglable {

    private String title;
    private boolean toggled;

    public String getTitle()
    {
        return title;
    }

    public TodoListItemImplement setTitle(String title) {
        if (isWrongArguments(title)) {
            throwExceptionIfArgumentsIsWrong();
        } else
            this.title = title;
        return this;
    }

    public TodoListItemImplement(String title) {

        if (isWrongArguments(title)) {
            throwExceptionIfArgumentsIsWrong();
        } else {
            this.title = title;
            toggled = false;
        }
    }

    public void toggle()
    {
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

}
