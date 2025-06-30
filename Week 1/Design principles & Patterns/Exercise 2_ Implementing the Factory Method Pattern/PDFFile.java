public class PDFFile implements FileController {
    @Override
    public void start() {
        System.out.println("Launching PDF File...");
    }

    @Override
    public void stop() {
        System.out.println("Terminating PDF File...");
    }
}
