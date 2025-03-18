package Finance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
  public void addTransaction(double amount, String description) throws SQLException {
    Connection conn = DatabaseUtil.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO transactions (amount, description) VALUES (?, ?)");
    pstmt.setDouble(1, amount);
    pstmt.setString(2, description);
    pstmt.executeUpdate();
    pstmt.close();
    conn.close();
  }

  public void viewTransactions() throws SQLException {
    Connection conn = DatabaseUtil.getConnection();
    PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM transactions");
    ResultSet rs = pstmt.executeQuery();
    List<Transaction> transactions = new ArrayList<>();
    while (rs.next()) {
      Transaction transaction = new Transaction(rs.getInt("id"), rs.getDouble("amount"), rs.getString("description"));
      transactions.add(transaction);
    }
    rs.close();
    pstmt.close();
    conn.close();
    for (Transaction transaction : transactions) {
      System.out.println(transaction);
    }
  }
}