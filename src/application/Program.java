package application;

import java.security.DrbgParameters.Reseed;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
/* Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data de entrada e data de saída) e mostrar os dados da reserva, 
   inclusive sua duração em dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar novamente a reserva com os dados
   atualizados. O programa não deve aceitar dados inválidos para a reserva, conforme as seguintes regras:
	- Alterações de reserva só podem ocorrer para datas futuras
	- A data de saída deve ser maior que a data de entrada  */
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println();
			System.out.println("Reservation: ");
			System.out.println(reservation);
// não havendo erro na reserva, instancio uma reserva
			
			System.out.println();
			System.out.println
			("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
// como estou informando a atualização da reserva instancio abaixo a mesma chamando sua "CLASSE.updateDates"
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)){
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date, review your information NOW.");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Description of Reservation: ");
				System.out.println(reservation);
			}			
		}
		
		
		
		
		
		sc.close();
	}
}
