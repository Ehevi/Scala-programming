import scala.math.pow

object Appl42 {
    def checkPredicate(pred: Boolean, predAsString: String, prefix: String = "Checking if ") {
        if (pred) println(prefix + predAsString + ": OK")
        else println(prefix + predAsString + ": Fail")
    }

    def sumArrayIter(elems: Array[Int]) = {
        var sum = 0
        for (i <- elems) sum += i
        sum
    }

    def sumArrayRec1(i: Int, elems: Array[Int]): Int = {
        if (i < elems.size) elems(i) + sumArrayRec1(i + 1, elems)
        else 0
    }

    def sumArrayRec2(elems: Array[Int]) = {
        val size = elems.size
        def goFrom(i: Int): Int = {
            if (i < size) elems(i) + goFrom(i + 1)
            else 0
        }
        goFrom(0)
    }

    def sumSqrArrayIter(elems: Array[Int]) = {
        var sum = 0
        for (i <- elems) sum += pow(i, 2).intValue
        sum
    }

    def sumSqrArrayRec1(i: Int, elems: Array[Int]): Int = {
        if (i < elems.size) pow(elems(i), 2).intValue + sumSqrArrayRec1(i + 1, elems)
        else 0
    }

    def sumSqrArrayRec2(elems: Array[Int]) = {
        val size = elems.size
        def goFrom(i: Int): Int = {
            if (i < size) pow(elems(i), 2).intValue + goFrom(i + 1)
            else 0
        }
        goFrom(0)
    }

    def main(args: Array[String]) {
        val a1To5 = (1 to 5).toArray
        println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
        val expectResult = 55
        checkPredicate(sumSqrArrayIter(a1To5) == expectResult, "sumSqrArrayIter(a1To5) == " + expectResult)
        checkPredicate(sumSqrArrayRec1(0, a1To5) == expectResult, "sumSqrArrayRec1(0, a1To5) == " + expectResult)
        checkPredicate(sumSqrArrayRec2(a1To5) == expectResult, "sumSqrArrayRec2(a1To5) == " + expectResult)
    }
}
/*
    def main(args: Array[String]) {
        
        val a1To5 = (1 to 5).toArray
        println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
        val expectResult = 15
        checkPredicate(sumArrayIter(a1To5) == expectResult, "sumArrayIter(a1To5) == " + expectResult)
        checkPredicate(sumArrayRec1(0, a1To5) == expectResult, "sumArrayRec1(0, a1To5) == " + expectResult)
        checkPredicate(sumArrayRec2(a1To5) == expectResult, "sumArrayRec2(a1To5) == " + expectResult)
        

        val a1To5 = (1 to 5).toArray
        println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
        val expectResult = 55
        checkPredicate(sumSqrArrayIter(a1To5) == expectResult, "sumSqrArrayIter(a1To5) == " + expectResult)
        checkPredicate(sumSqrArrayRec1(0, a1To5) == expectResult, "sumSqrArrayRec1(0, a1To5) == " + expectResult)
        checkPredicate(sumSqrArrayRec2(a1To5) == expectResult, "sumSqrArrayRec2(a1To5) == " + expectResult)
    }
*/