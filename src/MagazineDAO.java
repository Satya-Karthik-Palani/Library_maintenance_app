import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MagazineDAO {
    // Create
    public static void createMagazine(Magazine stud) {
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "insert into Magazines values(NULL,?,?,?,?)";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            stmt.setString(1, stud.getMagazine_name());
            stmt.setDouble(2, stud.getPrice());
            stmt.setDouble(3, stud.getRating());
            stmt.setInt(4, stud.getCopies());
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " magazine row created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateMagazine(int id, String field, String T) {
        Connection con = ConnectionFactory.getConnection();
        String query = "select * from Magazines";
        int flag = 0;
        try (PreparedStatement stmt1 = con.prepareStatement(query)) {
            ResultSet rs = stmt1.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    Magazine m = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                            rs.getDouble("rating"), rs.getInt("copies"));
                    if (field.equals("Magazine_name")) {
                        m.setMagazine_name(T);
                        String SQL = "update Magazines set Magazine_name=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setString(1, m.getMagazine_name());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " magazine row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else if (field.equals("price")) {
                        Double d = Double.parseDouble(T);
                        m.setPrice(d);
                        String SQL = "update Magazines set price=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setDouble(1, m.getPrice());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " magazine row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else if (field.equals("rating")) {
                        Double d = Double.parseDouble(T);
                        m.setRating(d);
                        String SQL = "update Magazines set rating=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setDouble(1, m.getRating());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " magazine row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        Integer i = Integer.parseInt(T);
                        m.setCopies(i);
                        String SQL = "update Magazines set copies=? where id=?";
                        try (PreparedStatement stmt2 = con.prepareStatement(SQL)) {
                            stmt2.setDouble(1, m.getCopies());
                            stmt2.setInt(2, id);
                            int rowsAffected = stmt2.executeUpdate();
                            System.out.println(rowsAffected + " magazine row updated.");
                        } catch (SQLException e2) {
                            e2.printStackTrace();
                        }
                    }
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The magazine with entered ID doesn't exist in this library");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void updateMagazine(String studline) {
        String values[] = studline.split(",");
        int id = Integer.valueOf(values[0]);
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from Magazines";
        int flag = 0;
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    Magazine m = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                            rs.getDouble("rating"), rs.getInt("copies"));
                    m.setMagazine_name(values[1]);
                    m.setPrice(Double.valueOf(values[2]));
                    m.setRating(Double.valueOf(values[3]));
                    m.setCopies(Integer.valueOf(values[4]));
                    final String query = "update Magazines set Magazine_name=?,price=?,rating=?,copies=? where id=?";
                    try (PreparedStatement stmt3 = con.prepareStatement(query)) {
                        stmt3.setString(1, m.getMagazine_name());
                        stmt3.setDouble(2, m.getPrice());
                        stmt3.setDouble(3, m.getRating());
                        stmt3.setInt(4, m.getCopies());
                        stmt3.setInt(5, id);
                        int rowsAffected = stmt3.executeUpdate();
                        System.out.println(rowsAffected + " magazine row updated.");
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                System.out.println("The magazine with entered ID doesn't exist in this library");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMagazine(String studline) {
        String values[] = studline.split(",");
        int id = Integer.valueOf(values[0]);
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from Magazines";
        int flag = 0;
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getInt("id") == id) {
                    final String query = "delete from Magazines where id=?";
                    try (PreparedStatement stmt3 = con.prepareStatement(query)) {
                        stmt3.setInt(1, id);
                        int rowsAffected = stmt3.executeUpdate();
                        System.out.println(rowsAffected + " magazine is deleted.");
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }
                    flag = 1;
                }
            }
            if (flag == 0) {
                System.out.println("The magazine with entered ID doesn't exist in this library");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchMagazine(String field, String T) {
        Connection con = ConnectionFactory.getConnection();
        final String query = "select * from Magazines";
        int flag = 0;
        if (field.equals("id")) {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    Integer d = Integer.parseInt(T);
                    if (rs.getInt("id") == d) {
                        Magazine m = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                                rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(m);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The magazine with entered ID doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        } else if (field.equals("Magazine_name")) {
            try (PreparedStatement stmt1 = con.prepareStatement(query)) {
                ResultSet rs = stmt1.executeQuery();
                while (rs.next()) {
                    if (rs.getString("Magazine_name").equals(T)) {
                        Magazine m = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                                rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(m);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The magazine with entered MAGAZINE_NAME doesn't exist in this library");
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
                        Magazine m = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                                rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(m);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The magazine with entered PRICE doesn't exist in this library");
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
                        Magazine m = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                                rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(m);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The magazine with entered RATING doesn't exist in this library");
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
                        Magazine m = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                                rs.getDouble("rating"), rs.getInt("copies"));
                        System.out.println(m);
                        flag = 1;

                    }
                }
                if (flag == 0) {
                    System.out.println("The magazine with entered COPIES doesn't exist in this library");
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

    }

    // Read - ALL
    public static List<Magazine> getAllMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        Connection con = ConnectionFactory.getConnection();
        final String SQL = "select * from Magazines";
        try (PreparedStatement stmt = con.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Magazine stud = new Magazine(rs.getInt("id"), rs.getString("Magazine_name"), rs.getDouble("price"),
                        rs.getDouble("rating"), rs.getInt("copies"));
                magazines.add(stud);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazines;
    }
}
