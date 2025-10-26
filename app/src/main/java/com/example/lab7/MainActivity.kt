package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Modelo de datos
data class Receta(
    val nombre: String,
    val descripcion: String,
    val categoria: String,
    val tiempo: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ListaRecetas()
                }
            }
        }
    }
}

@Composable
fun ListaRecetas() {
    val recetas = List(20) { i ->
        Receta(
            nombre = "Receta ${i + 1}",
            descripcion = "Descripción breve ${i + 1}",
            categoria = if (i % 2 == 0) "Postre" else "Plato principal",
            tiempo = "${15 + i} min"
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        items(recetas) { receta ->
            RecetaItem(receta)
        }
    }
}

@Composable
fun RecetaItem(receta: Receta) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3E0)),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(10.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar con inicial
            val inicial = receta.nombre.firstOrNull()?.uppercase() ?: "R"
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF9800)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = inicial,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column {
                Text(text = receta.nombre, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = receta.descripcion, fontSize = 14.sp)
                Text(text = "Categoría: ${receta.categoria}", fontSize = 13.sp)
                Text(text = "Tiempo: ${receta.tiempo}", fontSize = 13.sp)
            }
        }
    }
}
