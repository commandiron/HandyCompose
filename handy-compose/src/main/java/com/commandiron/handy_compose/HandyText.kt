package com.commandiron.handy_compose

import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit

@Composable
fun HandyText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontStyle: FontStyle? = null,
    fontWeight: FontWeight? = null,
    fontFamily: FontFamily? = null,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null,
    textAlign: TextAlign? = null,
    lineHeight: TextUnit = TextUnit.Unspecified,
    overflow: TextOverflow? = null,
    softWrap: Boolean = true,
    maxLines: Int = Int.MAX_VALUE,
    onTextLayout: (TextLayoutResult) -> Unit = {},
    style: TextStyle = LocalTextStyle.current,
    maxShrunkTextStyle: TextStyle = MaterialTheme.typography.labelSmall,
) {
    val readyToDraw = remember { mutableStateOf(false) }
    val textHasVisualOverflow = remember { mutableStateOf(false) }
    val baseTextStyle = remember { mutableStateOf(style) }
    val baseTextAlign = remember { mutableStateOf(TextAlign.Center) }

    if(textHasVisualOverflow.value) {
        baseTextStyle.value = shrinkTextStyle(baseTextStyle.value)
        if(baseTextStyle.value == maxShrunkTextStyle){
            baseTextAlign.value = TextAlign.Start
            readyToDraw.value = true
        }
    }

    Text(
        text,
        modifier = modifier
            .drawWithContent {
                if (readyToDraw.value) drawContent()
            },
        color,
        fontSize,
        fontStyle,
        fontWeight,
        fontFamily,
        letterSpacing,
        textDecoration,
        textAlign = textAlign ?: baseTextAlign.value,
        lineHeight,
        overflow = overflow ?: TextOverflow.Ellipsis,
        softWrap,
        maxLines,
        onTextLayout = { textLayoutResult ->
            textHasVisualOverflow.value = textLayoutResult.hasVisualOverflow
            if(!textLayoutResult.hasVisualOverflow){
                readyToDraw.value = true
            }
            onTextLayout(textLayoutResult)
        },
        style = baseTextStyle.value,
    )
}

@Composable
internal fun shrinkTextStyle(textStyle: TextStyle): TextStyle {
    val listIndex = remember { mutableStateOf(14)}
    val textStyleList = listOf(
        MaterialTheme.typography.displayLarge,
        MaterialTheme.typography.displayMedium,
        MaterialTheme.typography.displaySmall,
        MaterialTheme.typography.headlineLarge,
        MaterialTheme.typography.headlineMedium,
        MaterialTheme.typography.headlineSmall,
        MaterialTheme.typography.titleLarge,
        MaterialTheme.typography.titleMedium,
        MaterialTheme.typography.titleSmall,
        MaterialTheme.typography.bodyLarge,
        MaterialTheme.typography.bodyMedium,
        MaterialTheme.typography.bodySmall,
        MaterialTheme.typography.labelLarge,
        MaterialTheme.typography.labelMedium,
        MaterialTheme.typography.labelSmall
    )
    textStyleList.forEachIndexed { index, textStyleInList ->
        if(textStyle == textStyleInList){
            if(index < 14){
                listIndex.value = index + 1
            }

        }
    }
    return textStyleList[listIndex.value]
}