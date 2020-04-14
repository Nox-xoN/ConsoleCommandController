import java.io.BufferedReader;
import java.io.PrintStream;

public class CommandScanner {

    private CommandTypeInfo[] commandTypeInfos;
    private BufferedReader inputReader;

    public CommandScanner(CommandTypeInfo[] commandTypeInfos, BufferedReader inputReader, PrintStream printStream) {
        this.commandTypeInfos = commandTypeInfos;
        this.inputReader = inputReader;
        this.printStream = printStream;
    }

    private PrintStream printStream;

    public Command next()
    {

    }





}
