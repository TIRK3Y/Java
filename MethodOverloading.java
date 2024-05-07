class Addition {
	void add(int x, int y) {
		System.out.println("Addition of 2 integers: " + (x + y));
	}

	void add(int x, int y, int z) {
		System.out.println("Addition of 3 integers: " + (x + y + z));
	}

	void add(double x, double y) {
		System.out.println("Addition of 2 double values: " + (x + y));
	}
}

class MethodOverloading {
	public static void main(String args[]) {
		Addition a = new Addition();
		a.add(10, 20);
		a.add(5, 5, 5);
		a.add(2.5, 3.5);
	}
}