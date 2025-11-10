package io.github.adrcotfas.datetime.names

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.datetime.Month

@Composable
fun MonthSection(
    selectedLocale: LocaleOption,
    selectedTextStyle: TextStyle,
    onTextStyleSelected: (TextStyle) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Months",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.primary
        )

        TextStyleSelector(
            selectedTextStyle = selectedTextStyle,
            onTextStyleSelected = onTextStyleSelected
        )

        Month.entries.forEach { month ->
            NameCard(
                label = month.name,
                displayName = month.getDisplayName(selectedTextStyle, selectedLocale.locale)
            )
        }
    }
}
