package de.hsa.games.fatsquirrel.util.ui;

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

        String readLine = inputReader.readLine();


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
