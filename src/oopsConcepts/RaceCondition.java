package oopsConcepts;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Bank {
	private String accountName;
	private int accountNumber;
	private int balance;

	public Bank(String accountName, int accountNumber) {
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.balance = 100;
	}

	private void debitFunds(int transferAmount) {
		this.balance = this.balance - transferAmount;
	}

	private void creditFunds(int transferAmount) {
		this.balance = this.balance + transferAmount;
	}

	public static void transferFunds(Bank fromAccount, Bank toAccount,
			int transferAmount) {
		fromAccount.debitFunds(transferAmount);
		toAccount.creditFunds(transferAmount);
	}

	public String getDetails() {
		return this.accountName + ", " + this.accountNumber + ", "
				+ this.balance;
	}
}

class TransferRunnable implements Runnable {

	private Bank fromAccount;
	private Bank toAccount;
	private int transferAmount;

	public TransferRunnable(Bank fromAccount, Bank toAccount, int transferAmount) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.transferAmount = transferAmount;
	}

	@Override
	public void run() {
		Bank.transferFunds(fromAccount, toAccount, transferAmount);
	}

	public void startTransfer() {
		new Thread(this).start();
	}

}

public class RaceCondition {

	public static void main(String[] args) {

		Bank[] bankAccounts = new Bank[3];
		for (int i = 0; i < bankAccounts.length; i++) {
			bankAccounts[i] = new Bank(("Account" + (i + 1)), (i + 1));
		}

		TransferRunnable transfer1 = new TransferRunnable(bankAccounts[0],
				bankAccounts[1], 30);
		TransferRunnable transfer2 = new TransferRunnable(bankAccounts[1],
				bankAccounts[2], 40);
		TransferRunnable transfer3 = new TransferRunnable(bankAccounts[2],
				bankAccounts[0], 50);

		Callable<Integer> task = () -> {
			transfer1.startTransfer();
			transfer2.startTransfer();
			transfer3.startTransfer();
			return 1;
		};

		ExecutorService executor = Executors.newFixedThreadPool(3);
		Future<Integer> future = executor.submit(task);
		executor.shutdown();
		try {
			future.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		for (int b = 0; b < bankAccounts.length; b++) {
			System.out.println(bankAccounts[b].getDetails());
		}
	}

}
