@file:OptIn(ExperimentalMaterial3ExpressiveApi::class)

package com.sosauce.vanilla.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.SelectableDropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.sosauce.vanilla.R
import com.sosauce.vanilla.data.datastore.rememberDecimal
import com.sosauce.vanilla.data.datastore.rememberDecimalPrecision
import com.sosauce.vanilla.ui.screens.settings.components.SettingsInput
import com.sosauce.vanilla.ui.screens.settings.components.SettingsSwitch
import com.sosauce.vanilla.ui.screens.settings.components.SettingsWithTitle
import com.sosauce.vanilla.utils.formatNumber

@Composable
fun SettingsFormatting() {
    var shouldFormat by rememberDecimal()
    var decimalPrecision by rememberDecimalPrecision()

    Column {
        SettingsWithTitle(
            title = R.string.formatting
        ) {
            SettingsSwitch(
                checked = shouldFormat,
                onCheckedChange = { shouldFormat = !shouldFormat },
                topDp = 24.dp,
                bottomDp = 2.dp,
                text = R.string.decimal_formatting
            )
            SettingsInput(
                value = decimalPrecision,
                minValue = 0,
                maxValue = 100,
                onNewValue = { decimalPrecision = it },
                topDp = 2.dp,
                bottomDp = 24.dp,
                text = R.string.decimal_precision,
                optionalDescription = R.string.decimal_precision_desc
            )
        }
    }
}