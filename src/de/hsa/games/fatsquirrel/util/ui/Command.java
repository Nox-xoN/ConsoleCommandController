package de.hsa.games.fatsquirrel.util.ui;

public class Command {

    private final CommandTypeInfo commandTypeInfo;
    private final Object[] params;

    public Command(CommandTypeInfo commandTypeInfo, Object[] params) {
        this.commandTypeInfo = commandTypeInfo;
        this.params = params;
    }


    public Object[] getParams() {
        return params;
    }

    public CommandTypeInfo getCommandTypeInfo()
    {
        return commandTypeInfo;
    }
}
