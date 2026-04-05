package expensemanager;

import expense.Expense;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ExpenseManager {
    private ArrayList<Expense> expenses;
    private final String FILE_NAME = "expenses.txt";

    public ExpenseManager() {
        expenses = new ArrayList<>();
        loadFromFile();
    }

    public void addExpense(Expense expense) {
        expenses.add(expense);
        saveToFile();
    }

    public void deleteExpense(int index) {
        if(index >= 0 && index < expenses.size()) 
        {
            expenses.remove(index);
            saveToFile();
        }
    }

    public ArrayList<Expense> getExpenses() {
        return expenses;
    }
    
    public String getAllExpenses() {
        if(expenses.isEmpty()) 
        {
            return "No expenses recorded.";
        }

        StringBuilder result = new StringBuilder();

        for(Expense e : expenses) 
        {
            result.append("Description: ")
                  .append(e.getDescription())
                  .append(", Amount: R")
                  .append(e.getAmount())
                  .append(", Category: ")
                  .append(e.getCategory())
                  .append("\n");
        }

        return result.toString();
    }

    public double getTotalExpenses() {
        double total = 0;
        
        for(Expense e : expenses) 
        {
            total += e.getAmount();
        }
        return total;
    }

    public Map<String, Double> getCategoryTotals() {
        Map<String, Double> totals = new HashMap<>();

        for (Expense e : expenses) 
        {
            totals.put(
                e.getCategory(),
                totals.getOrDefault(e.getCategory(), 0.0) + e.getAmount()
            );
        }

        return totals;
    }

    private void saveToFile() {
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) 
        {
            for(Expense e : expenses) 
            {
                writer.println(e.getDescription() + "," + e.getAmount() + "," + e.getCategory());
            }
        } 
        catch(IOException e) 
        {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) 
        {
            String line;

            while((line = reader.readLine()) != null) 
            {
                String[] parts = line.split(",");
                expenses.add(new Expense(
                        parts[0],
                        Double.parseDouble(parts[1]),
                        parts[2]
                ));
            }

        } 
        catch (IOException e) 
        {
            e.getMessage();
        }
    }
}