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
import kotlinx.datetime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

enum class DateTimeType {
    LOCAL_DATE_TIME,
    LOCAL_DATE,
    LOCAL_TIME
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalTime::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val localeOptions = remember { createLocaleOptions() }
        var selectedLocale by remember { mutableStateOf(localeOptions.first()) }
        var selectedTextStyle by remember { mutableStateOf(TextStyle.FULL) }

        // DateTime formatting demo states
        var selectedDateTimeType by remember { mutableStateOf(DateTimeType.LOCAL_DATE_TIME) }
        var selectedFormatStyle by remember { mutableStateOf(FormatStyle.MEDIUM) }
        var selectedDateFormatStyle by remember { mutableStateOf(FormatStyle.MEDIUM) }
        var selectedTimeFormatStyle by remember { mutableStateOf(FormatStyle.MEDIUM) }

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

                    // Locale chips pinned below toolbar
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

                // DateTime Formatting Demo
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "DateTime Formatting",
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                item {
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            // DateTime Type Selection
                            Text(
                                text = "Date/Time Type",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                DateTimeType.entries.forEach { type ->
                                    FilterChip(
                                        selected = selectedDateTimeType == type,
                                        onClick = { selectedDateTimeType = type },
                                        label = {
                                            Text(
                                                when (type) {
                                                    DateTimeType.LOCAL_DATE_TIME -> "LocalDateTime"
                                                    DateTimeType.LOCAL_DATE -> "LocalDate"
                                                    DateTimeType.LOCAL_TIME -> "LocalTime"
                                                }
                                            )
                                        }
                                    )
                                }
                            }

                            // Format Style Selection (conditional based on type)
                            when (selectedDateTimeType) {
                                DateTimeType.LOCAL_DATE_TIME -> {
                                    // Date Style
                                    Text(
                                        text = "Date Style",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .horizontalScroll(rememberScrollState()),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        FormatStyle.entries.forEach { style ->
                                            FilterChip(
                                                selected = selectedDateFormatStyle == style,
                                                onClick = { selectedDateFormatStyle = style },
                                                label = { Text(style.name) }
                                            )
                                        }
                                    }

                                    // Time Style
                                    Text(
                                        text = "Time Style",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .horizontalScroll(rememberScrollState()),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        FormatStyle.entries.forEach { style ->
                                            FilterChip(
                                                selected = selectedTimeFormatStyle == style,
                                                onClick = { selectedTimeFormatStyle = style },
                                                label = { Text(style.name) }
                                            )
                                        }
                                    }
                                }
                                DateTimeType.LOCAL_DATE, DateTimeType.LOCAL_TIME -> {
                                    Text(
                                        text = "Format Style",
                                        style = MaterialTheme.typography.labelMedium,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .horizontalScroll(rememberScrollState()),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        FormatStyle.entries.forEach { style ->
                                            FilterChip(
                                                selected = selectedFormatStyle == style,
                                                onClick = { selectedFormatStyle = style },
                                                label = { Text(style.name) }
                                            )
                                        }
                                    }
                                }
                            }

                            // Formatted result
                            HorizontalDivider()

                            val formattedResult = remember(
                                selectedDateTimeType,
                                selectedFormatStyle,
                                selectedDateFormatStyle,
                                selectedTimeFormatStyle,
                                selectedLocale
                            ) {
                                val now = Clock.System.now()
                                val timeZone = TimeZone.currentSystemDefault()
                                when (selectedDateTimeType) {
                                    DateTimeType.LOCAL_DATE_TIME -> {
                                        now.toLocalDateTime(timeZone).format(
                                            dateStyle = selectedDateFormatStyle,
                                            timeStyle = selectedTimeFormatStyle,
                                            locale = selectedLocale.locale,
                                            timeZone = timeZone
                                        )
                                    }
                                    DateTimeType.LOCAL_DATE -> {
                                        now.toLocalDateTime(timeZone).date.format(
                                            formatStyle = selectedFormatStyle,
                                            locale = selectedLocale.locale,
                                            timeZone = timeZone
                                        )
                                    }
                                    DateTimeType.LOCAL_TIME -> {
                                        now.toLocalDateTime(timeZone).time.format(
                                            formatStyle = selectedFormatStyle,
                                            locale = selectedLocale.locale
                                        )
                                    }
                                }
                            }

                            Text(
                                text = formattedResult,
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }

                // Text Style Selection
                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Text Style",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
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

                // Days of Week
                item {
                    Spacer(modifier = Modifier.height(8.dp))
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
