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
		
	//Öncelikli kuyruk oluşturur ve comparator ile kuyruk sırasının oluşturulma şartlarını belirtir.
	PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>(
		Comparator.comparing(Student::getCgpa).reversed().thenComparing(Student::getName).thenComparing(Student::getId));  
		
	for(String event:events) {		//getStudents metoduna parametre olarak gelen listeyi tarar.
	    String[] elements = event.split(" ");		//Liste elemanlarını boşluğa göre ayırarak değerleri diziye atar.
	    if(elements[0].equals("ENTER")) {		
		id = Integer.valueOf(elements[3]);		//Dizinin elemanlarını sırasıyla kendi tiplerine dönüştürerek değişkenlere atar.
	        name = String.valueOf(elements[1]);
		cgpa = Double.valueOf(elements[2]);
				
		student = new Student(id, name, cgpa);		//Student nesnesi oluşturur ve bu nesneyi kuyruğa ekler.
		studentPriorityQueue.add(student);
	    }
	    else if(elements[0].equals("SERVED") && !studentPriorityQueue.isEmpty()) {
		studentPriorityQueue.poll();
	    }
	}
		
        while (!studentPriorityQueue.isEmpty()) {		//Kuyruk boşalıncaya dek kuyruktan listeye ekleme yapar.
            studentsList.add(studentPriorityQueue.poll());
        }
		
	/*
	 * studentsList = Arrays.asList(studentPriorityQueue.toArray(new Student[studentPriorityQueue.size()]));
	 * Kuyruğu diziye, diziyi listeye döndürme işlemi. Bu yolu denedim ama hatalı sıralama elde ettim. Bunun sebebi Priority Queue'nin
	 * elemanlarını sıralama koşullarına göre tutmuyor oluşu ve listeye dönüştürülürken de belirtilen koşullara göre ekleme yapmıyor.
	 * .poll() metodu ile koşula uygun çekme ve listeye ekleme işlemi gerçekleştirilebilir. 
	 */
        
	return studentsList;
		
    }
	
}
