package com.vimeworld.cakesplugin;
import com.vimeworld.cakesplugin.Command;
import com.vimeworld.cakesplugin.Commands.NotExisting;
import org.reflections.Reflections;

public class CommandFactory {
    private CommandFactory(){ }

    public static Command createCommand(String name) {
        Reflections reflections = new Reflections("com.vimeworld.cakesplugin.Commands");

        for (Class<?> clazz : reflections.getSubTypesOf(Command.class)) {
            if (clazz.getSimpleName().equalsIgnoreCase(name)) {
                try {
                    return (Command) clazz.newInstance();
                } catch (InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return new NotExisting();
    }
}
