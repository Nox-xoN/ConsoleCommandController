package de.hsa.games.fatsquirrel.util.ui.consoletest;

import de.hsa.games.fatsquirrel.util.ui.Command;
import de.hsa.games.fatsquirrel.util.ui.CommandScanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class MyFavoriteCommandProcessor {

    private final PrintStream outputStream = new PrintStream(System.out);
    private final BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
    private final CommandScanner commandScanner = new CommandScanner(MyFavoriteCommandType.values(), inputReader);

    public static void main(String[] args) throws IOException {
        MyFavoriteCommandProcessor processor =  new MyFavoriteCommandProcessor();
        processor.process();
    }

    public void process() throws IOException {

        while (true) { // the loop over all commands with one input line for every command
            Command command = commandScanner.next();

            Object[] params = command.getParams();

            MyFavoriteCommandType commandType = (MyFavoriteCommandType) command.getCommandTypeInfo();

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

    private void echo(String param, int param1) {
    }

    private void addf(float param, float param1) {
    }

    private void addi(int param, int param1) {
    }

    private void help() {

    }



}
