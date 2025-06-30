public class TextFileFactory extends FileGenerator {
    @Override
    public FileController generateFile() {
        return new TextFile();
    }
}
