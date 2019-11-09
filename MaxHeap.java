package tstBST;

import java.util.Scanner;

public class MaxHeap {

	public int leftSon(int i) {
		return 2 * i + 1;
	}

	public int rightSon(int i) {
		return (2 * i + 1) + 1;
	}

	public boolean isHeap(int[] entrada) {

		for (int i = 0; i < entrada.length - 1; i++) {
			for (int j = 0; j < entrada.length; j++) {
				if (leftSon(i) >= entrada.length || rightSon(i) >= entrada.length) {
					return true;
							
				} else {
					if (entrada[i] < entrada[leftSon(i)] || entrada[i] < entrada[rightSon(i)]) {
						return false;
					}
				}

			}
		}
		return true;

	}

	public static void main(String[] args) {

		MaxHeap heap = new MaxHeap();

		Scanner s1 = new Scanner(System.in);

		String entrada = s1.nextLine();
		String[] entradas = entrada.split(" ");

		int[] entrada2 = new int[entradas.length];
		int i = 0;
		
		for (String num : entradas) {
			int entradaInt = Integer.parseInt(num);
			entrada2[i] = entradaInt;
			i++;
		}

		System.out.println(heap.isHeap(entrada2));

	}

}

