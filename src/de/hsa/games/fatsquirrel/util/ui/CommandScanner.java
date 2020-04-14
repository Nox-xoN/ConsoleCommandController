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

        Object[] params;
        CommandTypeInfo commandTypeInfo;

        String string = inputReader.readLine();
        String[] splitString = string.split(" ");

        CommandType type = CommandType.valueOf(splitString[0].toUpperCase());

        if (type.getName() == splitString[0])
            return null;

        if (type.getParamTypes() != null)
        {
            params = new Object[type.getParamTypes().length];

            for (int i = 0; i < params.length; i++) {

                if(type.getParamTypes()[i].getCanonicalName() == "float")
                {
                    params[i] = Float.parseFloat(splitString[i+1]);
                }
                else if(type.getParamTypes()[i].getCanonicalName() == "java.lang.String")
                {
                    params[i] = splitString[i+1];
                }
                else if(type.getParamTypes()[i].getCanonicalName() == "int")
                {
                    params[i] = Integer.parseInt(splitString[i+1]);
                }
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
