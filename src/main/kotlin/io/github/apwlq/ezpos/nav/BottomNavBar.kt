package io.github.apwlq.ezpos

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class BottomNavBar {
    @Composable
    fun BottomNavBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
        BottomNavigation(backgroundColor = Color.Black) {
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Home, contentDescription = null, tint = Color.White) },
                label = { Text("Home", color = Color.White) },
                selected = selectedTab == 0,
                onClick = { onTabSelected(0) }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.White) },
                label = { Text("Search", color = Color.White) },
                selected = selectedTab == 1,
                onClick = { onTabSelected(1) }
            )
            BottomNavigationItem(
                icon = { Icon(Icons.Default.Settings, contentDescription = null, tint = Color.White) },
                label = { Text("Settings", color = Color.White) },
                selected = selectedTab == 2,
                onClick = { onTabSelected(2) }
            )
        }
    }
}