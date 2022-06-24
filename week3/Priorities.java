package week3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Priorities {
	
	public List<Student> getStudents(List<String> events) {
		
		Student student;
		int id;
		String name;
		double cgpa;
		List<Student> studentsList = new ArrayList<>();
		
		//Öncelikli kuyruk oluþturur ve comparator ile kuyruk sýrasýnýn oluþturulma þartlarýný belirtir.
		PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(
				Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));  
		
		for(String event:events) {		//getStudents metoduna parametre olarak gelen listeyi tarar.
			String[] elements = event.split(" ");		//Liste elemanlarýný boþluða göre ayýrarak deðerleri diziye atar.
			if(elements[0].equals("ENTER")) {		
				id = Integer.valueOf(elements[3]);		//Dizinin elemanlarýný sýrasýyla kendi tiplerine dönüþtürerek deðiþkenlere atar.
				name = String.valueOf(elements[1]);
				cgpa = Double.valueOf(elements[2]);
				
				student = new Student(id, name, cgpa);		//Student nesnesi oluþturulur ve bu nesneyi kuyruða ekler.
				studentPriorityQueue.add(student);
			}
			else if(elements[0].equals("SERVED") && !studentPriorityQueue.isEmpty()) {
				studentPriorityQueue.poll();
			}
		}
		
        while (!studentPriorityQueue.isEmpty()) {		//Kuyruk boþalýncaya dek kuyruktan listeye ekleme yapar.
            studentsList.add(studentPriorityQueue.poll());
        }
		
		/*
		 * studentsList = Arrays.asList(studentPriorityQueue.toArray(new Student[studentPriorityQueue.size()]));
		 * Kuyruðu diziye, diziyi listeye döndürme iþlemi. Bu yolu denedim ama hatalý sýralama elde ettim. Bunun sebebi Priority Queue'nin
		 * elemanlarýný sýralama koþullarýna göre tutmuyor oluþu ve listeye dönüþtürülürken de belirtilen koþullara göre ekleme yapmýyor.
		 * .poll() metodu ile koþula uygun çekme ve listeye ekleme iþlemi gerçekleþtirilebilir. 
		*/
        
		return studentsList;
		
	}
	
}
