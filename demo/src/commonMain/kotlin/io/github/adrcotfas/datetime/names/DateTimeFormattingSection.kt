package io.github.adrcotfas.datetime.names

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.delay
import kotlinx.datetime.*

@OptIn(ExperimentalTime::class)
@Composable
fun DateTimeFormattingSection(
    selectedLocale: LocaleOption,
    selectedDateTimeType: DateTimeType,
    onDateTimeTypeSelected: (DateTimeType) -> Unit,
    selectedFormatStyle: FormatStyle,
    onFormatStyleSelected: (FormatStyle) -> Unit,
    selectedDateFormatStyle: FormatStyle,
    onDateFormatStyleSelected: (FormatStyle) -> Unit,
    selectedTimeFormatStyle: FormatStyle,
    onTimeFormatStyleSelected: (FormatStyle) -> Unit,
    modifier: Modifier = Modifier,
) {
    var currentTime by remember { mutableStateOf(Clock.System.now()) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            currentTime = Clock.System.now()
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "DateTime Formatting",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                // DateTime Type Selection
                Text(
                    text = "Date/Time Type",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    DateTimeType.entries.forEach { type ->
                        FilterChip(
                            selected = selectedDateTimeType == type,
                            onClick = { onDateTimeTypeSelected(type) },
                            label = {
                                Text(
                                    when (type) {
                                        DateTimeType.LOCAL_DATE_TIME -> "LocalDateTime"
                                        DateTimeType.LOCAL_DATE -> "LocalDate"
                                        DateTimeType.LOCAL_TIME -> "LocalTime"
                                    },
                                )
                            },
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
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            FormatStyle.entries.forEach { style ->
                                FilterChip(
                                    selected = selectedDateFormatStyle == style,
                                    onClick = { onDateFormatStyleSelected(style) },
                                    label = { Text(style.name) },
                                )
                            }
                        }

                        // Time Style
                        Text(
                            text = "Time Style",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            FormatStyle.entries.forEach { style ->
                                FilterChip(
                                    selected = selectedTimeFormatStyle == style,
                                    onClick = { onTimeFormatStyleSelected(style) },
                                    label = { Text(style.name) },
                                )
                            }
                        }
                    }
                    DateTimeType.LOCAL_DATE, DateTimeType.LOCAL_TIME -> {
                        Text(
                            text = "Format Style",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Row(
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                        ) {
                            FormatStyle.entries.forEach { style ->
                                FilterChip(
                                    selected = selectedFormatStyle == style,
                                    onClick = { onFormatStyleSelected(style) },
                                    label = { Text(style.name) },
                                )
                            }
                        }
                    }
                }

                // Formatted result
                HorizontalDivider()

                val formattedResult =
                    remember(
                        currentTime,
                        selectedDateTimeType,
                        selectedFormatStyle,
                        selectedDateFormatStyle,
                        selectedTimeFormatStyle,
                        selectedLocale,
                    ) {
                        val timeZone = TimeZone.currentSystemDefault()
                        when (selectedDateTimeType) {
                            DateTimeType.LOCAL_DATE_TIME -> {
                                currentTime.toLocalDateTime(timeZone).format(
                                    dateStyle = selectedDateFormatStyle,
                                    timeStyle = selectedTimeFormatStyle,
                                    locale = selectedLocale.locale,
                                    timeZone = timeZone,
                                )
                            }
                            DateTimeType.LOCAL_DATE -> {
                                currentTime.toLocalDateTime(timeZone).date.format(
                                    formatStyle = selectedFormatStyle,
                                    locale = selectedLocale.locale,
                                    timeZone = timeZone,
                                )
                            }
                            DateTimeType.LOCAL_TIME -> {
                                currentTime.toLocalDateTime(timeZone).time.format(
                                    formatStyle = selectedFormatStyle,
                                    locale = selectedLocale.locale,
                                )
                            }
                        }
                    }

                Text(
                    text = formattedResult,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}
