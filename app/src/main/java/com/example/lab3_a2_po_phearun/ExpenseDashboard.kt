package com.example.lab3_a2_po_phearun

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpenseDashboardScreen(expenses: List<Expense>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Expense Tracker") }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // 1. Total Display (D1)
            TotalDisplayCard(expenses = expenses)

            // 2. Spending by Category (D2)
            CategorySpendingSection(expenses = expenses)

            // 3. Recent Expenses List (D3)
            RecentExpensesSection(expenses = expenses)
        }
    }
}

// 1. Total Composable (D1)
@Composable
fun TotalDisplayCard(expenses: List<Expense>) {
    val totalAmount = expenses.sumOf { it.amount }
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "This Month's Total", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "$$totalAmount",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// 2. Category View Composable (D2)
@Composable
fun CategorySpendingSection(expenses: List<Expense>) {
    val categoryTotals = expenses.groupBy { it.category }.mapValues { entry -> entry.value.sumOf { it.amount } }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = "Spending by Category", style = MaterialTheme.typography.titleMedium)
            categoryTotals.forEach { (category, amount) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = category)
                    Text(text = "$$amount", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}

// 3. Recent Expenses List Composable (D3)
@Composable
fun RecentExpensesSection(expenses: List<Expense>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Recent Expenses", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(expenses) { expense ->
                ExpenseRow(expense = expense)
            }
        }
    }
}

// Reusable ExpenseRow Composable
@Composable
fun ExpenseRow(expense: Expense) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = expense.category, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = expense.date, style = MaterialTheme.typography.bodySmall)
            }
            Text(
                text = "${expense.currency}${expense.amount}",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
    }
}

// Previews
@Preview(showBackground = true)
@Composable
fun ExpenseRowPreview() {
    ExpenseRow(expense = Expense(1, 45.50, "$", "Food", "2026-10-01", "Lunch"))
}

@Preview(showBackground = true)
@Composable
fun DashboardPreview() {
    ExpenseDashboardScreen(expenses = sampleExpenses)
}
