public class LoanCalc {
	static double epsilon = 0.001;  
	static int iterationCounter;   
	public static void main(String[] args) {		
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		// System.out.println(endBalance(loan, rate, n, 9753.60));

		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0;
		double eachPayment = loan / n;
		while (endBalance(loan, rate, n, eachPayment) >= epsilon) {
			eachPayment += epsilon;
			iterationCounter++;
		}
		return eachPayment;
	}
    
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		double low = loan / n;
		double high = loan; 
		double mid = 0;
		iterationCounter = 0;
	
		while (high - low > epsilon) {
			mid = (high + low) / 2;
			double balance = endBalance(loan, rate, n, mid);
			if (Math.abs(balance) <= epsilon) {
				break; 
			} else if (balance > 0) {
				low = mid;
			} else {
				high = mid;
			}
			
			iterationCounter++;
		}
		return mid;
	}

	private static double endBalance(double loan, double rate, int n, double payment) {
		double prevBal=loan;
		double nextBal=0;
		for (int i=1; i<=n; i++) {
			nextBal = (prevBal - payment)*(1+(rate/100));
			prevBal = nextBal;
		} 
    	return nextBal;
	}
}