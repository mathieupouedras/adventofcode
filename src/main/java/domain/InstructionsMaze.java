package domain;

public class InstructionsMaze{

    private final Integer[] instructions;
    private int currentInstruction;

    public InstructionsMaze(Integer[] instructions) {
        this.instructions = instructions;
        this.currentInstruction = 0;
    }

    public int stepsToExit() {
        int steps = 0;
        while (currentInstruction >= 0 & currentInstruction < instructions.length) {
            jump();
            steps++;
        }
        return steps;
    }
    public void jump() {
        int move = instructions[currentInstruction];
        instructions[currentInstruction] = move + 1;
        currentInstruction = currentInstruction + move;
    }

    public void strangeJump() {
        int move = instructions[currentInstruction];
        if (move >= 3) {
            instructions[currentInstruction] = move - 1;
        }
        else {
            instructions[currentInstruction] = move + 1;
        }
        currentInstruction = currentInstruction + move;
    }


    public int stepsToExitStrangeJumps() {
        int steps = 0;
        while (currentInstruction >= 0 & currentInstruction < instructions.length) {
            strangeJump();
            steps++;
        }
        return steps;

    }
}
