package week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		
	Priorities priorities = new Priorities();
		
	List<String> events = new ArrayList<String>();
	List<Student> studentsList;
		
	try {
	    Scanner scanner = new Scanner(System.in);		//Metoda gönderilecek verileri kullanıcıdan alır ve events listesine atar.
	    for(int i=0; i<12; i++) {
	        String event;
		event = scanner.nextLine();
		events.add(event);
	    }
	    scanner.close();
	} catch(Exception e) {
	    System.out.println(e);
	}
		
	studentsList = priorities.getStudents(events);		//Kullanıcıdan alınan değerler ile oluşturulan listeyi koşulun gerçekleştirileceği metoda gönderir.
		
	if(studentsList.isEmpty()) {		//Metodun geri döndürdüğü listenin boş mu dolu mu olduğunu kontrol eder.
	    System.out.println("EMPTY");
	}
	else {		//Liste dolu ise studentList'deki öğrencilerin isimlerini yazdırır.
	    studentsList.forEach(student -> System.out.println(student.getName()));
	}
		
    }

}
