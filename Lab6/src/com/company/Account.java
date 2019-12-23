package com.company;

public class Account {
    public int balance = 0;
    public Account(int balance) {
        this.balance = balance;
    }
    public synchronized int getBalance() {
        return balance;
    }
    public synchronized void changeBalance(int balance) {
        this.balance = this.getBalance() + balance;
    }
}