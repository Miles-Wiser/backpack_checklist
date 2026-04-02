package com.example.backpack_checklist

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.backpack_checklist.ui.theme.Backpack_checklistTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Backpack_checklistTheme() {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Checklist(SampleList.checklistSample)
                }
            }
        }
    }
}

data class ListEntry(val name: String, val qty: Int)

@Composable
fun EntryComponent(entry: ListEntry) {
    Surface(shape = MaterialTheme.shapes.medium,
        shadowElevation = 1.dp,
        modifier = Modifier.padding(5.dp)
    ) {
        Row(modifier = Modifier.padding(all = 10.dp)) {
            Text(
                text = entry.name,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Qty: ${entry.qty}",
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun Checklist(entries: List<ListEntry>) {
    LazyColumn() {
        items(entries) { entry ->
            EntryComponent(entry)
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)

@Preview
@Composable
fun PreviewEntryComponent() {
    Backpack_checklistTheme() {
        Surface() {
            EntryComponent(
                entry = ListEntry("Preview", 7)
            )
        }
    }
}

@Preview
@Composable
fun PreviewChecklist() {
    Backpack_checklistTheme() {
        Checklist(SampleList.checklistSample)
    }
}