package models;

public class EBook extends Book {
    private FileType  fileType;

    public EBook(String ISBN, String title, int publishYear, double price , FileType  fileType , boolean isDemo) {
        super(ISBN, title, publishYear, price , isDemo);
        this.fileType = fileType;
    }

    public FileType  getFileType() {
        return fileType;
    }

    @Override
    public boolean isShippable() {
        return false;
    }

}
