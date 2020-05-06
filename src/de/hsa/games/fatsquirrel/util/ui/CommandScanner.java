package de.hsa.games.fatsquirrel.util.ui;

import de.hsa.games.fatsquirrel.util.ui.consoletest.CommandType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CommandScanner {

    private CommandTypeInfo[] commandTypeInfos;
    private BufferedReader inputReader;
    private PrintStream printStream;

    public CommandScanner(CommandTypeInfo[] commandTypeInfos, BufferedReader inputReader) {
        this.commandTypeInfos = commandTypeInfos;
        this.inputReader = inputReader;
        this.printStream = printStream;
    }

    public Command next() throws IOException {
        String line = "";
        String[] str;
        Command command = null;

        try {
            line = inputReader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        str = line.split(" ");

        for (int i = 0; i < commandTypeInfos.length; i++) {
            if (str[0].equals(commandTypeInfos[i].getName())) {

                Class<?>[] paramsClass = commandTypeInfos[i].getParamTypes();
                Object[] params = new Object[paramsClass.length];

                if (paramsClass.length > 0) {
                    for (int j = 0; j < paramsClass.length; j++) {
                        Class<?> c = paramsClass[j];

                        if (c.equals(int.class)) {
                            params[j] = new Integer(str[j + 1]);
                        } else if (c.equals(float.class)) {
                            params[j] = new Float(str[j + 1]);
                        } else if (c.equals(String.class)) {
                            params[j] = new String(str[j + 1]);
                        } else if (c.equals(XY.class)) {
                            switch (commandTypeInfos[i].getName()) {
                                case "a":
                                    params[j] = XY.LEFT;
                                    break;
                                case "s":
                                    params[j] = XY.DOWN;
                                    break;
                                case "d":
                                    params[j] = XY.RIGHT;
                                    break;
                                case "w":
                                    params[j] = XY.UP;
                                    break;
                                case "":
                                    params[j] = XY.STAND_STILL;
                            }
                        }
                    }
                    command = new Command(commandTypeInfos[i], params);
                }
            }
        }
        return command;
    }
}
