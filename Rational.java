

	// PUT PRIVATE DATA FIELDS HERE
	private int num, denom;
	/*
	 * The default constructor for objects of class Rational. Creates the
	 * rational number 1.
	 */
	public Rational() {
		num = 1;
		denom = 1;
	}

	/*
	 * The alternate constructor for objects of class Rational. Creates a
	 * rational number equivalent to n/d
	 * @param n
	 * The numerator of the rational number
	 * @param d
	 * The denominator of the rational number
	 */

	public Rational(int n, int d) {
		if (d == 0) {
			throw new ZeroDenominatorException("0 in denominator");
		num = n;
		denom = d;
		normalize();
		}
	}

	/*
	 * Get the value of the Numerator
	 * @return the value of the numerator
	 */

	public int getNumerator() {
		return num;
	}

	/*
	 * Get the value of the Denominator
	 * @return the value of the denominator
	 */
	public int getDenominator() {
		return denom;
	}

	/*
	 * Negate a rational number r
	 * @return a new rational number that is negation of this number -r
	 */

	public Rational negate() {
		return new Rational(-num, denom);
	}

	/*
	 * Invert a rational number r
	 * @return a new rational number that is 1/r.
	 */

	public Rational invert() {
		return new Rational(denom, num);
	}

	/*
	 * Add two rational numbers
	 * @param other
	 * the second argument of the ad
	 * @return a new rational number that is the sum of this and the other
	 */

	public Rational add(Rational other){
		int n = num * other.denom + other.num * denom;
		int d = denom * other.denom;
		return new Rational(n, d);
	}

	/*
	 * Subtract a rational number t from this one r
	 * @param other
	 * the second argument of subtract
	 * @return a new rational number that is r-t
	 */

	public Rational subtract(Rational other){
		return add(other.negate());
	}

	/*
	 * Multiply two rational number
	 * @param other
	 * the second argument of multiply
	 * @return a new rational number that is the sum of this object and other
	 */

	public Rational multiply(Rational other){
		int n = num * other.num;
		int d = denom * other.denom;
		return new Rational(n, d);
	}

	/*
	 * Divide this rational number r by another one t
	 * @param other
	 * the second argument of divide
	 * @return a new rational number that is r/t
	 */

	public Rational divide(Rational other){
		return multiply(other.invert());
	}

	/*
	 * Put the rational number in normal form where the numerato
	 * and the denominator share no common factor
	 */

	private void normalize(){
		if(denom < 0){
			denom = -denom;
			num = -num;
		}
		int a = num, b = denom;
		if(a < 0) {
			a = -a;
		int g = gcd(a, b);
		num /= g;
		denom /= g;
		}
	}

	/*
	 * Recursively compute the greatest common divisor of two positive integers
	 * @param a the first argument of gcd
	 * @param b the second argument of gcd
	 * @return the gcd of the two arguments
	 */

	private int gcd(int a, int b){
		int result = 0;
		if(a < b) {
			result = gcd(b,a);
		}
		else if(b==0) {
			result = a;
		}
		else{
			int remainder = a % b;
			result = gcd(b, remainder);
		}
		return result;
	}
}
