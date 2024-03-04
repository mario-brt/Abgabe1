package edu.kit.informatik.command.player;

import edu.kit.informatik.ArtificialIntelligence;
import edu.kit.informatik.MemoryCell;
import edu.kit.informatik.command.CommandResult;
import edu.kit.informatik.command.CommandResultType;
import edu.kit.informatik.command.ai.AICommandsEnum;
import edu.kit.informatik.command.ai.AiCommand;

import java.util.ArrayList;
import java.util.List;

public class AddCommand implements CommandPlayer {


    private final CommandHandlerPlayer commandHandlerPlayer;

    AddCommand(CommandHandlerPlayer commandHandler) {
        this.commandHandlerPlayer = commandHandler;
    }

    /**
     * @param ignored          the memory to execute the command on
     * @param commandArguments the arguments of the command
     * @param gameState
     * @return
     */
    @Override
    public CommandResult execute(MemoryCell[] ignored, String[] commandArguments, GameState gameState) {
        /*if (commandArguments.length % 3 != 1) {
            return new CommandResult(CommandResultType.FAILURE, "your arguments are faulty");
        }*/
        List<ArtificialIntelligence> ais = commandHandlerPlayer.getAiList();
        if (!checkName(commandArguments[0])) {
            return new CommandResult(CommandResultType.FAILURE, "There is already another Ai with this name");
        }
        String name = commandArguments[0];
        String[] commandsSplitted = commandArguments[1].split(",");
        List<AICommandsEnum> singleCommands = new ArrayList<>();
        List<Integer> argsA = new ArrayList<>();
        List<Integer> argsB = new ArrayList<>();
        for (int i = 0; i < commandsSplitted.length; i+=3) {
            switch (commandsSplitted[i]) {
                case "STOP":
                    singleCommands.add(AICommandsEnum.STOP);
                    break;
                case "MOV_R":
                    singleCommands.add(AICommandsEnum.MOV_R);
                    break;
                case "MOV_I":
                    singleCommands.add(AICommandsEnum.MOV_I);
                    break;
                case "ADD":
                    singleCommands.add(AICommandsEnum.ADD);
                    break;
                case "ADD_R":
                    singleCommands.add(AICommandsEnum.ADD_R);
                    break;
                case "JMP":
                    singleCommands.add(AICommandsEnum.JMP);
                    break;
                case "JMZ":
                    singleCommands.add(AICommandsEnum.JMZ);
                    break;
                case "CMP":
                    singleCommands.add(AICommandsEnum.CMP);
                    break;
                case "SWAP":
                    singleCommands.add(AICommandsEnum.SWAP);
                    break;
                default:
                    return new CommandResult(CommandResultType.FAILURE, "AI command not found. Make sure you have no whitespaces in your name");
            }

            int argA;
            int argB;
            try {
                argA = Integer.parseInt(commandsSplitted[i + 1]);
                argsA.add(argA);
                argB = Integer.parseInt(commandsSplitted[i + 2]);
                argsB.add(argB);
            } catch (NumberFormatException e) {
                return new CommandResult(CommandResultType.FAILURE, "Arguments are not in range");
            }
        }

            AiCommand[] aiCommands = new AiCommand[commandsSplitted.length / 3];
            for (int i = 0; i < aiCommands.length; i++) {
                aiCommands[i] = new AiCommand(singleCommands.get(i), argsA.get(i), argsB.get(i));
            }

            ais.add(new ArtificialIntelligence(name, aiCommands));
            commandHandlerPlayer.setAiList(ais);
            return new CommandResult(CommandResultType.SUCCESS, name);
        }


        private boolean checkName(String name) {
            for (ArtificialIntelligence ai : commandHandlerPlayer.getAiArray()) {

                if(ai != null && ai.getName().equals(name)) {
                    return false;
                }
            }
            return true;
        }
        @Override
        public int getNumberOfArguments () {
            return 4;
        }
    }



