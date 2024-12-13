package com.example.moocows_food_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moocows_food_app.ui.theme.Moocows_food_appTheme

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen(

            )
        }
    }
}

@Composable
@Preview
fun MainScreen(

) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        bottomBar = {
            MyBottomBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                contentColor = Color.White,
                backgroundColor = colorResource(id=R.color.orange)
            ) {
                Icon(
                    painter = painterResource(id=R.drawable.shopping_cart),
                    contentDescription = "add",
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
            }
        },
        scaffoldState = scaffoldState,
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        content = {paddingValues ->

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues = paddingValues)
            ) {  }
        }
    )
}

@Composable
fun MyBottomBar() {
    val bottomMenuItemList=prepareBottomMenu()
    val contextForToast = LocalContext.current.applicationContext
    var selectedItem by remember {
        mutableStateOf("Home")
    }

    BottomAppBar(
        cutoutShape = CircleShape,
        backgroundColor = Color(android.graphics.Color.parseColor("#f8f8f8")),
        elevation = 3.dp
    ) {
        bottomMenuItemList.forEachIndexed{index, bottomMenuItem ->
            if (index == 2) {
                BottomNavigationItem(
                    selected = false,
                    onClick = {},
                    icon={},
                    enabled = false
                )
            }
            BottomNavigationItem(
                selected = (selectedItem == bottomMenuItem.label),
                onClick = {
                    selectedItem = bottomMenuItem.label
                    Toast.makeText(contextForToast, bottomMenuItem.label, Toast.LENGTH_SHORT).show()
                },
                icon = {
                    Icon(
                        painter = bottomMenuItem.icon,
                        contentDescription = bottomMenuItem.label,
                        modifier = Modifier
                            .height(20.dp)
                            .width(20.dp)
                    )

                },
                label = {
                    Text(
                        text = bottomMenuItem.label,
                        modifier = Modifier.padding(top=14.dp)

                    )
                },
                alwaysShowLabel = true,
                enabled = true
            )
        }
    }
}

data class BottomMenuItem(
    val label: String, val icon: Painter
)

@Composable
fun prepareBottomMenu(): List<BottomMenuItem> {
    val bottomMenuItemList = arrayListOf<BottomMenuItem>()

    bottomMenuItemList.add(
        BottomMenuItem(
            label = "Home",
            icon = painterResource(id=R.drawable.bottom_btn1)
        )
    )
    bottomMenuItemList.add(
        BottomMenuItem(
            label = "Profile",
            icon = painterResource(id=R.drawable.bottom_btn2)
        )
    )
    bottomMenuItemList.add(
        BottomMenuItem(
            label = "Support",
            icon = painterResource(id=R.drawable.bottom_btn3)
        )
    )
    bottomMenuItemList.add(
        BottomMenuItem(
            label = "Settings",
            icon = painterResource(id=R.drawable.bottom_btn4)
        )
    )

    return bottomMenuItemList
}
