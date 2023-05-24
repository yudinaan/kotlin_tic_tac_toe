fun main() {
    var field = Array(3, {Array(3, {"☐"})})
    output_field(field)
    var round = 0
    while (round < 9){
        field = players_move(field)
        field = opponents_move1(field)

        if(round < 3) continue

        val and = victory_check(field)
        if(and == 1) break
        round++
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
    var n = 0
    var c = 0
    print("Ваш ход, введите номер ряда: ")
    n = readln().toInt() - 1
    print("Введите номер ячейки: ")
    c = readln().toInt() - 1
    field[n][c] = "x"
    output_field(field)
    return field
}

fun opponents_move1(field: Array<Array<String>>): Array<Array<String>> {
    if(field[1][1] == "x"){
        field[0][0] = "o"
    }
    else field[1][1] = "o"

    println("Ход противника: ")
    output_field(field)

    return field
}


fun victory_check(field: Array<Array<String>>): Int {
    val arrayx = Array(3, { Array(3, { "x" }) })
    val arrayo = Array(3, { Array(3, { "o" }) })

    var and = 0

    var a = 0
    while (a < 3) {
        and = if (field[a] == arrayx[a]) {
            println("Вы победили!")
             return 1
        }
        else if (field[a] == arrayo[a]) {
            println("Победил противник!")
            return 1
        }
        else  return 0
        a++

    }

    a = 0
    var b = 0
     if (field[a][b] == arrayx[a][b]) {
        b++
        if (field[a][b] == arrayx[a][b]) {
            b++
            and = if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                return 1
            }
            else return 0
        }
    }


    a = 0
    b = 0
    if (field[a][b] == arrayx[a][b]) {
        a++
        if (field[a][b] == arrayx[a][b]) {
            a++
            and = if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                return 1
            }
            else return 0
        }
    }

    a = 0
    b = 0
    if (field[a][b] == arrayo[a][b]) {
        b++
        if (field[a][b] == arrayo[a][b]) {
            b++
            and =if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                return 1
            }
            else return 0
        }
    }

    a = 0
    b = 0
    if (field[a][b] == arrayo[a][b]) {
        a++
        if (field[a][b] == arrayo[a][b]) {
            a++
            and = if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                return 1
            }
            else return 0
        }
    }

    a = 0
    b = 0
    if (field[a][b] == arrayx[a][b]) {
        a++
        b++
        if (field[a][b] == arrayx[a][b]) {
            a++
            b++
            and = if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                return 1
            }
            else return 0
        }
    }

    a = 0
    b = 0
    if (field[a][b] == arrayo[a][b]) {
        a++
        b++
        if (field[a][b] == arrayo[a][b]) {
            a++
            b++
            and = if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                return 1
            }
            else return 0
        }
    }

    a = 2
    b = 2
    if (field[a][b] == arrayx[a][b]) {
        a--
        b--
        if (field[a][b] == arrayx[a][b]) {
            a--
            b--
            and = if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                return  1
            }
            else return 0
        }
    }

    a = 2
    b = 2
    if (field[a][b] == arrayo[a][b]) {
        a--
        b--
        if (field[a][b] == arrayo[a][b]) {
            a--
            b--
            and = if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                return 1
            }
            else return 0
        }
    }

    return and
}
