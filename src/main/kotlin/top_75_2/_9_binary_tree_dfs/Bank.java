package top_75_2._9_binary_tree_dfs;

import java.util.*;

public class Bank {

    Map<String, Double> balances = new HashMap<>();

    public double deposit(String id, double amount) {
        if (!balances.containsKey(id)) {
            balances.put(id, amount);
            return amount;
        } else {
            double balance = balances.get(id);
            double newBalance = balance + amount;
            balances.put(id, newBalance);
            return newBalance;
        }
    }

    public Double getBalance(String id) {
        return balances.getOrDefault(id, null);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        var id = "daehan";
        bank.deposit(id, 5000);
        System.out.println(bank.getBalance(id + ""));
    }
}
