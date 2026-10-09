package com.example.lab3_a2_po_phearun

data class Expense(
    val id: Int,
    val amount: Double,
    val currency: String,
    val category: String,
    val date: String,
    val remark: String? = null
)

val sampleExpenses = listOf(
    Expense(
        id = 1,
        amount = 15.0,
        currency = "$",
        category = "Food",
        date = "09-October-2026",
        remark = "Lunch"
    ),
    Expense(
        id = 2,
        amount = 5.0,
        currency = "$",
        category = "Transport",
        date = "09-October-2026",
        remark = "Bus"
    ),
    Expense(
        id = 3,
        amount = 50.0,
        currency = "$",
        category = "Entertainment",
        date = "10-October-2026",
        remark = "Movies"
    ),
    Expense(
        id = 4,
        amount = 10.0,
        currency = "$",
        category = "Food",
        date = "11-October-2026",
        remark = "Snacks"
    ),
    Expense(
        id = 5,
        amount = 20.0,
        currency = "$",
        category = "Transport",
        date = "11-October-2026",
        remark = "Taxi"
    )
)
