package com.meta.capstoneproject.littlelemonapp.compsables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.meta.capstoneproject.littlelemonapp.MenuItemRoom
import com.meta.capstoneproject.littlelemonapp.R
import com.meta.capstoneproject.littlelemonapp.data.getSharedPrefString
import com.meta.capstoneproject.littlelemonapp.data.toObject
import com.meta.capstoneproject.littlelemonapp.ui.theme.LittleLemonColor


@Composable
fun DishSummary(navController: NavController) {
    DishSummaryPage(navController = navController)
}

@Composable
fun DishSummaryPage(navController: NavController) {

    val context = LocalContext.current
    val obj = context.getSharedPrefString("menuItem")
    val data = obj.toObject(MenuItemRoom::class.java)

    Surface(modifier = Modifier
        .fillMaxSize()
        .fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 16.dp, vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "Logo Image",
                    modifier = Modifier
                        .size(40.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(R.drawable.profile),
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(80.dp)
                        .clickable {
                            navController.navigate("Profile")
                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = LittleLemonColor.green)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                if (data != null) {
                    AsyncImage(
                        model = data.image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                } else {
                    AsyncImage(
                        model = "https://images.pexels.com/photos/1640777/pexels-photo-1640777.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "😋😋 " + (data?.title ?: "Yummy Dish") + " 😋😋",
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 21.sp
                )

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Category: " + if (!data?.category.isNullOrEmpty()) data?.category else "Indian Food",
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic,
                    fontSize = 16.sp
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data?.description ?: "About the yummy dish ❤️",
                    fontWeight = FontWeight.W300,
                    fontStyle = FontStyle.Normal,
                    fontSize = 14.sp,
                    modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "\uD83D\uDCB0 $ " + data?.price.toString() + " \uD83D\uDCB5",
                    fontWeight = FontWeight.W800,
                    fontStyle = FontStyle.Normal,
                    fontSize = 18.sp
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Isn't It Yummy? 🤗🤗",
                    fontWeight = FontWeight.W800,
                    fontStyle = FontStyle.Italic,
                    fontSize = 10.sp
                )
            }

        }

    }
}


@Preview(showBackground = true)
@Composable
fun DishSummaryPreview() {
    DishSummary(rememberNavController())
}
