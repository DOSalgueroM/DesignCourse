package org.example.pagination;

public interface ICommandExecute<T>{
    void execute(String command, IPagination<T> pagination);
}
