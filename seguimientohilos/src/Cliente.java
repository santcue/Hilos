public class Cliente implements Runnable {
    private int id;

    public Cliente(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            System.out.println("El cliente " + id + " está siendo atendido.");
            Thread.sleep(5000);
            System.out.println("El cliente " + id + " ha sido atendido.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
