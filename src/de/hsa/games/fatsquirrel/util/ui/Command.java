package de.hsa.games.fatsquirrel.util.ui;

public class Command implements CommandTypeInfo{

    private final CommandTypeInfo commandTypeInfo;
    private final Object[] params;

    public Command(CommandTypeInfo commandTypeInfo, Object[] params) {
        this.commandTypeInfo = commandTypeInfo;
        this.params = params;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getHelpText() {
        return null;
    }

    @Override
    public Class<?>[] getParamTypes() {
        return null;
    }

    public Object[] getParams() {
        return params;
    }

    public CommandTypeInfo getCommandTypeInfo()
    {
        return commandTypeInfo;
    }
}
