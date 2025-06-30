public class SpreadsheetFactory extends FileGenerator {
    @Override
    public FileController generateFile() {
        return new SpreadsheetFile();
    }
}
