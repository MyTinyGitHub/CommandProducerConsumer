package main.service;

import main.commands.*;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CommandBuffer {
    BlockingQueue<ICommand> commands;
    private final Integer CAPACITY = 1;

    public CommandBuffer() {
        commands = new ArrayBlockingQueue<>(1);
    }

    public void add(ICommand command) {
        try {
            this.commands.put(command);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ICommand take() {
        try {
            return this.commands.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
