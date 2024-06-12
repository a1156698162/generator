package com.ssp.cli;

import com.ssp.cli.command.ConfigCommand;
import com.ssp.cli.command.GenerateCommand;
import com.ssp.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或输入 --help 查看命令提示");
    }

    public Integer doExecutor(String[] args) {
        return commandLine.execute(args);
    }
}
