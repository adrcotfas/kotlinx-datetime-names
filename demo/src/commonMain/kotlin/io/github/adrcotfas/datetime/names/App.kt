package io.github.adrcotfas.datetime.names

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

enum class DateTimeType {
    LOCAL_DATE_TIME,
    LOCAL_DATE,
    LOCAL_TIME,
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
        val localeOptions = remember { createLocaleOptions() }
        var selectedLocale by remember { mutableStateOf(localeOptions.first()) }
        var selectedDayOfWeekTextStyle by remember { mutableStateOf(TextStyle.FULL) }
        var selectedMonthTextStyle by remember { mutableStateOf(TextStyle.FULL) }

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
                        colors =
                            TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            ),
                    )

                    LocaleSelector(
                        selectedLocale = selectedLocale,
                        localeOptions = localeOptions,
                        onLocaleSelected = { selectedLocale = it },
                    )
                }
            },
        ) { paddingValues ->
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                // Platform info
                Card(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Running on: ${getPlatform().name}",
                            style = MaterialTheme.typography.titleMedium,
                        )
                    }
                }

                // DateTime Formatting Demo
                DateTimeFormattingSection(
                    selectedLocale = selectedLocale,
                    selectedDateTimeType = selectedDateTimeType,
                    onDateTimeTypeSelected = { selectedDateTimeType = it },
                    selectedFormatStyle = selectedFormatStyle,
                    onFormatStyleSelected = { selectedFormatStyle = it },
                    selectedDateFormatStyle = selectedDateFormatStyle,
                    onDateFormatStyleSelected = { selectedDateFormatStyle = it },
                    selectedTimeFormatStyle = selectedTimeFormatStyle,
                    onTimeFormatStyleSelected = { selectedTimeFormatStyle = it },
                )

                // Days of Week
                DayOfWeekSection(
                    selectedLocale = selectedLocale,
                    selectedTextStyle = selectedDayOfWeekTextStyle,
                    onTextStyleSelected = { selectedDayOfWeekTextStyle = it },
                )

                // Months
                MonthSection(
                    selectedLocale = selectedLocale,
                    selectedTextStyle = selectedMonthTextStyle,
                    onTextStyleSelected = { selectedMonthTextStyle = it },
                )
            }
        }
    }
}
