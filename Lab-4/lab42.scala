import scala.math.pow
import scala.annotation.tailrec

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

    def sumSqrArrayRec3(elems: Array[Int]) = {
        val size = elems.size
        @tailrec
        def goFrom(i: Int, acc: Int): Int = {
            if(i < size) goFrom(i + 1, acc + pow(elems(i), 2).intValue)
            else acc
        }
        goFrom(0, 0)
    }

    def prodArrayIter(elems: Array[Int]) = {
        var prod = 1
        for (i <- elems) prod *= i
        prod
    }

    def prodArrayRec1(i: Int, elems: Array[Int]): Int = {
        if (i < elems.size) elems(i) * prodArrayRec1(i + 1, elems)
        else 1
    }

    def prodArrayRec2(elems: Array[Int]) = {
        val size = elems.size
        def goFrom(i: Int): Int = {
            if (i < size) elems(i) * goFrom(i + 1)
            else 1
        }
        goFrom(0)
    }

    def prodArrayRec3(elems: Array[Int]) = {
        val size = elems.size
        @tailrec
        def goFrom(i: Int, acc: Int): Int = {
            if(i < size) goFrom(i + 1, acc * elems(i))
            else acc
        }
        goFrom(0, 1)
    }

    def sumAbsArrayIter(elems: Array[Int]) = {
        var sum = 0
        for (i <- elems) sum += i.abs
        sum
    }

    def sumAbsArrayRec1(i: Int, elems: Array[Int]): Int = {
        if (i < elems.size) elems(i).abs + sumAbsArrayRec1(i + 1, elems)
        else 0
    }

    def sumAbsArrayRec2(elems: Array[Int]) = {
        val size = elems.size
        def goFrom(i: Int): Int = {
            if (i < size) elems(i).abs + goFrom(i + 1)
            else 0
        }
        goFrom(0)
    }

    def sumAbsArrayRec3(elems: Array[Int]) = {
        val size = elems.size
        @tailrec
        def goFrom(i: Int, acc: Int): Int = {
            if (i < size) goFrom(i + 1, acc + elems(i).abs)
            else acc
        }
        goFrom(0, 0)
    }

    def main(args: Array[String]) {
        val a1To5 = (1 to 5).toArray
        println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
        var expectResult = 15
        checkPredicate(sumArrayIter(a1To5) == expectResult, "sumArrayIter(a1To5) == " + expectResult)
        checkPredicate(sumArrayRec1(0, a1To5) == expectResult, "sumArrayRec1(0, a1To5) == " + expectResult)
        checkPredicate(sumArrayRec2(a1To5) == expectResult, "sumArrayRec2(a1To5) == " + expectResult)

        println("")
        println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
        expectResult = 55
        checkPredicate(sumSqrArrayIter(a1To5) == expectResult, "sumSqrArrayIter(a1To5) == " + expectResult)
        checkPredicate(sumSqrArrayRec1(0, a1To5) == expectResult, "sumSqrArrayRec1(0, a1To5) == " + expectResult)
        checkPredicate(sumSqrArrayRec2(a1To5) == expectResult, "sumSqrArrayRec2(a1To5) == " + expectResult)
        checkPredicate(sumSqrArrayRec3(a1To5) == expectResult, "sumSqrArrayRec3(a1To5) == " + expectResult)
        
        println("")
        println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
        expectResult = 120
        checkPredicate(prodArrayIter(a1To5) == expectResult, "prodArrayIter(a1To5) == " + expectResult)
        checkPredicate(prodArrayRec1(0, a1To5) == expectResult, "prodArrayRec1(0, a1To5) == " + expectResult)
        checkPredicate(prodArrayRec2(a1To5) == expectResult, "prodArrayRec2(a1To5) == " + expectResult)
        checkPredicate(prodArrayRec3(a1To5) == expectResult, "prodArrayRec3(a1To5) == " + expectResult)
        
        println("")
        val aNegative1To5 = (-5 to -1).toArray
        println("Testing with aNegative1To5 = " + aNegative1To5.mkString("Array(", ", ", ") ..."))
        expectResult = 15
        checkPredicate(sumAbsArrayIter(aNegative1To5) == expectResult, "sumAbsArrayIter(aNegative1To5) == " + expectResult)
        checkPredicate(sumAbsArrayRec1(0, aNegative1To5) == expectResult, "sumAbsArrayRec1(0, aNegative1To5) == " + expectResult)
        checkPredicate(sumAbsArrayRec2(aNegative1To5) == expectResult, "sumAbsArrayRec2(aNegative1To5) == " + expectResult)
        checkPredicate(sumAbsArrayRec3(aNegative1To5) == expectResult, "sumAbsArrayRec3(aNegative1To5) == " + expectResult)
    }
}