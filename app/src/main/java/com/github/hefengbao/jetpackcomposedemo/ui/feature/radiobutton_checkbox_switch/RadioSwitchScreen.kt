package com.github.hefengbao.jetpackcomposedemo.ui.feature.radiobutton_checkbox_switch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RadioButtonCheckBoxSwitchScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val radioList = listOf<String>("苹果", "芒果", "结果")
        var radioSelected: Int? by remember { mutableStateOf(null) }
        val radioSelectedText = if (radioSelected != null) {
            "(${radioList[radioSelected!!]})"
        } else {
            "()"
        }

        Text(text = "那个不是水果？${radioSelectedText}")

        radioList.forEachIndexed { index, item ->
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .clickable { radioSelected = index },
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(selected = index == radioSelected, onClick = { radioSelected = index })
                Text(text = item)
            }
        }

        var checkboxChecked by remember { mutableStateOf(false) }

        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = checkboxChecked, onCheckedChange = { checkboxChecked = it })
            Text(text = "请阅读并同意《服务协议》")
        }

        var switchChecked by remember { mutableStateOf(false) }
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "开启消息通知")
            Switch(checked = switchChecked, onCheckedChange = { switchChecked = it })
        }
    }
}

@Preview
@Composable
private fun RadioButtonCheckBoxSwitchScreenPreview() {
    RadioButtonCheckBoxSwitchScreen()
}

