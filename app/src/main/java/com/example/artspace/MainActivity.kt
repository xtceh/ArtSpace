package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import java.time.format.TextStyle
import androidx.compose.material3.Button
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceLayout()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.monalisa)
    val imageDescription = stringResource(R.string.mona_lisa)
    val imageTitle = stringResource(R.string.mona_lisa_title)
    val imageArtist = stringResource(R.string.mona_lisa_artist)
    val imageYear = stringResource(R.string.mona_lisa_year)

    Column(modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = image, contentDescription = imageDescription)
        }
        //Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = imageTitle, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "$imageArtist ($imageYear)", fontSize = 18.sp)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Button(onClick = {println("Previous Button Clicked!")},
                modifier = Modifier.weight(1f)) {
                Text(text = "Previous")
            }
            Button(onClick = {println("Next Button Clicked!")},
                modifier = Modifier.weight(1f)) {
                Text(text = "Next")
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout("Android")
    }
}*/