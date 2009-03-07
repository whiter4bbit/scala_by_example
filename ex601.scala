//ex. 6.0.1
//ex. 6.0.2
trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(that: IntSet): IntSet
  def intersect(that: IntSet): IntSet
  def appendTo(that: IntSet): IntSet
  def debug: Unit
  def excl(x: Int): IntSet
}

class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean = 
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def appendTo(that: IntSet): IntSet = {
    val i = left.appendTo(right.appendTo(that));
    i.incl(elem)
  }

  def union(that: IntSet): IntSet = that.appendTo( this )

  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
  }

  def excl(x: Int): IntSet = {
    if (x < elem) new NonEmptySet(elem, left excl x , right)
    else if (x > elem) new NonEmptySet(elem, left, right excl x )
    else right.appendTo(left)
  }

  def intersect(that: IntSet): IntSet = {
    val l = left.intersect(that)
    val r = right.intersect(that)
    val e = l.union(r)
    if (that.contains(elem)) e.incl(elem) else e
  }

  def debug : Unit = {
    left.debug
    print(" "+elem)
    right.debug
  }

}

class EmptySet extends IntSet{  
  def excl(x: Int): IntSet = this
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmptySet(x, new EmptySet, new EmptySet)
  def appendTo(that: IntSet): IntSet = that
  def union(that: IntSet): IntSet = that
  def intersect(that: IntSet): IntSet = this
  def debug: Unit = {}
}
