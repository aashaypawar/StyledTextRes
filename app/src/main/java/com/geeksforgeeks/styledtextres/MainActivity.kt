package com.geeksforgeeks.styledtextres

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Styled Text from Resources", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        // Displaying the string using regular text function
                        Text(textResource(id = R.string.foo).toString())

                        // Adding a space of height 100dp
                        Spacer(Modifier.height(100.dp))

                        // Displaying the string using the custom function
                        StyledText(textResource(id = R.string.foo))
                    }
                }
            )
        }
    }

    // Creating a function to get string id
    @Composable
    @ReadOnlyComposable
    fun textResource(@StringRes id: Int): CharSequence =
        LocalContext.current.resources.getText(id)

    // Creating a function to display the styled text
    @Composable
    fun StyledText(text: CharSequence, modifier: Modifier = Modifier) {
        AndroidView(
            modifier = modifier,
            factory = { context -> TextView(context) },
            update = {
                it.text = text
            }
        )
    }
}
