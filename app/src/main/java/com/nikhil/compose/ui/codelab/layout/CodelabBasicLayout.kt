package com.nikhil.compose.ui.codelab.layout

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nikhil.compose.R
import com.nikhil.compose.ui.theme.AppTheme
import java.util.*


// Step: Search bar - Modifiers
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    Row {
        TextField(
            value = "",
            onValueChange = {},
            modifier = modifier
                .heightIn(min = 56.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.placeholder_search))
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )
    }
}

// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )

        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )


    }
}

// Step: Favorite collection card - Material Surface
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier.width(200.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(id = text),
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

        }
    }

}

// Step: Align your body row - Arrangements
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(alignYourBodyData) { data ->
            AlignYourBodyElement(drawable = data.drawable, text = data.text, modifier = modifier)

        }
    }
}

// Step: Favorite collections grid - LazyGrid
@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(136.dp)
    ) {
        items(favoriteCollectionsData) { data ->
            FavoriteCollectionCard(
                drawable = data.drawable, text = data.text,
                modifier = modifier.height(56.dp)
            )
        }

    }

}

// Step: Home section - Slot APIs
@Composable
fun HomeSection(
    @StringRes text: Int,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column() {
       Text(
           text = stringResource(id = text).uppercase(Locale.getDefault()),
           style = MaterialTheme.typography.headlineMedium,
           modifier = modifier
               .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
               .padding(horizontal = 16.dp)
       )
        content()


    }
}

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.size(16.dp))
        SearchBar(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.size(24.dp))
        HomeSection(text = R.string.align_your_body,
        content = {
            AlignYourBodyRow( )

        },
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(24.dp))
        HomeSection(text = R.string.favorite_collections,
            content = {
                FavoriteCollectionsGrid( )
            },
            modifier = Modifier
        )
        Spacer(modifier = Modifier.size(16.dp))
    }
}

// Step: Bottom navigation - Material
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
    containerColor = MaterialTheme.colorScheme.background
        ) {
        NavigationBarItem(
            selected = true,
            onClick = {  },
            label = { Text(text = stringResource(id = R.string.bottom_navigation_home))},
            icon =  {
                Icon(imageVector = Icons.Default.Spa, contentDescription = null)
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {  },
            label = { Text(text = stringResource(id = R.string.bottom_navigation_profile))},
            icon =  {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
            }
        )



    }
}

// Step: MySoothe App - Scaffold
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodeLabBasicLayout() {
    AppTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation()
            }
        ) {padding->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


/*@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun SearchBarPreview() {
    AppTheme { SearchBar(Modifier.padding(8.dp)) }
}*/

/*
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyElementPreview() {
    AppTheme {
        AlignYourBodyElement(
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}*/
/*
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionCardPreview() {
    AppTheme {
        FavoriteCollectionCard(
            drawable = R.drawable.fc2_nature_meditations,
            text = R.string.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}*/

/*@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun FavoriteCollectionsGridPreview() {
    AppTheme { FavoriteCollectionsGrid() }
}*/


/*@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyRowPreview() {
    AppTheme { AlignYourBodyRow() }
}*/

/*
@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun HomeSectionPreview() {
    AppTheme { HomeSection(
        text = R.string.align_your_body,
        content = { AlignYourBodyRow() },
        modifier = Modifier
    ) }
}*/


/*@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun ScreenContentPreview() {
    AppTheme { HomeScreen() }
}*/

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun BottomNavigationPreview() {
    AppTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}
/*
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun CodeLabBasicLayoutPreview() {
    CodeLabBasicLayout()
}*/
