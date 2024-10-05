package io.github.apwlq.ezpos

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class TopNavBar {
    fun TopNavBar() {
        TopAppBar(
            title = { Text("이지 포스기", fontSize = 20.sp, color = Color.White) },
            backgroundColor = Color.Gray,
            actions = {
                IconButton(onClick = { /* 설정 클릭 시 동작 */
                    println("Settings clicked")
                }) {
                    Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.White)
                }
            }
        )
    }
}