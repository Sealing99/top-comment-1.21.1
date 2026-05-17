package net.sealing99.topcomment.util;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DelayedEventManager {
    private static record Task(int[] ticksLeft, Consumer<MinecraftServer> action) {}
    private static final List<Task> TASKS = new ArrayList<>();


    public static void init() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            for (int i = TASKS.size() - 1; i >= 0; i--) {
                Task task = TASKS.get(i);
                task.ticksLeft[0]--;
                if (task.ticksLeft[0] <= 0) {
                    task.action.accept(server);
                    TASKS.remove(i);
                }
            }
        });
    }

    public static void schedule(int delayTicks, Consumer<MinecraftServer> action) {
        TASKS.add(new Task(new int[]{delayTicks}, action));
    }

    private static class DelayedTask {
        private int ticksRemaining;
        private final Runnable action;


        public DelayedTask(int ticksRemaining, Runnable action) {
            this.ticksRemaining = ticksRemaining;
            this.action = action;
        }

        public boolean tick() {
            ticksRemaining--;
            return ticksRemaining <= 0;
        }
    }
}
