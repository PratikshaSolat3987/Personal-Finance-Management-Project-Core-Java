package Finance;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TransactionDAO transactionDAO = new TransactionDAO();

    while (true) {
      System.out.println("1. Add transaction");
      System.out.println("2. View transactions");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Enter transaction amount: ");
          double amount = scanner.nextDouble();
          System.out.print("Enter transaction description: ");
          String description = scanner.next();
          try {
			transactionDAO.addTransaction(amount, description);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          break;
        case 2:
          try {
			transactionDAO.viewTransactions();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          break;
        case 3:
            System.out.println("Exiting...");
            return;
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      }
    }
  }
