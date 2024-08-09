package com.example.compose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TabView() {
    val tabs = listOf(
        TabItem("Episodes", Icons.Default.Favorite),
        TabItem("Trailers", Icons.Default.PlayArrow)
    )

    var selectedTabIndex by remember {
        mutableStateOf(0)
    }

    Column {

        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.Black,
            contentColor = Color.Gray,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    color = Color.Red,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex])
                        .fillMaxWidth()
                )
            },
            tabs = {
                tabs.forEachIndexed { index, tabItem ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        modifier = Modifier
                            .height(100.dp)
                            .padding(8.dp),
                        icon = {
                            Icon(
                                imageVector = tabItem.icon,
                                contentDescription = tabItem.title,
                                tint = if (selectedTabIndex == index) Color.White else Color.Gray
                            )
                        },
                        text = {
                            Text(
                                text = tabItem.title,
                                color = if (selectedTabIndex == index) Color.White else Color.Gray
                            )
                        }
                    )
                }
            }
        )

        when (selectedTabIndex) {
            0 -> {
                EpisodeList()
            }

            1 -> {
                Text(text = "Tab Second")
            }
        }
    }
}

data class TabItem(val title: String, val icon: ImageVector)

@Composable
fun EpisodeList() {
    val episodes = listOf(
        "Episode 1",
        "Episode 2",
        "Episode 3",
        "Episode 4",
        "Episode 5",
        "Episode 6",
        "Episode 7",
        "Episode 8",
        "Episode 9",
        "Episode 10",
        "Episode 11",
        "Episode 12",
        "Episode 13",
    )

    val context = LocalContext.current
    val density = LocalDensity.current.density

    val displayMetrics = context.resources.displayMetrics
    val screenHeightPx = displayMetrics.heightPixels.toFloat()
    val screenHeightDp = screenHeightPx.div(density)

    LazyColumn(modifier = Modifier.height(screenHeightDp.dp - 100.dp)) {
        items(episodes.size) { index ->
            Text(
                text = episodes[index], modifier = Modifier
                    .padding(30.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewTab() {
    TabView()
}
