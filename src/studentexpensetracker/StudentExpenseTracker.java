package studentexpensetracker;

import expense.Expense;
import expensemanager.ExpenseManager;
import javax.swing.JOptionPane;

public class StudentExpenseTracker {

    public static void main(String[] args) 
    {
        ExpenseManager manager = new ExpenseManager();
        int choice = 0;

        do 
        {
            try 
            {
                String menu = """
                        === Student Expense Tracker ===
                        1. Add Expense
                        2. View Expenses
                        3. View Total Spending
                        4. Exit
                        """;

                String input = JOptionPane.showInputDialog(menu);

                if(input == null) 
                {
                    JOptionPane.showMessageDialog(null, "Application closed.");
                    break;
                }

                choice = Integer.parseInt(input);

                switch(choice) {
                    case 1:
                        String desc = JOptionPane.showInputDialog("Enter description:");
                        if(desc == null) break;

                        String amountInput = JOptionPane.showInputDialog("Enter amount:");
                        if(amountInput == null) break;

                        double amount = Double.parseDouble(amountInput);

                        String category = JOptionPane.showInputDialog("Enter category (Food, Transport, etc):");
                        if(category == null) break;

                        Expense expense = new Expense(desc, amount, category);
                        manager.addExpense(expense);

                        JOptionPane.showMessageDialog(null, "Expense added!");
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, manager.getAllExpenses());
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null,"Total Spending: R" + manager.getTotalExpenses());
                        break;

                    case 4:
                        JOptionPane.showMessageDialog(null, "Goodbye!");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice.");
                }

            } 
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers only.");
            } 
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Something went wrong.");
            }
        } 
        while (choice != 4);
    }
}
