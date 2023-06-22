package main.service;

public class Consumer implements Runnable {
    private CommandBuffer buffer;

    public Consumer(CommandBuffer buffer) {
        this.buffer = buffer;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(true) {
            buffer.take().execute();
        }
    }
}
