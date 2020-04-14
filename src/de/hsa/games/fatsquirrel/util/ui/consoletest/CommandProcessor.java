package de.hsa.games.fatsquirrel.util.ui.consoletest;

import de.hsa.games.fatsquirrel.util.ui.Command;
import de.hsa.games.fatsquirrel.util.ui.CommandScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class CommandProcessor {

    private final PrintStream outputStream = new PrintStream(System.out);
    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private final CommandScanner commandScanner = new CommandScanner(CommandType.values(), inputReader);

    public static void main(String[] args) throws IOException {
        CommandProcessor processor = new CommandProcessor();
        processor.process();
    }

    public void process() throws IOException {

        while (true) { // the loop over all commands with one input line for every command
            Command command = commandScanner.next();

            Object[] params = command.getParams();

            CommandType commandType = (CommandType) command.getCommandTypeInfo();

            switch (commandType) {
                case EXIT:
                    System.exit(0);
                case HELP:
                    help();
                    break;
                case ADDI:
                    addi((int) params[0], (int) params[1]);
                    break;
                case ADDF:
                    addf((float) params[0], (float) params[1]);
                    break;
                case ECHO:
                    echo((String) params[0], (int) params[1]);
                    break;
            }
        }
    }

    private void echo(String str, int amount) {
        for (int i = 0; i < amount; i++) {
            outputStream.println(str);
        }
    }

    private void addf(float f0, float f1) {
        outputStream.println(f0 + " + " + f1 + " = " + (f0 + f1));
    }

    private void addi(int i0, int i1) {
        outputStream.println(i0 + " + " + i1 + " = " + (i0 + i1));
    }

    private void help() {
        for (CommandType cT: CommandType.values()) {
            outputStream.println(cT.getName() + " | " + cT.getHelpText());
        }

    }


}
