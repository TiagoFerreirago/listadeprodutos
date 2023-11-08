package product.aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import product.entities.ImportedProduct;
import product.entities.Product;
import product.entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat clock =new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of products:");
		int qtRegister = sc.nextInt();
		List <Product> list = new ArrayList<>();
		for(int i=0; i < qtRegister; i++) {
			System.out.println("Product #"+(i+1)+" data:");
			System.out.print("Common, used or imported (c/u/i)?");
			char opct = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name= sc.nextLine();
			System.out.print("Price: ");
			Double price= sc.nextDouble();
			if(opct == 'c') {
				list.add(new Product(name,price));
			}
			else if(opct == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY):");
				Date date = clock.parse(sc.next());
				list.add(new UsedProduct(name,price,date));
			}
			else if(opct == 'i') {
				System.out.print("Customs fee: ");
				Double customs= sc.nextDouble();
				list.add(new ImportedProduct(name,price,customs));
			}
		}
		System.out.println("PRICE TAGS:");
		for(Product listProd : list) {
			System.out.print(listProd.priceTag()+"\n");
		}
	}

}
