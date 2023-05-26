fun main() {
    var field = Array(3, {Array(3, {"☐"})})
    output_field(field)

    players_move(field)
    opponents_move1(field)

    var round = 1
    while (round <= 5){
        round++
        field = players_move(field)

        var and = victory_check(field)
        if(round == 5){
            if(and == 0) println("Ничья! ")
        }
        if(and > 0) break

        field = opponents_move(field)
        and = victory_check(field)
        if(and > 0) break
    }

}

fun output_field(field: Array<Array<String>>){
    for(row in field){
        for(cell in row){
            print("$cell \t")
        }
        println()
    }
}

fun players_move(field: Array<Array<String>>): Array<Array<String>> {
    print("Ваш ход, введите номер ряда номер ячейки через запятую: ")
    var str = readln()
    val d = ","
    val index = str.split(d).toTypedArray()
    val n = index[0].toInt() - 1
    val m = index[1].toInt() - 1

    val a = randomIndex(field,n,m)

    if(a == true){
    field[n][m] = "X"
    output_field(field)
    }else{
        println("Ячейка занята!")
        players_move(field)
    }

    return field
}

fun opponents_move(field: Array<Array<String>>): Array<Array<String>> {
    var n = (0..2).random()
    var m = (0..2).random()

    val a = randomIndex(field,n,m)

    if(a == true){
        field[n][m] = "O"
        println("Ход противника: ")
        output_field(field)
    } else opponents_move(field)

    return field
}
fun randomIndex(field: Array<Array<String>>, n: Int, m: Int): Boolean {

    val a = if(field[n][m] == "☐"){
         true
    }
    else false

    return a
}

fun opponents_move1(field: Array<Array<String>>): Array<Array<String>> {

    if (field[1][1] == "X") {
        field[0][0] = "O"
    } else field[1][1] = "O"

    println("Ход противника: ")
    output_field(field)

    return field
}


fun victory_check(field: Array<Array<String>>): Int {
    val arrayx = Array(3, { Array(3, { "X" }) })
    val arrayo = Array(3, { Array(3, { "O" }) })
    val x = "Вы победили!"
    val o = "Победил противник!"
    var and = 0

    and = victory_check_row1(field, arrayx, arrayo, and, x, o)
    and = victory_check_column1(field, arrayx, arrayo, and, x, o)

    and = victory_check_diagonal(field,arrayx, and, x)
    and = victory_check_diagonal(field,arrayo, and, o)

    and = victory_check_reverse_diagonal(field,arrayx, and, x)
    and = victory_check_reverse_diagonal(field,arrayo, and, o)

    return and
}

fun victory_check_row1(field: Array<Array<String>>, arrayx: Array<Array<String>>, arrayo: Array<Array<String>>, and: Int, x: String, o: String): Int{
    var and1 = and
    var a = 0
    val b = 0
    for (a in 0..2) {
        and1 = victory_check_row(field, arrayx, a, b, and1, x)
        and1 = victory_check_row(field, arrayo, a, b, and1, o)
    }
    return and1
}

fun victory_check_column1(field: Array<Array<String>>, arrayx: Array<Array<String>>, arrayo: Array<Array<String>>, and: Int, x: String, o: String): Int{
    var and1 = and
    val a = 0
    var b = 0
    for (b in 0..2) {
        and1 = victory_check_column(field, arrayx, a, b, and1, x)
        and1 = victory_check_column(field, arrayo, a, b, and1, o)
    }
    return and1
}

fun victory_check_row(field: Array<Array<String>>, array: Array<Array<String>>, a: Int, b: Int, and: Int, x: String): Int{
    val a1 = a
    var b1 = b
    var and1 = and

    if (field[a1][b1] == array[a1][b1]) {
        b1++
        if (field[a1][b1] == array[a1][b1])  {
            b1++
            if (field[a1][b1] == array[a1][b1])  {
                println(x)
                and1 ++
            }
        }
    }
    return and1
}

fun victory_check_column(field: Array<Array<String>>, array: Array<Array<String>>, a: Int, b: Int, and: Int, x: String): Int{
    var a1 = a
    val b1 = b
    var and1 = and
    if (field[a1][b1] == array[a1][b1]) {
        a1++
        if (field[a1][b1] == array[a1][b1]) {
            a1++
            if (field[a1][b1] == array[a1][b1]) {
                println(x)
                and1 ++
            }
        }
    }
    return and1
}

fun victory_check_diagonal(field: Array<Array<String>>, array: Array<Array<String>>, and: Int, x: String): Int{
    var a = 0
    var b = 0
    var and1 = and

    if (field[a][b] == array[a][b]) {
        a++
        b++
        if (field[a][b] == array[a][b])  {
            a++
            b++
            if (field[a][b] == array[a][b])  {
                println(x)
                and1 ++
            }
        }
    }
    return and1
}
fun victory_check_reverse_diagonal(field: Array<Array<String>>, array: Array<Array<String>>, and: Int, x: String): Int{
    var a = 0
    var b = 2
    var and1 = and

    if (field[a][b] == array[a][b]) {
        a++
        b--
        if (field[a][b] == array[a][b]) {
            a++
            b--
            if (field[a][b] == array[a][b]) {
                println(x)
                and1 ++
            }
        }
    }
    return and1
}

