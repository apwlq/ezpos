import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.twotone.*
import androidx.compose.material.icons.sharp.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
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
        },
        bottomBar = {
            BottomNavigationBar(selectedTab, onTabSelected = { selectedTab = it })
        },
        content = { padding ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2), // 열의 개수 (2개)
                contentPadding = PaddingValues(8.dp), // 그리드 여백
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                items(12) { index -> // 6개의 아이템 생성
                    ProductBox(
                        productName = "제품 ${index + 1}",
                        productDescription = "제품 ${index + 1} 설명입니다.",
                        productPrice = "${(index + 1) * 10}원",
                        onClick = { /* 클릭 시 동작 */ }
                    )
                }
            }
        }
    )
}

@Composable
fun ProductBox(productName: String, productDescription: String, productPrice: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
            .fillMaxWidth() // 너비를 가득 채우도록 수정
            .height(150.dp) // 박스 높이
            .background(Color.LightGray), // 배경색
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = productName, style = MaterialTheme.typography.h6)
            Text(text = productDescription, style = MaterialTheme.typography.body2)
            Text(text = productPrice, style = MaterialTheme.typography.h6)
        }
    }
}

@Composable
fun BottomNavigationBar(selectedTab: Int, onTabSelected: (Int) -> Unit) {
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

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "이지 포스기",
        state = WindowState(size = DpSize(480.dp, 800.dp)),
        resizable = false
    ) {
        App()
    }
}
