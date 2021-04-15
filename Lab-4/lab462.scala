object Appl462 {
    def odd(n: Int): Boolean = {
        if (n == 0) false
        else even(n - 1) // indirect recursion
    }

    def even(n: Int): Boolean = {
        if (n == 0) true
        else odd(n - 1) // indirect recursion
    }

    def recurseTest(n: Int): Int = {
        try {
            recurseTest(n + 1)
        } catch { case e: java.lang.StackOverflowError =>
            println("Max n value: " + n + ".")
            n
        }
    }

    def main(args: Array[String]) {
        val n = recurseTest(0);
        val str = if (even(n)) " is even." else " is odd."
        println(n.toString + str)
    }
}