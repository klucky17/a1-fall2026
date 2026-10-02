package com.example.kalyn1_rapidrecall

/**
Purpose = add all the logs together to make and total summary
Design Rationale =
    1. get overall total numbers across all logs
    2. calculate accuracry percentage and display
 */

class Summary{
    private val items = mutableListOf<Log>()  //private so that only the coresponding add function can change it

    val attempts: List<Log> get() = items.toList()
    val total: Int get() = items.size  //total number of logs
    val correctCount: Int get() = items.count {it.correct}  //how many attempts were correct
    val accuracy: Double get() =  //accuracy in percentage
        if(total == 0) 0.0
        else correctCount*100.0 / total

    fun add(log: Log){
        items.add(log)
    }
}