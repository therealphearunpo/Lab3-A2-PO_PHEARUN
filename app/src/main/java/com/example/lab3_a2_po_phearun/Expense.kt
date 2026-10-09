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
        amount = 2.0,
        currency = "$",
        category = "Food",
        date = "09-October-2026",
        remark = "Breakfast"
    ),
    Expense(
        id = 2,
        amount = 1.5,
        currency = "$",
        category = "Food",
        date = "09-October-2026",
        remark = "Lunch"
    ),
    Expense(
        id = 3,
        amount = 2.00,
        currency = "$",
        category = "Food",
        date = "09-October-2026",
        remark = "Dinner"
    ),
    Expense(
        id = 4,
        amount = 1.0,
        currency = "$",
        category = "Food",
        date = "09-October-2026",
        remark = "Snacks"
    ),
    Expense(
        id = 5,
        amount = 1.0,
        currency = "$",
        category = "Food",
        date = "09-October-2026",
        remark = "Drink"
    )
)
