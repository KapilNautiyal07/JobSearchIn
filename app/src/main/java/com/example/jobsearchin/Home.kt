package com.example.jobsearchin
import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {


        Column (modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)){
            Row(modifier = Modifier.padding(top = 4.dp, start = 0.dp, end = 0.dp)) { // Adjust padding as needed
                val imageModifier = Modifier
                    .size(25.dp)
                Box( // Wrap image in clickable Box
                    modifier = Modifier.clickable {
                        navigateToNewScreen()
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.navigation),
                        contentDescription = null,
                        modifier = imageModifier
                    )
                }
                Text(
                    text = "Delhi",
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.clickable {
                        navigateToNewScreen()
                    }
                )

                // Place buttons in a separate Row parallel to the first Row
                Spacer(modifier = Modifier.weight(1.0f)) // Spacer for horizontal alignment
                Button(
                    onClick = { onClick() },
                    modifier = Modifier.size(30.dp, 30.dp), // Adjust size as needed
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFA7832)) // Light orange
                ) {
                    Icon(imageVector = Icons.Default.Share, contentDescription = "share")
                    Text(" Refer")
                }
                Spacer(modifier = Modifier.weight(0.5f)) // Adjust spacer size for button spacing
                Button(
                    onClick = { onClick() },
                    modifier = Modifier.size(30.dp, 30.dp), // Adjust size as needed
                    shape = CircleShape, // Use small Material shape for circle
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFA7832))
                ) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = "notification")
                }
            }
            Text(text = "Sector 62 A - Noida", modifier = Modifier.padding(top = 1.dp))

            // Search Bar below upper content
            var text by remember { mutableStateOf("") }
            var active by remember { mutableStateOf(false) }

            Box( // Adjust background box size and padding as needed
                modifier = Modifier
                    .fillMaxWidth()
                    .absolutePadding(left = 16.dp, right = 16.dp, top = 8.dp, bottom = 8.dp)
                    .background(Color(0xFFFA7832)) // Light orange color

                    .padding(top = 30.dp, bottom = 13.dp)
            ) {
                SearchBar(
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = { active = false },
                    active = active,
                    onActiveChange = { active = it },
                    placeholder = {
                        Text(text = "Search for Titles")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
                    },
                    trailingIcon = {
                        Icon(imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Arrow Icon")
                    },
                    modifier = Modifier // Apply modifiers to SearchBar here
                        .fillMaxWidth(0.8f) // Reduce width to 80% of parent
                        .align(Alignment.Center) // Align horizontally to center
                ) {

                }
            }





            Column(modifier = Modifier.verticalScroll(rememberScrollState())){


            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .border(border = BorderStroke(0.5.dp, Color.LightGray))
            ) {
                Text(
                    text = "Quick Filters",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 12.dp, top = 17.dp)
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly

                    ) {
                        // Repeat this Card code three times
                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(140.dp)
                                .padding(top = 60.dp, start = 8.dp),
                            shape = RoundedCornerShape(5.dp),
                            elevation = CardDefaults.cardElevation(10.dp)
                        ) {
                            Box(modifier = Modifier.height(200.dp)) {
                                Column {
                                    Text(text = "Jobs for you", fontSize = 30.sp)
                                }
                            }
                        }

                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(140.dp)
                                .padding(top = 60.dp, start = 8.dp),
                            shape = RoundedCornerShape(5.dp),
                            elevation = CardDefaults.cardElevation(10.dp)
                        ) {
                            Box(modifier = Modifier.height(200.dp)) {
                                Column {
                                    Text(text = "Jobs for you", fontSize = 30.sp)
                                }
                            }
                        }

                        Card(
                            modifier = Modifier
                                .width(120.dp)
                                .height(140.dp)
                                .padding(top = 60.dp, start = 8.dp),
                            shape = RoundedCornerShape(5.dp),
                            elevation = CardDefaults.cardElevation(10.dp)
                        ) {
                            Box(modifier = Modifier.height(200.dp)) {
                                Column {
                                    Text(text = "Jobs for you", fontSize = 30.sp)
                                }
                            }
                        }

                    }


                    Spacer(
                        modifier = Modifier.padding(top = 20.dp)
                    )

                    Column(modifier = Modifier.padding(start = 12.dp)) {
                        Row {
                            Text(
                                text = "Apply to these jobs",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black
                            )

                            OutlinedButton(
                                onClick = { /*TODO*/ },
                                modifier = Modifier.size(width = 80.dp, height = 30.dp)
                            ) {
                                Text(text = "View All")
                            }
                        }


                        Text(text = "Top 5 jobs that match your profile")


                    }




                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFDAE1E7),
                        modifier = Modifier
                            .height(186.dp)
                            .padding(15.dp),
                        shadowElevation = 10.dp
                    ) {


                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(2f),
                                verticalArrangement = Arrangement.Center
                            ) {


                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 40.dp, height = 40.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.buildimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Office Maid",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = " NB ASSOCIATES ADVOCATES AND SOLICITORS",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.cashimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " ₹ 10000 - ₹ 12,000 / month",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }




                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.locationdrop),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Vaishali - Ghaziabad - 2.6km",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }





                                Spacer(modifier = Modifier.height(8.dp))

                                Row {


                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFAF9F7)
                                    ) {
                                        Text(
                                            text = "Fresher",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFCFCFC)
                                    ) {
                                        Text(
                                            text = "Full-Time",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                }
                            }


                        }
                    }









                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFDAE1E7),
                        modifier = Modifier
                            .height(186.dp)
                            .padding(15.dp),
                        shadowElevation = 10.dp
                    ) {


                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(2f),
                                verticalArrangement = Arrangement.Center
                            ) {


                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 40.dp, height = 40.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.buildimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Office Maid",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = " NB ASSOCIATES ADVOCATES AND SOLICITORS",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.cashimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " ₹ 10000 - ₹ 12,000 / month",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }




                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.locationdrop),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Vaishali - Ghaziabad - 2.6km",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }





                                Spacer(modifier = Modifier.height(8.dp))

                                Row {


                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFAF9F7)
                                    ) {
                                        Text(
                                            text = "Fresher",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFCFCFC)
                                    ) {
                                        Text(
                                            text = "Full-Time",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                }
                            }


                        }
                    }
















                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFDAE1E7),
                        modifier = Modifier
                            .height(186.dp)
                            .padding(15.dp),
                        shadowElevation = 10.dp
                    ) {


                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(2f),
                                verticalArrangement = Arrangement.Center
                            ) {


                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 40.dp, height = 40.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.buildimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Office Maid",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = " NB ASSOCIATES ADVOCATES AND SOLICITORS",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.cashimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " ₹ 10000 - ₹ 12,000 / month",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }




                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.locationdrop),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Vaishali - Ghaziabad - 2.6km",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }





                                Spacer(modifier = Modifier.height(8.dp))

                                Row {


                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFAF9F7)
                                    ) {
                                        Text(
                                            text = "Fresher",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFCFCFC)
                                    ) {
                                        Text(
                                            text = "Full-Time",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                }
                            }


                        }
                    }




















                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFDAE1E7),
                        modifier = Modifier
                            .height(186.dp)
                            .padding(15.dp),
                        shadowElevation = 10.dp
                    ) {


                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(2f),
                                verticalArrangement = Arrangement.Center
                            ) {


                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 40.dp, height = 40.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.buildimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Office Maid",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = " NB ASSOCIATES ADVOCATES AND SOLICITORS",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.cashimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " ₹ 10000 - ₹ 12,000 / month",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }




                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.locationdrop),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Vaishali - Ghaziabad - 2.6km",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }





                                Spacer(modifier = Modifier.height(8.dp))

                                Row {


                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFAF9F7)
                                    ) {
                                        Text(
                                            text = "Fresher",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFCFCFC)
                                    ) {
                                        Text(
                                            text = "Full-Time",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                }
                            }


                        }
                    }










                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = Color(0xFFDAE1E7),
                        modifier = Modifier
                            .height(186.dp)
                            .padding(15.dp),
                        shadowElevation = 10.dp
                    ) {


                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(2f),
                                verticalArrangement = Arrangement.Center
                            ) {


                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 40.dp, height = 40.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.buildimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Office Maid",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Text(
                                                text = " NB ASSOCIATES ADVOCATES AND SOLICITORS",
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }

                                Spacer(modifier = Modifier.height(4.dp))

                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.cashimg),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " ₹ 10000 - ₹ 12,000 / month",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }




                                Column {
                                    Row {
                                        Surface(
                                            shape = RoundedCornerShape(16.dp),
                                            modifier = Modifier.size(width = 20.dp, height = 20.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.locationdrop),
                                                contentScale = ContentScale.Crop,
                                                contentDescription = null
                                            )
                                        }

                                        Column {
                                            Text(
                                                text = " Vaishali - Ghaziabad - 2.6km",
                                                fontSize = 17.sp,
                                                fontWeight = FontWeight.Bold
                                            )

                                        }
                                    }
                                }





                                Spacer(modifier = Modifier.height(8.dp))

                                Row {


                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFAF9F7)
                                    ) {
                                        Text(
                                            text = "Fresher",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                    Spacer(modifier = Modifier.padding(5.dp))
                                    Surface(
                                        shape = RoundedCornerShape(24.dp),
                                        modifier = Modifier.wrapContentSize(),
                                        color = Color(0xFFFCFCFC)
                                    ) {
                                        Text(
                                            text = "Full-Time",
                                            fontSize = 12.sp,
                                            style = MaterialTheme.typography.titleLarge,
                                            modifier = Modifier.padding(
                                                vertical = 4.dp,
                                                horizontal = 8.dp
                                            )
                                        )
                                    }
                                }
                            }


                        }

                    }

                    //yahan pr lala
                }

                    
            }





        }
    }


}

// Define click handler functions
fun navigateToNewScreen() {
    // Implementation for navigating to a new screen (or any desired action)
}

fun onClick() {
    // Implementation for button click action
}

// No changes required in SearchBar composable