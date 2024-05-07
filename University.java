import java.util.*;

class School {
	String sname;
	int nofstudents;

	School() {
		sname = "";
		nofstudents = 0;
	}

	// copy constructor
	School(School s) {
		sname = s.sname;
		nofstudents = s.nofstudents;
	}

	School(String sn, int nos) // parameterized constructor
	{
		sname = sn;
		nofstudents = nos;
	}

	void sendOutput() {
		System.out.println("School Name: " + sname);
		System.out.println("No. of Students: " + nofstudents);
	}

	void setProperties(String sn, int nos) {
		sname = sn;
		nofstudents = nos;
	}

}

class University {
	public static void main(String args[]) {
		String school_name;
		int nofstud;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the school Name: ");
		school_name = sc.nextLine();
		System.out.print("Enter the students strength: ");
		nofstud = sc.nextInt();
		School s = new School(school_name, nofstud);
		// s.setProperties(args[0],Integer.parseInt(args[1]));
		System.out.println("Source Object");
		s.sendOutput();
		School s1 = new School(s);
		System.out.println("Target Object");
		s1.sendOutput();
		// object reference
		School objref = s1;
		objref.sendOutput();
		objref.setProperties("Commerce", 4000);
		s1.sendOutput();
		s.sendOutput();
	}
}
