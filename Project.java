import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
class Reg implements Serializable {
	
	String name;
	int roll;
	String branch;
	int sem;
	
	Reg(String name,int roll,String branch,int sem) {
		this.name=name;
		this.roll=roll;
		this.branch=branch;
		this.sem=sem;
	}
	
	static void registration() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Name");
		String name=sc.nextLine();
		System.out.println("Enter your Roll number");
		int roll=sc.nextInt();
		System.out.println("Enter your Branch");
		sc.nextLine();
		String branch=sc.nextLine();
		System.out.println("Enter your Semester");
		int sem=sc.nextInt();
		Reg ob=new Reg(name,roll,branch,sem);
		FileOutputStream fos=new FileOutputStream(roll+".txt");
		ObjectOutputStream os=new ObjectOutputStream(fos);
		os.writeObject(ob);
		fos.flush();
		fos.close();
	}
	
	static void showRecord() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student's Roll number to show record");
		int roll=sc.nextInt();
		File f=new File(roll+".txt");
		if(f.exists()) {
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object obj=ois.readObject();
			Reg t=(Reg)obj;
			System.out.println("===============================\n");
			System.out.println("  Student's Name :\t"+t.name);
			System.out.println("  Roll No.       :\t"+t.roll);
			System.out.println("  Branch         :\t"+t.branch);
			System.out.println("  Semester       :\t"+t.sem);
			System.out.println("\n===============================");
			
			fis.close();
		}
		else {
			System.out.println("Record is not available");
		}
	}
	
	static void deleteRecord() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student's Roll number to delete record");
		int roll=sc.nextInt();
		File f=new File(roll+".txt");
		if(f.exists()) {
			f.delete();
			System.out.println("Record is successfully deleted");
		}
		else {
			System.out.println("Record is not available");
		}
	}
	
	static void updateRecord() throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Student's Roll number to update record");
		int roll=sc.nextInt();
		File f=new File(roll+".txt");
		if(f.exists()) {
			System.out.println("Enter your name");
			sc.nextLine();
			String name=sc.nextLine();
			System.out.println("Enter your Branch");
			String branch=sc.nextLine();
			System.out.println("Enter your semester");
			int sem=sc.nextInt();
			Reg obj=new Reg(name,roll,branch,sem);
			FileOutputStream fos=new FileOutputStream(roll+".txt");
			ObjectOutputStream os=new ObjectOutputStream(fos);
			os.writeObject(obj);
			fos.flush();
			fos.close();
			System.out.println("Record is successfully updated");
		}
		else {
			System.out.println("Not Registered...!");
		}
	}
	
	
	
	static void showAllRecord() throws Exception {
		int count=0;
		File f=new File("C:\\Users\\Shivam\\Desktop");
		File lists[]=f.listFiles(new MyFilter());
		for(File f1:lists) {
			FileInputStream fis=new FileInputStream(f1);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Object obj=ois.readObject();
			Reg t=(Reg)obj;
			System.out.println("===============================\n");
			System.out.println("  Student's Name :\t"+t.name);
			System.out.println("  Roll No.       :\t"+t.roll);
			System.out.println("  Branch         :\t"+t.branch);
			System.out.println("  Semester       :\t"+t.sem);
			System.out.println("\n===============================");
			count++;
			fis.close();
		}
		if(count==0) {
			System.out.println("Registration till now...!");
		}
	}
	
	public static void main(String ... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n\n1. Registration");
			System.out.println("2. Show record");
			System.out.println("3. Delete record");
			System.out.println("4. Update record");
			System.out.println("5. Show all record");
			System.out.println("6. Exit\n");
			System.out.println("Enter your option");
			int i=sc.nextInt();
			switch(i) {
				case 1:
					registration();
					break;
				case 2:
					showRecord();
					break;
				case 3:
					deleteRecord();
					break;
				case 4:
					updateRecord();
					break;
				case 5:
					showAllRecord();
					break;
				case 6:
					System.exit(1);
				default:
					System.out.println("Wrong Choice");
			}
		}
	}
}