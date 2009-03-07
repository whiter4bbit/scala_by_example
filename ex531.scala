// def abs(x: Double) = if (x>0) x else -x
// def sqr(x: Double) = x*x
// def isGoodEnough(guess: Double, new_guess: Double) = abs(guess - new_guess) < 0.0001
// def root(guessF: (Int, Double)=>Double)(a: Int): Double = {
//   def iter(x: Int, guess: Double): Double = {
//     val guess_ = guessF(x, guess)
//     if (isGoodEnough( guess, guess_ )) guess_
//     else iter(x, guess_)
//   }
//   iter(a,1)
// }
// val sqrt_2 = root((x,guess)=>(x/guess + guess)/2) _
// val sqrt_3 = root((x,guess)=>(x/sqr(guess) + 2*guess)/3) _
// println(sqrt_2(2))
// println(sqrt_3(8))

val tolerance = 0.0001
def abs(x: Double) = if (x>0) x else -x
def sqr(x: Double) = x*x
def isCloseEnough(x: Double, y: Double) = abs((x-y) / x ) < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if( isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}
def sqrt_3(x: Double) = fixedPoint(y=>(x/sqr(y)+2*y)/3)(1.0)
println(sqrt_3(8))
