import java.util.LinkedList;
import java.util.Queue;

public class Banco {
    private Queue<Cliente> filaPreferencial = new LinkedList<>();
    private Queue<Cliente> filaPrioritaria = new LinkedList();

    public synchronized void atenderClientePreferencial(Cliente cliente) {
        filaPreferencial.offer(cliente);
        notify();
    }

    public synchronized void atenderClientePrioritario(Cliente cliente) {
        filaPrioritaria.offer(cliente);
        notify();
    }

    public synchronized Cliente siguienteClientePreferencial() {
        while (filaPreferencial.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return filaPreferencial.poll();
    }

    public synchronized Cliente siguienteClientePrioritario() {
        while (filaPrioritaria.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return filaPrioritaria.poll();
    }
}
