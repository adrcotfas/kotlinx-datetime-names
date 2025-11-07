package io.github.adrcotfas.datetime.names

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.datetime.DayOfWeek
import kotlinx.datetime.Month
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val localeOptions = remember { createLocaleOptions() }
        var selectedLocale by remember { mutableStateOf(localeOptions.first()) }
        var selectedTextStyle by remember { mutableStateOf(TextStyle.FULL) }

        Scaffold(
            topBar = {
                Column {
                    TopAppBar(
                        title = { Text("kotlinx-datetime-names") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )

                    // Chip groups pinned below toolbar
                    Surface(
                        color = MaterialTheme.colorScheme.surface,
                        tonalElevation = 3.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 12.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            // Locale chips
                            Text(
                                text = "Locale",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                localeOptions.forEach { localeOption ->
                                    FilterChip(
                                        selected = selectedLocale == localeOption,
                                        onClick = { selectedLocale = localeOption },
                                        label = { Text(localeOption.displayName) }
                                    )
                                }
                            }

                            // Text Style chips
                            Text(
                                text = "Text Style",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                TextStyle.entries.forEach { style ->
                                    FilterChip(
                                        selected = selectedTextStyle == style,
                                        onClick = { selectedTextStyle = style },
                                        label = { Text(style.name) }
                                    )
                                }
                            }
                        }
                    }
                }
            }
        ) { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Platform info
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "Running on: ${getPlatform().name}",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
                }

                // Days of Week
                item {
                    Text(
                        text = "Days of Week",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                items(DayOfWeek.entries) { dayOfWeek ->
                    NameCard(
                        label = dayOfWeek.name,
                        displayName = dayOfWeek.getDisplayName(selectedTextStyle, selectedLocale.locale)
                    )
                }

                // Months
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Months",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                items(Month.entries) { month ->
                    NameCard(
                        label = month.name,
                        displayName = month.getDisplayName(selectedTextStyle, selectedLocale.locale)
                    )
                }
            }
        }
    }
}

@Composable
fun NameCard(
    label: String,
    displayName: String
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = displayName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
