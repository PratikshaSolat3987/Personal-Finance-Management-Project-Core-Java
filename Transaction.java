package Finance;
public class Transaction {
	  private int id;
	  private double amount;
	  private String description;

	  public Transaction(int id, double amount, String description) {
	    this.id = id;
	    this.amount = amount;
	    this.description = description;
	  }

	  public int getId() {
	    return id;
	  }

	  public double getAmount() {
	    return amount;
	  }

	  public String getDescription() {
	    return description;
	  }

	  @Override
	  public String toString() {
	    return "Transaction{" +
	        "id=" + id +
	        ", amount=" + amount +
	        ", description='" + description + '\'' +
	        '}';
	  }
	}