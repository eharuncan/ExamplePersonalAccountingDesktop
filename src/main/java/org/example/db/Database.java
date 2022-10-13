package org.example.db;

import org.example.app.domain.Expense;
import org.example.app.domain.ExpenseCategory;
import org.example.app.domain.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Database {
    public Database(){
        connectStatus = false; // Yanlışlıkla bir ekstra new leme işlemi yapılmışsa varolan connection kapatılır.
    }

    private Boolean connectStatus;
    private List<User> userList = new ArrayList<>();
    private List<Expense> expenseList = new ArrayList<>();
    private List<ExpenseCategory> expenseCategoryList = new ArrayList<>();

    public Boolean connect(String username, String password){
        if (Objects.equals(username, "admin") && Objects.equals(password, "admin")){
            connectStatus = true;
            return true;
        }
        else {
            connectStatus = false;
            return false;
        }
    }

    public List<User> getUserList() {
        if (Boolean.TRUE.equals(connectStatus)){
            return userList;
        }else {
            return null;
        }
    }
    public void setUserList(List<User> userList) {
        if (Boolean.TRUE.equals(connectStatus)){
            this.userList = userList;
        }
    }

    public List<Expense> getExpenseList() {
        if (Boolean.TRUE.equals(connectStatus)){
            return expenseList;
        }else {
            return null;
        }
    }
    public void setExpenseList(List<Expense> expenseList) {
        if (Boolean.TRUE.equals(connectStatus)){
            this.expenseList = expenseList;
        }
    }

    public List<ExpenseCategory> getExpenseCategoryList() {
        if (Boolean.TRUE.equals(connectStatus)){
            return expenseCategoryList;
        }else {
            return null;
        }
    }
    public void setExpenseCategoryList(List<ExpenseCategory> expenseCategoryList) {
        if (Boolean.TRUE.equals(connectStatus)){
            this.expenseCategoryList = expenseCategoryList;
        }
    }
}
