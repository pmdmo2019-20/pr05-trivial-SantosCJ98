package es.iessaladillo.pedrojoya.pr05_trivial.base

data class Question (val question: String, val answers: List<Answer>)

data class Answer(val res: String, val isCorrect: Boolean)