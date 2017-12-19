package adventofcode.day18;

public class InstructionFactory {

    Instruction create(String input) {
        String[] split = input.split(" ");
        if (split[0].equals("snd")) return new PlaySound(split[1]);
        Instruction instruction;
        return null;
    }
}
