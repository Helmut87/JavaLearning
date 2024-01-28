import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileDataManager {
    private final Path filePath;

    public FileDataManager(String fileName) {
        this.filePath = Paths.get(fileName);
    }

    public List<String> readAllLines() throws IOException {
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }
        return Files.readAllLines(filePath);
    }

    public void writeAllLines(List<String> lines) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public void appendLine(String line) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            writer.write(line);
            writer.newLine();
        }
    }

    public void clearFile() throws IOException {
        writeAllLines(new ArrayList<>());
    }
}
