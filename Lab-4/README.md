# Laboratorium 4.
## 1. Inferencja typu wyniku metody rekurencyjnej
#### `lab41.scala`:
```scala
object Appl41 {
  def factorial(n: Int): Int = {
    assert(n >= 0)
    if (n == 0 || n == 1) 1
    else n * factorial(n - 1)
  }

  def fibb(n: Int): Int = {
    assert(n >= 0)
    if (n == 0 || n == 1) n
    else fibb(n - 2) + fibb(n - 1)
  }

  def main(args: Array[String]) {
    println("5! = " + factorial(5))
    println("Fibb(10) = " + fibb(10))
  }
}
```
![](pictures/1-appl41.png)

## 2. Elementarne algorytmy “tablicowe”: *iteracja* vs. *rekursja*
#### Zadanie
Uzupełnić definicje metod `sumArrayRec1` i `sumArrayRec2` (plik `lab42.scala`) tak, aby wszystkie testy "przechodziły pozytywnie" (miały status `OK`).
```scala
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
```
![](pictures/2-4-zad-1.png)

#### Zadanie
Dodać zestawy testów oraz implementacje metod:
- [x] `sumSqrArrayIter` + `sumSqrArrayRec1` + `sumSrqArrayRec2` (suma kwadratów elementów tablicy)
```scala
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
```

```scala
def main(args: Array[String]) {
    val a1To5 = (1 to 5).toArray
    println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
    val expectResult = 55
    checkPredicate(sumSqrArrayIter(a1To5) == expectResult, "sumSqrArrayIter(a1To5) == " + expectResult)
    checkPredicate(sumSqrArrayRec1(0, a1To5) == expectResult, "sumSqrArrayRec1(0, a1To5) == " + expectResult)
    checkPredicate(sumSqrArrayRec2(a1To5) == expectResult, "sumSqrArrayRec2(a1To5) == " + expectResult)
}
```
![](pictures/2-4-zad-2.png)

- [x] `prodArrayIter` + `prodArrayRec1` + `prodArrayRec2` (iloczyn elementów tablicy)
```scala
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
```

```scala
def main(args: Array[String]) {
    val a1To5 = (1 to 5).toArray
    println("Testing with a1To5 = " + a1To5.mkString("Array(", ", ", ") ..."))
    val expectResult = 120
    checkPredicate(prodArrayIter(a1To5) == expectResult, "prodArrayIter(a1To5) == " + expectResult)
    checkPredicate(prodArrayRec1(0, a1To5) == expectResult, "prodArrayRec1(0, a1To5) == " + expectResult)
    checkPredicate(prodArrayRec2(a1To5) == expectResult, "prodArrayRec2(a1To5) == " + expectResult)
}
```
![](pictures/2-4-zad-2-prod.png)

- [x] `sumAbsArrayIter` + `sumAbsArrayRec1` + `sumAbsArrayRec2` (suma wartości bezwzględnych elementów tablicy)

```scala
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
```

```scala
def main(args: Array[String]) {
    val aNegative1To5 = (-5 to -1).toArray
    println("Testing with aNegative1To5 = " + aNegative1To5.mkString("Array(", ", ", ") ..."))
    val expectResult = 15
    checkPredicate(sumAbsArrayIter(aNegative1To5) == expectResult, "sumAbsArrayIter(a1To5) == " + expectResult)
    checkPredicate(sumAbsArrayRec1(0, aNegative1To5) == expectResult, "sumAbsArrayRec1(0, a1To5) == " + expectResult)
    checkPredicate(sumAbsArrayRec2(aNegative1To5) == expectResult, "sumAbsArrayRec2(a1To5) == " + expectResult)
}
```
![](pictures/2-4-zad-2-sum-abs.png)

#### Zadanie
uzupełnić brakujące miejsca w pliku `lab43.scala` tak, aby wszystkie testy przechodziły pozytywnie; metody mają zwracać element o największej wartości.

## 3. Rekursja - przepełnienie stosu
## 4. Rekursja “ogonowa”/końcowa, adnotacja *@tailrec*
## 5. Usprawnianie procesów rekurencyjnych: “*memoization*“ i wzorzec “*trampolina*“
## 6. Odwzorowanie `switch - case` (z Javy) w Scali (wariant z typem wyliczeniowym)
## 7. Constant patterns (vs. *variable patterns*)
## 8. Constructor patterns
## 9. Variable binding and pattern guards
## 10. Typed patterns
## 11. Typ `Option`
## 12. Ekstraktory
#### Zadanie
