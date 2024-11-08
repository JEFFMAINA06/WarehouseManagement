package warehouse.backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static boolean insertUser(String name, String idno, String email, String phone, String role) {
        String checkQuery = "SELECT COUNT(*) FROM users WHERE idno = ?";
        String insertQuery = "INSERT INTO users (username, idno, email, userphone, userrole) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {

            checkStmt.setString(1, idno);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("User with this ID already exists.");
                return false;
            }

            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setString(1, name);
                insertStmt.setString(2, idno);
                insertStmt.setString(3, email);
                insertStmt.setString(4, phone);
                insertStmt.setString(5, role);
                return insertStmt.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Use a logging framework here
            return false;
        }
    }

    public static boolean checkLoginCredentials(String email, String password) {
        String sql = "SELECT password FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return password.equals(rs.getString("password"));
            } else {
                System.out.println("User not found with email: " + email);
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void insertAppUser(AppUserModel appuser) {
        String sql = "INSERT INTO appuser (name, mobileno, email, password) VALUES (?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, appuser.getName());
            ps.setString(2, appuser.getMobile());
            ps.setString(3, appuser.getEmail());
            ps.setString(4, appuser.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Use a logging framework here
        }
    }

    public static void insertCategory(CategoryModel category) {
        String sql = "INSERT INTO category (name) VALUES (?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, category.getName()); // Assuming CategoryModel has a getName() method
            ps.executeUpdate();
        } catch (SQLException e) {
            // Use a logging framework instead of printStackTrace()
            e.printStackTrace(); // Consider using a logger for proper error handling
        }
    }

    public static List<CategoryModel> selectCategories() {
        List<CategoryModel> categories = new ArrayList<>();
        String sql = "SELECT * FROM category;"; // Assuming table name is 'category'

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Assuming your CategoryModel has a constructor with name
                CategoryModel category = new CategoryModel(
                        rs.getInt("categoryId"),
                        rs.getString("name")
                );
                categories.add(category);
            }

        } catch (SQLException e) {
            // Use a logging framework instead of printStackTrace()
            e.printStackTrace(); // Consider using a logger for proper error handling
        }

        return categories;
    }

    public static void insertProduct(ProductModel product) {
        String sql = "INSERT INTO product (Name, Quantity, Price, Description, Category) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getQuantity()); // Assuming quantity is an integer
            ps.setString(3, product.getPrice()); // Assuming price is a double
            ps.setString(4, product.getDescription());
            ps.setString(5, product.getCategory());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Use a logging framework here
        }
    }

    public static void insertCustomer(CustomerModel customer) {
        String sql = "INSERT INTO customer (name, phone, email) VALUES (?,?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, customer.getName());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Customer inserted successfully.");
            } else {
                System.out.println("Failed to insert customer.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider using a logging framework
            System.out.println("Error inserting customer: " + e.getMessage());
        }

    }

    public static List<CustomerModel> selectCustomers() {
        List<CustomerModel> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer;"; // Assuming table name is 'customer'

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CustomerModel customer = new CustomerModel(
                        rs.getInt("CustomerID"), // Use "customerID" (case-sensitive)
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
                customers.add(customer);
            }

        } catch (SQLException e) {
            // Use a logging framework instead of printStackTrace()
            e.printStackTrace(); // Consider using a logger for proper error handling
        }

        return customers;
    }

    public static void insertIncomingStock(IncomingStockModel incomingStock) {
        String sql = "INSERT INTO incomingstock (name, quantity, price, supplier, date, location) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, incomingStock.getName());
            ps.setString(2, incomingStock.getQuantity());
            ps.setString(3, incomingStock.getPrice());
            ps.setString(4, incomingStock.getSupplier());
            ps.setString(5, incomingStock.getDate());
            ps.setString(6, incomingStock.getLocation());

            int rowsInserted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static List<IncomingStockModel> selectIncomingstocks() {
        List<IncomingStockModel> incomingstock = new ArrayList<>();
        String sql = "SELECT *FROM incomingstock;";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                IncomingStockModel incomingStock = new IncomingStockModel(
                        rs.getInt("prodid"),
                        rs.getString("name"),
                        rs.getString("quantity"),
                        rs.getString("price"),
                        rs.getString("supplier"),
                        rs.getString("date"),
                        rs.getString("location")
                );
               incomingStock.add(incomingStock);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Use a logging framework here
        }
        return incomingstock;
    }

    public static void insertSoldStock(SoldStockModel soldStock) {
        String sql = "INSERT INTO incomingstock (name, quantitysold, sellingprice,datesold) VALUES ( ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, soldStock.getName());
            ps.setString(2, soldStock.getQuantitysold());
            ps.setString(3, soldStock.getSellingprice());
            ps.setString(4, soldStock.getDatesold());

            int rowsInserted = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static List<AppUserModel> selectAppUsers() {
        List<AppUserModel> users = new ArrayList<>();
        String sql = "SELECT * FROM appuser;";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                AppUserModel user = new AppUserModel(
                        rs.getInt("appuserid"),
                        rs.getString("name"),
                        rs.getString("mobileno"),
                        rs.getString("email"),
                        rs.getString("password")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Use a logging framework here
        }
        return users;
    }

    public static List<ProductModel> selectProducts() {
        List<ProductModel> products = new ArrayList<>();
        String sql = "Select  *  FROM product;";

        try (Connection con = DatabaseConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProductModel product = new ProductModel(
                        rs.getInt("ProductID"),
                        rs.getString("Name"),
                        rs.getString("Quantity"), // Assuming Quantity is an integer
                        rs.getString("Price"), // Assuming Price is a double
                        rs.getString("Description"),
                        rs.getString("Category")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Use a logging framework here
        }
        return products;
    }

    public static boolean updatePassword(String email, String password) {
        String sql = "UPDATE users SET password = ? WHERE email = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, password);
            pstmt.setString(2, email);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Use a logging framework here
            return false;
        }
    }

    private static class IncomingStock {

        public IncomingStock() {
        }
    }

}
