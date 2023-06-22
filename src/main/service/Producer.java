package main.service;

import main.commands.ICommand;

public class Producer implements Runnable {
    private CommandBuffer buffer;
    private ICommand[] commands;
    public Producer(CommandBuffer buffer, ICommand[] commands) {
        this.buffer = buffer;
        this.commands = commands;
    }

    public void start() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for(ICommand c : commands) {
            this.buffer.add(c);
        }
    }
}
