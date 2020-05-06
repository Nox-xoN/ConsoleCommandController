package de.hsa.games.fatsquirrel.util.ui.consoletest;
import de.hsa.games.fatsquirrel.util.ui.CommandTypeInfo;

public enum CommandType implements CommandTypeInfo {

    HELP("help", "  * list all commands"),
    EXIT("exit", "  * exit program"),
    ADDI("addi", "<param1>  <param2>   * simple integer add ", int.class, int.class),
    ADDF("addf", "<param1>  <param2>   * simple float add ", float.class, float.class),
    ECHO("echo", "<param1>  <param2>   * echos param1 string param2 times ", String.class, int.class);

    private final String commandName;
    private final String helpText;
    private Class[] params;

    CommandType(String commandName, String helpText, Class... params) {
        this.commandName = commandName;
        this.helpText = helpText;
        this.params = params;
    }

    CommandType(String commandName, String helpText) {
        this.commandName = commandName;
        this.helpText = helpText;
    }

    @Override
    public String getName() {
        return commandName;
    }

    @Override
    public String getHelpText() {
        return helpText;
    }

    @Override
    public Class<?>[] getParamTypes() {
        return params;
    }
}
