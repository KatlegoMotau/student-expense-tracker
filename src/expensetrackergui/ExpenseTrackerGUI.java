package expensetrackergui;

import expense.Expense;
import expensemanager.ExpenseManager;
import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;



public class ExpenseTrackerGUI extends JFrame{
    private ExpenseManager manager;
    private JTable table;
    private DefaultTableModel model;

    public ExpenseTrackerGUI() {
        manager = new ExpenseManager();

        setTitle("Student Expense Tracker");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"Description", "Amount", "Category"}, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel panel = new JPanel();

        JButton addBtn = new JButton("Add");
        JButton deleteBtn = new JButton("Delete");
        JButton totalBtn = new JButton("Total");
        JButton categoryBtn = new JButton("Category Totals");

        panel.add(addBtn);
        panel.add(deleteBtn);
        panel.add(totalBtn);
        panel.add(categoryBtn);

        add(panel, BorderLayout.SOUTH);

        loadTable();

        addBtn.addActionListener(e -> {
            String desc = JOptionPane.showInputDialog("Description:");
            if(desc == null) return;

            String amountStr = JOptionPane.showInputDialog("Amount:");
            if(amountStr == null) return;

            String category = JOptionPane.showInputDialog("Category:");
            if(category == null) return;

            try 
            {
                double amount = Double.parseDouble(amountStr);
                manager.addExpense(new Expense(desc, amount, category));
                loadTable();
            } 
            catch (Exception ex) 
            {
                JOptionPane.showMessageDialog(this, "Invalid input.");
            }
        });

        deleteBtn.addActionListener(e -> {
            int row = table.getSelectedRow();
            if(row != -1) 
            {
                manager.deleteExpense(row);
                loadTable();
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Select a row first.");
            }
        });

        totalBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,"Total Spending: R" + manager.getTotalExpenses());
        });

        categoryBtn.addActionListener(e -> {
            Map<String, Double> totals = manager.getCategoryTotals();

            StringBuilder result = new StringBuilder();

            for(String category : totals.keySet()) 
            {
                result.append(category)
                      .append(": R")
                      .append(totals.get(category))
                      .append("\n");
            }

            JOptionPane.showMessageDialog(this, result.toString());
        });
    }

    private void loadTable() {
        model.setRowCount(0);

        for (Expense e : manager.getExpenses()) {
            model.addRow(new Object[]{
                    e.getDescription(),
                    e.getAmount(),
                    e.getCategory()
            });
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new ExpenseTrackerGUI().setVisible(true));
    }
}
