def factF(n: Int, m: Int): Int = if (n==0) m else factF(n-1,n*m)
def factorial(n: Int) = factF(n,1)


