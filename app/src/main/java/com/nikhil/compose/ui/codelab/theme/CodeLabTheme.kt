package com.nikhil.compose.ui.codelab.theme

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Palette
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nikhil.compose.R
import com.nikhil.compose.ui.codelab.theme.data.Post
import com.nikhil.compose.ui.theme.AppTheme
import com.nikhil.compose.ui.theme.CutCornerShape
import java.util.*

@Composable
fun CodeLabTheme() {
    AppTheme {
        NewsScreen()
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen() {
    Scaffold(topBar = { NewsToolbar() }, content = { padding ->
        NewsContent(padding)
    }
    )

}

@Composable
fun NewsContent(padding: PaddingValues) {
    val viewModel: NewsViewModel = viewModel()
    LazyColumn(contentPadding = padding) {
        item { NewsSlot(R.string.top, content = { FeaturedPost(viewModel.featuredPost) }) }
        item { Spacer(modifier = Modifier.size(16.dp)) }
        item { NewsSlot(R.string.popular, content = { PostList(viewModel.postList.toList()) }) }
    }

}

@Composable
fun PostList(postList: List<Post>, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(horizontal = 16.dp)) {
        postList.forEach { post: Post ->
            Row {
                Image(
                    painter = painterResource(id = post.imageThumbId),
                    contentDescription = null
                )
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = post.title,
                        style = MaterialTheme.typography.bodyMedium,

                        )
                    PostDetails(
                        date = post.metadata.date,
                        readTime = post.metadata.readTimeMinutes,
                        tags = post.tags
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Divider()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FeaturedPost(featuredPost: State<Post?>, modifier: Modifier = Modifier) {
    featuredPost.value?.let { post ->
        Card(

            modifier = modifier.padding(horizontal = 16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column()
            {
                Image(
                    painter = painterResource(id = post.imageId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CutCornerShape.small)
                        .heightIn(180.dp)
                        .fillMaxWidth()
                )
                val padding = Modifier.padding(horizontal = 16.dp)
                Spacer(modifier = Modifier.size(16.dp))
                Text(
                    text = post.title,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = padding
                )
                Text(
                    text = post.metadata.author.name,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = padding
                )
                PostDetails(
                    date = post.metadata.date,
                    readTime = post.metadata.readTimeMinutes,
                    tags = post.tags,
                    modifier = padding
                )
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostDetails(
    date: String,
    readTime: Int,
    tags: Set<String>,
    modifier: Modifier = Modifier
) {
    val divider = " . "
    val tagDivider = " "
    val tagStyle: SpanStyle = MaterialTheme.typography.labelMedium.toSpanStyle().copy(
        background = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
    )
    val text = buildAnnotatedString {
        append(date)
        append(divider)
        append(stringResource(id = R.string.read_time, readTime))
        append(divider)
        tags.forEachIndexed { index, tag ->
            if (index != 0) {
                append(tagDivider)
            }
            withStyle(tagStyle) {
                append(" ${tag.uppercase(Locale.getDefault())} ")
            }
        }
    }
    CompositionLocalProvider(LocalContentColor provides LocalContentColor.current.copy(alpha = 0.4f)) {
        Text(text = text, modifier = modifier, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun NewsSlot(
    @StringRes title: Int,
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {
        Surface(
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.15f),
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = modifier
                .fillMaxWidth()
                .semantics { heading() }
        ) {
            Text(
                text = stringResource(id = title),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        content()

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsToolbar() {
    TopAppBar(
        title = { NewsTitle() },
        navigationIcon = { NewsAppbarIcon() },
        modifier = Modifier
            .fillMaxWidth(),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface
        )


    )
}

@Composable
fun NewsAppbarIcon() {
    Icon(
        imageVector = Icons.Rounded.Palette,
        contentDescription = null,
        tint = Color.White,
        modifier = Modifier.padding(horizontal = 16.dp)
    )

}

@Composable
fun NewsTitle() {
    Text(
        text = stringResource(id = R.string.news_title),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Start,
        modifier = Modifier.padding(horizontal = 16.dp),
        style = MaterialTheme.typography.titleMedium
    )

}

@Preview(
    showBackground = true,
    device = Devices.PIXEL,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkMode"
)
@Composable
fun NewsPreviewDark() {
    AppTheme(useDarkTheme = true) {
        NewsScreen()
    }
}

@Preview(
    showBackground = true, device = Devices.PIXEL,
    showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO,
    name = "LightMode"
)
@Composable
fun NewsPreviewLight() {
    AppTheme {
        NewsScreen()
    }
}
