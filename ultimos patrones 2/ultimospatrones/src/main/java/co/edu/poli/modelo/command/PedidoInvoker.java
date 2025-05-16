package co.edu.poli.modelo.command;

public class PedidoInvoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void execute() {
        if (command != null) {
            command.execute();
        } else {
            throw new IllegalStateException("No se ha configurado un comando.");
        }
    }
}

