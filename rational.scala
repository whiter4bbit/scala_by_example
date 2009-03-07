class Rational(n: Int, d: Int) extends AnyRef{
  private def gcd(x: Int, y: Int): Int = {
    if (x == 0) y
    else if( x < 0) gcd(-x, y)
    else if( y < 0) gcd(x, -y)
    else gcd(y % x, x)
  }

  private val g = gcd(n, d)
  
  val numer: Int = n/d
  val denom: Int = d/g
  def +(that: Rational) = 
    new Rational(numer * that.denom + that.numer * denom,
	       denom * that.denom)
  def -(that: Rational) = 
    new Rational(numer * that.denom - that.numer * denom,
	       denom * that.denom)
  
  def *(that: Rational) = 
    new Rational(numer * that.numer, denom * that.denom)

  def /(that: Rational) = 
    new Rational(numer * that.denom, denom * that.numer)

  override def toString = "" + numer + "/" + denom
}

val a = new Rational(1,2) * new Rational(2,3)
println(a)
