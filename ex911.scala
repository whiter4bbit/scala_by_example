//9.1.1

def insert(x: Int, xs: List[Int]): List[Int] = if (xs.isEmpty) List(x) else xs.head::insert(x, xs.tail)

def isort(xs: List[Int]): List[Int] = if (xs.isEmpty) List() else insert(xs.head, isort(xs.tail))

//9.2.1

/*def length(l: List): Int = l match {
  case Nil => 0
  case x::xs => 1 + length(xs.tail)
}*/

def length[A](l: List[A], len: Int): Int = l match {
  case Nil => len
  case _ => length(l.tail, len+1)
}

//9.4.1

def squareList(xs: List[Int]): List[Int] = xs match {
  case List() => Nil
  case y::ys => y*y::squareList(xs.tail)
}

def squareList(xs: List[Int]): List[Int] = 
  xs map (x => x*x)
