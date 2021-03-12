class Person(val id: Int, val givenName: String, var surname: String)
{
    def getName() = givenName + " " + surname
}
