package com.delaricch.dericch.eats.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delaricch.dericch.eats.R
import com.delaricch.dericch.eats.data.OnboardingItem
import com.delaricch.dericch.eats.ui.theme.DarkGray
import com.delaricch.dericch.eats.ui.theme.Gray
import com.delaricch.dericch.eats.ui.theme.LightOrange
import com.delaricch.dericch.eats.ui.theme.Orange

val onBoardingItemsList = listOf(
    OnboardingItem(
        title = "All your favorites",
        image = R.drawable.onboarding1,
    ),
    OnboardingItem(
        title = "All your favorites",
        image = R.drawable.onboarding3,
    ),
    OnboardingItem(
        title = "Order from chosen chef",
        image = R.drawable.onboarding2,
    ),
    OnboardingItem(
        title = "Free delivery offers",
        image = R.drawable.onboarding4,
    ),
)

@Composable
fun SliderPreview(selectedIndex: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        for (index in onBoardingItemsList.indices) {
            Box(
                modifier = Modifier
                    .height(10.dp)
                    .width(10.dp)
                    .clip(RoundedCornerShape(50))
                    .background(color = if (selectedIndex == index) Orange else LightOrange)
            )
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}

@Preview
@Composable
fun onBoardingPage() {
    var selectedIndex = remember {
        mutableIntStateOf(0)
    }

    val selectedItem = onBoardingItemsList[selectedIndex.intValue]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 18.dp, vertical = 64.dp)
    ) {

        Spacer(modifier = Modifier.height(40.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(selectedItem.image),
                contentDescription = selectedItem.title,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(0.5f)
                    .clip(RoundedCornerShape(10.dp))
            )

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${selectedItem.title}",
                    color = DarkGray,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Get all your loved foods in one once place,\n" +
                            "you just place the order we do the rest",
                    color = Gray,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                SliderPreview(selectedIndex.intValue)
            }
        }
        Spacer(modifier = Modifier.height(80.dp))

        Button(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange,
            ), onClick = {
                if (selectedIndex.intValue < 4) {
                    selectedIndex.value += 1
                }
            }) {
            Text(text = if (selectedIndex.intValue < 3) "NEXT" else "GET STARTED")
        }

        if (selectedIndex.intValue < 3) {
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                onClick = {}) {
                Text(text = "Skip", color = Gray)
            }
        }
    }
}