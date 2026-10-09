package com.example.lab3_a2_po_phearun

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.lab3_a2_po_phearun.ui.theme.Lab3A2PO_PHEARUNTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "ExpenseTrackerApp"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")

        enableEdgeToEdge()

        setContent {
            Lab3A2PO_PHEARUNTheme {
                ExpenseDashboardScreen(expenses = sampleExpenses)
            }
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}