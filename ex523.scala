def product(f: Int=>Int, a: Int, b: Int): Int = 
  if (a>b) 1 else f(a)*product(f, a+1,b)
def factorial(n: Int) = product(x=>x, 1, n)

println(factorial(0));
println(factorial(3));
println(factorial(4));
