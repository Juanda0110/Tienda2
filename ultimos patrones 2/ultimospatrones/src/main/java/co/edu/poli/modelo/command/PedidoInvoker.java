package co.edu.poli.modelo.command;

import java.util.ArrayList;
import java.util.List;

public class PedidoInvoker {
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        commandList.add(command);
    }

    public void run() {
        for (Command command : commandList) {
            command.execute();
        }
        commandList.clear();
    }
}

