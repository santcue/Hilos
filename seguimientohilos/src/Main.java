public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        for (int i = 1; i <= 5; i++) {
            Cliente cliente;
            if (i <= 3) {
                cliente = new Cliente(i);
                banco.atenderClientePreferencial(cliente);
            } else {
                cliente = new Cliente(i);
                banco.atenderClientePrioritario(cliente);
            }
        }

        System.out.println("Fila Preferencial:");
        for (int i = 1; i <= 3; i++) {
            Cliente cliente = banco.siguienteClientePreferencial();
            new Thread(() -> cliente.run()).start();
        }

        System.out.println("\nFila Prioritaria:");
        for (int i = 1; i <= 2; i++) {
            Cliente cliente = banco.siguienteClientePrioritario();
            new Thread(() -> cliente.run()).start();
        }
    }
}
