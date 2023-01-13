import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public static void createBook(Book stud) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into Books values(NULL,?,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, stud.getBook_name());
            stmt.setString(2, stud.getCategory());
            stmt.setDouble(3, stud.getPrice());
            stmt.setDouble(4, stud.getRating());
            stmt.setInt(5, stud.getCopies());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " book row created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBook(int id, String field, String T) {
        Connection con = ConnectionFactory.getConnection();
        int flag = 0;
        String query = "select * from Books";
        try (PreparedStatement stmt1 = con.prepareStatement(query)) {
            ResultSet rs = stmt1.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                            rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                    if (field.equals("book_name")) {
                        b.setBook_name(T);
                        String SQL = "update Books set book_name=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setString(1, b.getBook_name());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " book row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else if (field.equals("category")) {
                        b.setCategory(T);
                        String SQL = "update Books set category=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setString(1, b.getCategory());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " book row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else if (field.equals("price")) {
                        Double d = Double.parseDouble(T);
                        b.setPrice(d);
                        String SQL = "update Books set price=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setDouble(1, b.getPrice());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " book row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else if (field.equals("rating")) {
                        Double d = Double.parseDouble(T);
                        b.setRating(d);
                        String SQL = "update Books set rating=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setDouble(1, b.getRating());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " book row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        Integer i = Integer.parseInt(T);
                        b.setCopies(i);
                        String SQL = "update Books set copies=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setDouble(1, b.getCopies());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " book row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The book with entered ID doesn't exist in this library");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void updateBook(String studline) {
        String values[] = studline.split(",");
        int id = Integer.valueOf(values[0]);
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from Books";
        int flag = 0;
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                            rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                    b.setBook_name(values[1]);
                    b.setCategory(values[2]);
                    b.setPrice(Double.valueOf(values[3]));
                    b.setRating(Double.valueOf(values[4]));
                    b.setCopies(Integer.valueOf(values[5]));
                    final String query = "update Books set book_name=?,category=?,price=?,rating=?,copies=? where id=?";
                    try (PreparedStatement stmt3 = con.prepareStatement(query)) {
                        stmt3.setString(1, b.getBook_name());
                        stmt3.setString(2, b.getCategory());
                        stmt3.setDouble(3, b.getPrice());
                        stmt3.setDouble(4, b.getRating());
                        stmt3.setInt(5, b.getCopies());
                        stmt3.setInt(6, id);
                        int rowsAffected = stmt3.executeUpdate();
                        System.out.println(rowsAffected + " book row updated.");
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The book with entered ID doesn't exist in this library");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBook(String studline) {
        String values[] = studline.split(",");
        int id = Integer.valueOf(values[0]);
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from Books";
        int flag = 0;
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    final String query = "delete from Books where id=?";
                    try (PreparedStatement stmt3 = con.prepareStatement(query)) {
                        stmt3.setInt(1, id);
                        int rowsAffected = stmt3.executeUpdate();
                        System.out.println(rowsAffected + " book is deleted.");
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("The book with entered ID doesn't exist in this library");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchBook(String field, String T) {
        Connection con = ConnectionFactory.getConnection();
        final String query = "select * from Books";
        int flag = 0;
        if (field.equals("id")) {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    Integer d = Integer.parseInt(T);
                    if (rs.getInt("id") == d) {
                        Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                                rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(b);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The book with entered ID doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } else if (field.equals("book_name")) {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    if (rs.getString("book_name").equals(T)) {
                        Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                                rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(b);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The book with entered BOOK NAME doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } else if (field.equals("category")) {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    if (rs.getString("category").equals(T)) {
                        Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                                rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(b);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The book with entered CATEGORY doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } else if (field.equals("price")) {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    Double d = Double.parseDouble(T);
                    if (rs.getDouble("price") == d) {
                        Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                                rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(b);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The book with entered PRICE doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } else if (field.equals("rating")) {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    Double d = Double.parseDouble(T);
                    if (rs.getDouble("rating") == d) {
                        Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                                rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(b);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The book with entered RATING doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } else {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    Integer d = Integer.parseInt(T);
                    if (rs.getInt("copies") == d) {
                        Book b = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                                rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(b);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The book with entered COPIES doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

    }

    // Read - ALL
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from Books";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Book stud = new Book(rs.getInt("id"), rs.getString("book_name"), rs.getString("category"),
                        rs.getDouble("price"), rs.getDouble("rating"), rs.getInt("copies"));
                books.add(stud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
