fun main() {
    var field = Array(3, {Array(3, {"☐"})})
    output_field(field)

    players_move(field)
    opponents_move1(field)

    var round = 1
    while (round <= 5){
        round++
        field = players_move(field)

        val and = victory_check(field)
        println(and)
        if(round == 5){
            if(and == 0) println("Ничья! ")
        }
        if(and == 1) continue

        field = opponents_move(field)
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
    field[n][c] = "X"
    output_field(field)
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
    }
    else opponents_move(field)

    return field
}
fun randomIndex(field: Array<Array<String>>, n: Int, m: Int): Boolean {

    val a = if(field[n][m] == "☐"){
        return true
    }
    else return false

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

    var and = 0

    var a = 0
    var b = 0
    if (field[a][b] == arrayx[a][b]) {
        b++
        if (field[a][b] == arrayx[a][b]) {
            b++
            if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                and = 1
            }
            else and = 0
        }
    }

    a = 1
    b = 0
    if (field[a][b] == arrayx[a][b]) {
        b++
        if (field[a][b] == arrayx[a][b]) {
            b++
            if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                and = 1
            }
            else and = 0
        }
    }

    a = 2
    b = 0
    if (field[a][b] == arrayx[a][b]) {
        b++
        if (field[a][b] == arrayx[a][b]) {
            b++
            if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                and = 1
            }
            else and = 0
        }
    }

    a = 0
    b = 0
    if (field[a][b] == arrayo[a][b]) {
        b++
        if (field[a][b] == arrayo[a][b]) {
            b++
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 0
        }
    }

    a = 1
    b = 0
    if (field[a][b] == arrayo[a][b]) {
        b++
        if (field[a][b] == arrayo[a][b]) {
            b++
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 0
        }
    }

    a = 2
    b = 0
    if (field[a][b] == arrayo[a][b]) {
        b++
        if (field[a][b] == arrayo[a][b]) {
            b++
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 0
        }
    }


    a = 0
    b = 0
    if (field[a][b] == arrayx[a][b]) {
        a++
        if (field[a][b] == arrayx[a][b]) {
            a++
            if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                and = 1
            }
            else and = 0
        }
    }

    a = 0
    b = 1
    if (field[a][b] == arrayx[a][b]) {
        a++
        if (field[a][b] == arrayx[a][b]) {
            a++
             if (field[a][b] == arrayx[a][b]) {
                 println("Вы победили!")
                 and = 1
            }
            else and = 0
        }
    }

    a = 0
    b = 2
    if (field[a][b] == arrayx[a][b]) {
        a++
        if (field[a][b] == arrayx[a][b]) {
            a++
            if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                and = 1
            }
            else and = 0
        }
    }

    a = 0
    b = 0
    if (field[a][b] == arrayo[a][b]) {
        a++
        if (field[a][b] == arrayo[a][b]) {
            a++
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 0
        }
    }

    a = 0
    b = 1
    if (field[a][b] == arrayo[a][b]) {
        a++
        if (field[a][b] == arrayo[a][b]) {
            a++
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 1
        }
    }

    a = 0
    b = 2
    if (field[a][b] == arrayo[a][b]) {
        a++
        if (field[a][b] == arrayo[a][b]) {
            a++
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 0
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
            if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                and = 1
            }
            else and = 0
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
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 0
        }
    }

    a = 0
    b = 2
    if (field[a][b] == arrayx[a][b]) {
        a++
        b--
        if (field[a][b] == arrayx[a][b]) {
            a++
            b--
            if (field[a][b] == arrayx[a][b]) {
                println("Вы победили!")
                and = 1
            }
            else and = 0
        }
    }

    a = 0
    b = 2
    if (field[a][b] == arrayo[a][b]) {
        a++
        b--
        if (field[a][b] == arrayo[a][b]) {
            a++
            b--
            if (field[a][b] == arrayo[a][b]) {
                println("Победил противник!")
                and = 1
            }
            else and = 1
        }
    }

    return and
}

