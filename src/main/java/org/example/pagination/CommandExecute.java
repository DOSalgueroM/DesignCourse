package org.example.pagination;

import java.util.HashMap;

public class CommandExecute<T> implements ICommandExecute<T>{
    @Override
    public void execute(String command, IPagination<T> pagination) {
        HashMap<String,ICommand> commands = new HashMap<String,ICommand>();
    }
}
