def seq(f: Int=>Int, op: (Int,Int)=>Int, start: Int)(a: Int, b: Int): Int = {
   def seqF(a: Int, b: Int): Int = 
    if (a>b) start else op(f(a), seqF(a+1,b))
   seqF(a, b)
}
val sum = seq(x=>x, (x,y)=>x+y, 0) _
val prod = seq(x=>x, (x,y)=>x*y, 1) _
