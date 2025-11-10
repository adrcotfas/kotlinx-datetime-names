package io.github.adrcotfas.datetime.names

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.datetime.DayOfWeek

@Composable
fun DayOfWeekSection(
    selectedLocale: LocaleOption,
    selectedTextStyle: TextStyle,
    onTextStyleSelected: (TextStyle) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Text(
            text = "Days of Week",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary,
        )

        TextStyleSelector(
            selectedTextStyle = selectedTextStyle,
            onTextStyleSelected = onTextStyleSelected,
        )

        DayOfWeek.entries.forEach { dayOfWeek ->
            NameCard(
                label = dayOfWeek.name,
                displayName = dayOfWeek.getDisplayName(selectedTextStyle, selectedLocale.locale),
            )
        }
    }
}
