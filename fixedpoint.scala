val tolerance = 0.0001

def isCloseEnough(x: Double, y: Double) = abs((x-y) / x) < tolerance
def isFixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double) = {
    val next = f(guess)
    if(isCloseEnough(guess, next)) next
    else iterate(next)
  }
}
