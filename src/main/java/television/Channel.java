package television;

public class Channel {
    private String name;
    private int channelNumber;
    private Program program;

    public Channel(String name, int channelNumber, Program program) {
        this.name = name;
        this.channelNumber = channelNumber;
        this.program = program;
    }

    public Channel() {
    }

    public String getName() {
        return name;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public Program getProgram() {
        return program;
    }

    @Override
    public String toString() {
        return "Канал " + name + " (№" + channelNumber + ")";
    }
}
