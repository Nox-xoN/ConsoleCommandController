package de.hsa.games.fatsquirrel.util.ui;

import de.hsa.games.fatsquirrel.util.ui.consoletest.CommandType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CommandScanner implements CommandTypeInfo {

    private CommandTypeInfo[] commandTypeInfos;
    private BufferedReader inputReader;
    private PrintStream printStream;

    public CommandScanner(CommandTypeInfo[] commandTypeInfos, BufferedReader inputReader) {
        this.commandTypeInfos = commandTypeInfos;
        this.inputReader = inputReader;
        this.printStream = printStream;
    }

    public Command next() throws IOException {

        CommandTypeInfo commandTypeInfo;


        String string = inputReader.readLine();
        String[] splitString = string.split(" ");

        CommandType type = CommandType.valueOf(splitString[0].toUpperCase());

        if (type.getName() == splitString[0])
            return null;

        if (type.getParamTypes() != null)
        {
            Object[] params = new Object[type.getParamTypes().length];

            if(type.getParamTypes()[0] instanceof Float)
            {
                params[0] = Float.parseFloat(splitString[1]);
                params[1] = Float.parseFloat(splitString[2]);
            }
            else
            {
                params[0] = Integer.parseInt(splitString[1]);
                params[1] = Integer.parseInt(splitString[2]);
            }
        }
        else
            params = null;

        return new Command(type, params);
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
}
