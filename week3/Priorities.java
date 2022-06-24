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
		
		//�ncelikli kuyruk olu�turur ve comparator ile kuyruk s�ras�n�n olu�turulma �artlar�n� belirtir.
		PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(
				Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));  
		
		for(String event:events) {		//getStudents metoduna parametre olarak gelen listeyi tarar.
			String[] elements = event.split(" ");		//Liste elemanlar�n� bo�lu�a g�re ay�rarak de�erleri diziye atar.
			if(elements[0].equals("ENTER")) {		
				id = Integer.valueOf(elements[3]);		//Dizinin elemanlar�n� s�ras�yla kendi tiplerine d�n��t�rerek de�i�kenlere atar.
				name = String.valueOf(elements[1]);
				cgpa = Double.valueOf(elements[2]);
				
				student = new Student(id, name, cgpa);		//Student nesnesi olu�turulur ve bu nesneyi kuyru�a ekler.
				studentPriorityQueue.add(student);
			}
			else if(elements[0].equals("SERVED") && !studentPriorityQueue.isEmpty()) {
				studentPriorityQueue.poll();
			}
		}
		
        while (!studentPriorityQueue.isEmpty()) {		//Kuyruk bo�al�ncaya dek kuyruktan listeye ekleme yapar.
            studentsList.add(studentPriorityQueue.poll());
        }
		
		/*
		 * studentsList = Arrays.asList(studentPriorityQueue.toArray(new Student[studentPriorityQueue.size()]));
		 * Kuyru�u diziye, diziyi listeye d�nd�rme i�lemi. Bu yolu denedim ama hatal� s�ralama elde ettim. Bunun sebebi Priority Queue'nin
		 * elemanlar�n� s�ralama ko�ullar�na g�re tutmuyor olu�u ve listeye d�n��t�r�l�rken de belirtilen ko�ullara g�re ekleme yapm�yor.
		 * .poll() metodu ile ko�ula uygun �ekme ve listeye ekleme i�lemi ger�ekle�tirilebilir. 
		*/
        
		return studentsList;
		
	}
	
}
