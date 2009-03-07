def sum(f: Int => Double)(a: Int, b: Int): Double = {
  def iter(a: Int, result: Int): Double = {
    if(a>b) result
    else iter(a+1, result+a)
  }
  iter(a,0)
}

