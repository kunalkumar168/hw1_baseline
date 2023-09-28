import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    

    
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      try{
          // Get transaction data from view
          double amount = view.getAmountField(); 
          String category = view.getCategoryField();

          InputValidation validate = new InputValidation(amount, category);
          validate.validateAmount();
          validate.validateCategory();

          // Create transaction object
          Transaction t = new Transaction(amount, category);

          // Call controller to add transaction
          view.addTransaction(t);
      }
      catch(InvalidAmountException e1)
      {
        JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a valid number in range (1,1000).", "Error", JOptionPane.ERROR_MESSAGE);
      }
      catch(IllegalArgumentException e2)
      {
        JOptionPane.showMessageDialog(null, "Invalid category. Please enter valid category from list : food, travel, bills, entertainment, other.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

  }

}