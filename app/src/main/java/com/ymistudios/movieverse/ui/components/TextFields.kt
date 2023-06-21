@file:OptIn(ExperimentalMaterial3Api::class)

package com.ymistudios.movieverse.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ymistudios.movieverse.ui.theme.MoviesVerseTheme

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    error: String? = null,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = MoviesVerseTheme.typography.textField.copy(color = MoviesVerseTheme.colors.text),
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(15.dp),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedBorderColor = MoviesVerseTheme.colors.border,
        focusedBorderColor = MoviesVerseTheme.colors.primary
    )
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        placeholder = {
            Text(
                text = placeholder,
                style = MoviesVerseTheme.typography.textFieldHint,
                color = MoviesVerseTheme.colors.hint
            )
        },
        leadingIcon = leadingIcon?.let {
            @Composable {
                Decoration(contentColor = MoviesVerseTheme.colors.icon) {
                    Row {
                        Spacer(modifier = Modifier.width(14.dp))
                        leadingIcon()
                    }
                }
            }
        },
        trailingIcon = trailingIcon?.let {
            @Composable {
                Decoration(contentColor = MoviesVerseTheme.colors.icon) {
                    Row {
                        trailingIcon()
                        Spacer(modifier = Modifier.width(14.dp))
                    }
                }
            }
        },
        isError = error != null,
        supportingText = error?.let {
            {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    style = MoviesVerseTheme.typography.textFieldError
                )
            }
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        shape = shape,
        colors = colors
    )
}

@Composable
fun Decoration(
    contentColor: Color,
    content: @Composable () -> Unit
) {
    val contentWithColor: @Composable () -> Unit = @Composable {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            content = content
        )
    }
    contentWithColor()
}
