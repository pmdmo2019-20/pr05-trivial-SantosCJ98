package es.iessaladillo.pedrojoya.pr05_trivial.base

import es.iessaladillo.pedrojoya.pr05_trivial.base.Question

val a1: List<Answer> = listOf(Answer("Un sistema operativo", true), Answer("Un lenguaje de programación", false), Answer("Un entorno de desarrollo", false), Answer("Ninguna de las anteriores", false))
val a2: List<Answer> = listOf(Answer("Python", false), Answer("Java", true), Answer("HTML", false), Answer("PHP", false))
val a3: List<Answer> = listOf(Answer("build", false), Answer("src", true), Answer("gradle", false), Answer("No lo se", false))
val a4: List<Answer> = listOf(Answer("Una acción", false), Answer("Lo mismo que un fragmento", false), Answer("Una pantalla de la aplicación", true), Answer("Un texto", false))
val a5: List<Answer> = listOf(Answer("Un mensaje emergente al que le podemos dar una accion", true), Answer("Un alimento para la merienda", false), Answer("Lo mismo que un Toast", false), Answer("Un Pokémon", false))

val q1 = Question("¿Qué es Android?", a1)
val q2 = Question("¿Con que lenguaje se puede programar una aplicación Android?", a2)
val q3 = Question("¿Dónde se localiza el codigo fuente de nuestra aplicación Android?", a3)
val q4 = Question("¿Qué es una actividad?", a4)
val q5 = Question("¿Qué es un snackbar?", a5)


val questionList: List<Question> = listOf(q1, q2, q3, q4, q5)