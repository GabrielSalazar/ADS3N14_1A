package com.senac.View;
import java.util.Scanner;

public class UtilScan {

	private Scanner var = new Scanner(System.in);

	public UtilScan() {
	}

	public int scanInt() {
		return var.nextInt();
	}

}