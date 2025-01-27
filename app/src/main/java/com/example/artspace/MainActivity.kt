package com.example.artspace

import android.content.Context
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

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
    var imageNo = remember { mutableIntStateOf(1) }
    val countImages = 2
    val imageName = getImageName(imageNo.intValue)
    val image = when (imageName) {"monalisa" -> painterResource(R.drawable.monalisa)
        "laughingcavalier" -> painterResource(R.drawable.laughingcavalier)
        else -> painterResource(R.drawable.monalisa)}
    val imageDescription = when (imageName) {"monalisa" -> stringResource(R.string.mona_lisa)
        "laughingcavalier" -> stringResource(R.string.laughing_cavalier)
        else -> stringResource(R.string.mona_lisa)}
    val imageTitle = when (imageName) {"monalisa" -> stringResource(R.string.mona_lisa_title)
        "laughingcavalier" -> stringResource(R.string.laughing_cavalier_title)
        else -> stringResource(R.string.mona_lisa_title)}
    val imageArtist = when (imageName) {"monalisa" -> stringResource(R.string.mona_lisa_artist)
        "laughingcavalier" -> stringResource(R.string.laughing_cavalier_artist)
        else -> stringResource(R.string.mona_lisa_artist)}
    val imageYear = when (imageName) {"monalisa" -> stringResource(R.string.mona_lisa_year)
        "laughingcavalier" -> stringResource(R.string.laughing_cavalier_year)
        else -> stringResource(R.string.mona_lisa_year)}
    val prevButton = stringResource(R.string.prev_button)
    val nextButton = stringResource(R.string.next_button)

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
            Button(onClick = {if (imageNo.intValue > 1) {imageNo.intValue--}
                             else {imageNo.intValue = countImages}},
                modifier = Modifier.weight(1f)) {
                Text(text = prevButton)
            }
            Button(onClick = {if (imageNo.intValue < countImages) {imageNo.intValue++}
                             else {imageNo.intValue = 1}},
                modifier = Modifier.weight(1f)) {
                Text(text = nextButton)
            }
        }
    }
}

fun getImageName(imageNo: Int): String {
    val result = when (imageNo) {
        1 -> "monalisa"
        2 -> "laughingcavalier"
        else -> "monalisa"
    }
    return result
}

fun getStringResourceByName(context: Context, resourceName: String): String {
    val resourceId = context.resources.getIdentifier(
        resourceName, "string", context.packageName
    )
    return if (resourceId != 0) {
        context.getString(resourceId)
    } else {
        // Handle case where resource is not found
        "" // Or throw an exception, log an error, etc.
    }
}

/*@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceLayout("Android")
    }
}*/