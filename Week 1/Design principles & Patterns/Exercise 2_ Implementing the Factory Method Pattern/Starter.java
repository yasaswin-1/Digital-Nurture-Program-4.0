public class Starter {
    public static void main(String[] args) {
        // Create a Text File using Factory
        FileGenerator txtFactory = new TextFileFactory();
        FileController txtFile = txtFactory.generateFile();
        txtFile.start();
        txtFile.stop();

        // Create a PDF File using Factory
        FileGenerator pdfMaker = new PDFFileGenerator();
        FileController pdfFile = pdfMaker.generateFile();
        pdfFile.start();
        pdfFile.stop();

        // Create a Spreadsheet File using Factory
        FileGenerator sheetFactory = new SpreadsheetFactory();
        FileController sheetFile = sheetFactory.generateFile();
        sheetFile.start();
        sheetFile.stop();
    }
}
