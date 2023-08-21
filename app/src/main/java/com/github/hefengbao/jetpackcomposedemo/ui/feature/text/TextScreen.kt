package com.github.hefengbao.jetpackcomposedemo.ui.feature.text

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier.background(Color.White),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Hello World")
        Text(
            text = "Hello World",
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Hello World",
            color = Color.Blue,
            fontStyle = FontStyle.Italic,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 32.sp
        )
        Text(
            text = "可以点击的 Text",
            modifier = modifier.clickable {
                Toast.makeText(context,"点击了",Toast.LENGTH_SHORT).show()
            }
        )
        Text(
            text = "庙里有个老和尚和一个小和尚。有一天老和尚对小和尚说:“从前有座山.山里有座庙，庙里有个老和尚和一个小和尚，有一天老和尚对小和尚说：“从前有座山.山里有座庙，庙里有个老和尚和一个小和尚......““。",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(text = AnnotatedString("Hello World", spanStyle = SpanStyle(color = Color.Cyan)))
        ClickableTextSample(modifier = modifier)
    }
}

@Composable
fun ClickableTextSample(
    modifier: Modifier
) {
    val tag = "ClickableText"
    val text = buildAnnotatedString {
        append("请阅读并同意")
        pushStringAnnotation(tag = tag, annotation = "https://www.baidu.com")
        withStyle(style = SpanStyle(color = Color.Blue)){
            append("《服务条款》")
        }
        pop()
        append("和")
        pushStringAnnotation(tag,"https://www.bing.com")
        withStyle(style = SpanStyle(color = Color.Blue)){
            append("《隐私条款》")
        }
        pop()
    }

    val uriHandler = LocalUriHandler.current

    ClickableText(text = text, onClick = {index ->
        text.getStringAnnotations(tag, index, index).map {
            uriHandler.openUri(it.item)
        }
    })
}

@Preview
@Composable
private fun TextScreenPreview() {
    TextScreen()
}