def product(f: Int=>Int, a: Int, b: Int): Int = 
  if (a>b) return 1 else f(a)*product(a+1,b)
