package domain;

import java.util.ArrayList;
import java.util.List;

class PipeFactory {

    private static final String PIPE_SYMBOL = " <-> ";
    private static final String PROGRAM_ID_SEPARATOR = ", ";

    static List<Pipe> create(String text) {

        List<Pipe> pipes = new ArrayList<>();

        String[] tokens = text.split(PIPE_SYMBOL);
        int firstProgramId = Integer.parseInt(tokens[0]);

        String[] subtokens = tokens[1].split(PROGRAM_ID_SEPARATOR);

        for(String program : subtokens) {
            pipes.add(new Pipe(firstProgramId, Integer.valueOf(program)));
        }

        return pipes;
    }
}
