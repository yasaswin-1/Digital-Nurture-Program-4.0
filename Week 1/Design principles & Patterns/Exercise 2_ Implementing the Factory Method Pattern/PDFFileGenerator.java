public class PDFFileGenerator extends FileGenerator {
    @Override
    public FileController generateFile() {
        return new PDFFile();
    }
}
