package me.sebastianquiroga.facebook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
//super idol
@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    userName: String = "Usuario de Facebook",
    timeAgo: String = "Hace 2 h",
    postText: String = "¡Hola a todos! Este es un ejemplo de publicación con una imagen cargada desde internet usando la librería Coil.",
    imageUrl: String = "https://picsum.photos/600/400",
    likesCount: String = "12",
    commentsCount: String = "5 comentarios",
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Encabezado de la publicación
            PostHeader(
                userName = userName,
                timeAgo = timeAgo
            )

            // Texto de la publicación
            if (postText.isNotBlank()) {
                Text(
                    text = postText,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Imagen cargada desde internet usando Coil (AsyncImage)
            if (imageUrl.isNotBlank()) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = "Imagen de la publicación",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Estadísticas (Likes y Comentarios)
            PostStart(
                likesCount = likesCount,
                commentsCount = commentsCount
            )

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 12.dp),
                thickness = 0.5.dp,
                color = Color.LightGray
            )

            // Botones de acción (Me gusta, Comentar, Compartir)
            PostActions()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard()
}
