package com.epam.pihnastyi.task4.command;

/**
 * Class created to do necessary command and set it
 */
public class CommandController {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.doCommand();
    }
}
