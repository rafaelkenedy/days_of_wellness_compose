package com.example.daysofwellness

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.daysofwellness.data.Wellness
import com.example.daysofwellness.data.Wellness.tips
import com.example.daysofwellness.model.Tip
import com.example.daysofwellness.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DaysOfWellnessTheme {
                App()
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App() {
    Scaffold(
        topBar = { DaysTopBar() }
    ) {
        LazyColumn(
            modifier = Modifier.background(MaterialTheme.colors.background)

        ) {

            itemsIndexed(tips) { index, tip ->
                DayItem(
                    tip = tip,
                    dayIndex = index,
                    modifier = Modifier
                        .padding(15.dp)
                )
            }
        }
    }
}

@Composable
fun DaysTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h1
        )
    }

}

@Composable
fun DayItem(tip: Tip, modifier: Modifier = Modifier, dayIndex: Int) {
    Card(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = "Dia ${dayIndex + 1}", style = MaterialTheme.typography.h3)
            Spacer(modifier = Modifier.height(8.dp))
            Image(painter = painterResource(id = tip.imageRes), contentDescription = null)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(id = tip.dayPhrase), style = MaterialTheme.typography.body1)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DaysOfWellnessTheme() {
    DaysOfWellnessTheme {
        App()
    }
}