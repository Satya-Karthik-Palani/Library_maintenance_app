import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

interface Operationable<T> {
    public void InsertFromCSV();

    public void updateCSV();

    public void updateobject(String args[]);

    public void deleteCSV();

    public void printobjects();

    public void searchobjects(String args[]);
}

class BookOperations implements Operationable<Book> {

    @Override
    public void InsertFromCSV() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\karth\\Desktop\\MiniProject\\src\\Books.csv"));
            String studLine;
            while ((studLine = reader.readLine()) != null) {
                BookDAO.createBook(new Book(studLine));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateCSV() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\karth\\Desktop\\MiniProject\\src\\Books.csv"));
            String studLine;
            while ((studLine = reader.readLine()) != null) {
                BookDAO.updateBook(studLine);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCSV() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\karth\\Desktop\\MiniProject\\src\\Books.csv"));
            String studLine;
            while ((studLine = reader.readLine()) != null) {
                BookDAO.deleteBook(studLine);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void printobjects() {
        List<Book> books = BookDAO.getAllBooks();
        books.forEach(System.out::println);
    }

    @Override
    public void searchobjects(String args[]) {
        BookDAO.searchBook(args[2], args[3]);

    }

    @Override
    public void updateobject(String args[]) {
        String str = args[2];
        try {
            int id = Integer.parseInt(args[4]);
            BookDAO.updateBook(id, str, args[3]);
        } catch (NumberFormatException e) {
            System.exit(1);
        }
    }

}

class MagazineOperations implements Operationable<Magazine> {

    @Override
    public void InsertFromCSV() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\karth\\Desktop\\MiniProject\\src\\Books.csv"));
            String studLine;
            while ((studLine = reader.readLine()) != null) {
                MagazineDAO.createMagazine(new Magazine(studLine));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCSV() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\karth\\Desktop\\MiniProject\\src\\Books.csv"));
            String studLine;
            while ((studLine = reader.readLine()) != null) {
                MagazineDAO.updateMagazine(studLine);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateobject(String[] args) {
        String str = args[2];
        try {
            int id = Integer.parseInt(args[4]);
            MagazineDAO.updateMagazine(id, str, args[3]);
        } catch (NumberFormatException e) {
            System.exit(1);
        }
    }

    @Override
    public void deleteCSV() {
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader("C:\\Users\\karth\\Desktop\\MiniProject\\src\\Books.csv"));
            String studLine;
            while ((studLine = reader.readLine()) != null) {
                MagazineDAO.deleteMagazine(studLine);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printobjects() {
        List<Magazine> Magazines = MagazineDAO.getAllMagazines();
        Magazines.forEach(System.out::println);
    }

    @Override
    public void searchobjects(String[] args) {
        MagazineDAO.searchMagazine(args[2], args[3]);
    }

}

abstract class help {
    public abstract void printHelp();
}

public class LibraryMaintenenceApp extends help {
    @Override
    public void printHelp() {
        System.out.println("Help for commands:");
        System.out.println(
                "The first argument should be -books if you want to know about book and -magazines if you want to know about magazine");
        System.out.println("-insertCSV = for inserting data into database from this csv file");
        System.out.println("-updateCSV = for updating data in database from this csv file");
        System.out.println("-deleteCSV = for deleting data in database from this csv file");
        System.out.println("-printobjects = for Printing all books in database ");
        System.out.println("-updateobject <Field to be updated> <value to be set> <where id is>");
        System.out.println("-searchobject <field> <value of that field> = for searching the required book");
        System.out.println("-h (or any) for help menu");
    }

    public static void main(String args[]) {
        help h = new LibraryMaintenenceApp();
        if (args[0].equals("-books")) {
            BookOperations b1 = new BookOperations();
            switch (args[1]) {
                case "-insertCSV":
                    b1.InsertFromCSV();// Creation of books from CSV
                    break;
                case "-updateCSV":
                    b1.updateCSV();
                    break;
                case "-deleteCSV":
                    b1.deleteCSV();
                    break;
                case "-printobjects":
                    b1.printobjects();// Printing all books in the libarary
                    break;
                case "-updateobject":
                    b1.updateobject(args);// Update the data of book
                    break;
                case "-searchobject":
                    b1.searchobjects(args);
                    break;
                default:
                    h.printHelp();
                    break;
            }
        } else if (args[0].equals("-magazines")) {
            MagazineOperations m1 = new MagazineOperations();
            switch (args[1]) {
                case "-insertCSV":
                    m1.InsertFromCSV();// Creation of magazines from CSV
                    break;
                case "-updateCSV":
                    m1.updateCSV();
                    break;
                case "-deleteCSV":
                    m1.deleteCSV();
                    break;
                case "-printobjects":
                    m1.printobjects();// Printing all magazines in the libarary
                    break;
                case "-updateobject":
                    m1.updateobject(args);// Update the data of magazine
                    break;
                case "-searchobject":
                    m1.searchobjects(args);
                    break;
                default:
                    h.printHelp();
                    break;
            }
        } else {
            h.printHelp();
        }
    }
}
