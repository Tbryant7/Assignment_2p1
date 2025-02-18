package com.example.assignment2p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieCard(
                title = "Good Will Hunting",
                length = "2:06",
                language = "English",
                rating = "8.3",
                reviews = "45+"
            )
        }
    }
}
@Composable
fun MovieCard(title: String, length: String, language: String, rating: String, reviews: String) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Poster()
            Spacer(modifier = Modifier.height(8.dp))
            Title(title)
            Spacer(modifier = Modifier.height(4.dp))
            Rating()
            Spacer(modifier = Modifier.height(8.dp))
            Details(length, language, rating, reviews)
        }
    }
}
@Composable
fun Poster() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        // Large movie poster
        Image(
            painter = painterResource(id = R.drawable.movie_gw),
            contentDescription = "Movie Poster",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.movie_gw2),
            contentDescription = "Small Thumbnail",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.BottomStart)
                .offset(y = 40.dp)
                .padding(horizontal = 10.dp),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun Title(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )
}
@Composable
fun Rating() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        repeat(5) {
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Rating Star",
                tint = Color.Yellow,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}
@Composable
fun Details(length: String, language: String, rating: String, reviews: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        MovieDetail("Length", length)
        MovieDetail("Language", language)
        MovieDetail("Rating", rating)
        MovieDetail("Reviews", reviews)
    }
}
@Composable
fun MovieDetail(label: String, value: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = label, fontSize = 12.sp, fontWeight = FontWeight.Light)
        Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}
@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    MovieCard(
        title = "Star Wars: Episode 3",
        length = "2:20",
        language = "English",
        rating = "7.6",
        reviews = "45+"
    )
}
