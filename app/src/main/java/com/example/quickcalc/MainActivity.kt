package com.example.quickcalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quickcalc.ui.theme.QuickCalcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickCalcTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen(viewModel: MainViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        // App Title
        Text(
            text = "QuickCalc",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.6f),
            fontWeight = FontWeight.Medium
        )

        // Display Screen Area (Top 36%)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 12.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Expression Row (with horizontal auto-scroll)
                val scrollState = rememberScrollState()
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = if (viewModel.expression.isEmpty()) "0" else viewModel.expression,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Light,
                        color = if (viewModel.expression.isEmpty()) {
                            MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f)
                        } else {
                            MaterialTheme.colorScheme.onSurface
                        },
                        textAlign = TextAlign.End,
                        maxLines = 1
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                // Live Result Preview
                Text(
                    text = when {
                        viewModel.isError -> viewModel.resultPreview
                        viewModel.resultPreview.isNotEmpty() -> "= ${viewModel.resultPreview}"
                        else -> ""
                    },
                    fontSize = 32.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (viewModel.isError) {
                        MaterialTheme.colorScheme.error
                    } else {
                        MaterialTheme.colorScheme.primary
                    },
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
            }
        }

        Divider(
            color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f),
            thickness = 0.5.dp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 5x4 Keypad Grid (Bottom 64%)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.8f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Row 1: AC, (), %, ÷
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalcButton(
                    text = "AC",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer,
                    onClick = { viewModel.clearAll() }
                )
                CalcButton(
                    text = "( )",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.primary,
                    onClick = { viewModel.onParentheses() }
                )
                CalcButton(
                    text = "%",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.primary,
                    onClick = { viewModel.onPercentage() }
                )
                CalcButton(
                    text = "÷",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = { viewModel.onOperator("÷") }
                )
            }

            // Row 2: 7, 8, 9, ×
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalcButton(text = "7", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("7") })
                CalcButton(text = "8", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("8") })
                CalcButton(text = "9", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("9") })
                CalcButton(
                    text = "×",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = { viewModel.onOperator("×") }
                )
            }

            // Row 3: 4, 5, 6, −
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalcButton(text = "4", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("4") })
                CalcButton(text = "5", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("5") })
                CalcButton(text = "6", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("6") })
                CalcButton(
                    text = "−",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = { viewModel.onOperator("−") }
                )
            }

            // Row 4: 1, 2, 3, +
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalcButton(text = "1", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("1") })
                CalcButton(text = "2", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("2") })
                CalcButton(text = "3", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("3") })
                CalcButton(
                    text = "+",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                    onClick = { viewModel.onOperator("+") }
                )
            }

            // Row 5: 0, ., ⌫, =
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CalcButton(text = "0", modifier = Modifier.weight(1f), onClick = { viewModel.onDigit("0") })
                CalcButton(text = ".", modifier = Modifier.weight(1f), onClick = { viewModel.onDecimal() })
                CalcButton(
                    text = "⌫",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    contentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    onClick = { viewModel.onDelete() }
                )
                CalcButton(
                    text = "=",
                    modifier = Modifier.weight(1f),
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    onClick = { viewModel.onEquals() }
                )
            }
        }
    }
}

@Composable
fun CalcButton(
    text: String,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxHeight(),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 2.dp
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            fontSize = if (text.length > 2) 20.sp else 24.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
