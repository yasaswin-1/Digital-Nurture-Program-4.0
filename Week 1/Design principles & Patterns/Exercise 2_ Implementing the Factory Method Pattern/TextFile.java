public class TextFile implements FileController {
    @Override
    public void start() {
        System.out.println("Launching Text File...");
    }

    @Override
    public void stop() {
        System.out.println("Terminating Text File...");
    }
}
