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
    val recetas = listOf(
        Receta("Lomo Saltado", "Clásico plato peruano con carne, cebolla y tomate salteados al wok.", "Plato principal", "35 min"),
        Receta("Causa Limeña", "Deliciosa entrada fría a base de papa amarilla, ají y limón.", "Entrada", "20 min"),
        Receta("Aji de Gallina", "Guiso cremoso de pollo desmenuzado con pan y ají amarillo.", "Plato principal", "40 min"),
        Receta("Arroz con Leche", "Postre tradicional con arroz, leche y canela.", "Postre", "30 min"),
        Receta("Papa a la Huancaína", "Papas bañadas en salsa de queso y ají amarillo.", "Entrada", "25 min"),
        Receta("Tallarines Verdes", "Pasta con salsa de albahaca, queso fresco y espinaca.", "Plato principal", "30 min"),
        Receta("Mazamorra Morada", "Postre limeño a base de maíz morado y frutas secas.", "Postre", "35 min"),
        Receta("Ceviche Clásico", "Pescado fresco marinado en limón, con cebolla y ají.", "Plato principal", "25 min"),
        Receta("Anticuchos", "Brochetas de corazón de res sazonadas con ají panca.", "Plato principal", "45 min"),
        Receta("Suspiro a la Limeña", "Postre con manjar blanco y merengue al oporto.", "Postre", "40 min"),
        Receta("Chocoteja Casera", "Dulce relleno con manjar y cubierto de chocolate.", "Postre", "15 min"),
        Receta("Ensalada Rusa", "Ensalada fría con papas, zanahoria, arvejas y mayonesa.", "Entrada", "20 min"),
        Receta("Pollo al Horno", "Pollo marinado y horneado con hierbas y papas doradas.", "Plato principal", "50 min"),
        Receta("Turrón de Doña Pepa", "Tradicional postre limeño con miel y grageas.", "Postre", "60 min"),
        Receta("Chicha Morada", "Bebida refrescante de maíz morado, piña y canela.", "Bebida", "25 min"),
        Receta("Leche de Tigre", "Extracto del ceviche, potente y lleno de sabor.", "Entrada", "10 min"),
        Receta("Empanadas", "Masa rellena de carne, cebolla y huevo duro.", "Entrada", "30 min"),
        Receta("Arroz Chaufa", "Fusión peruano-china con arroz frito, pollo y sillao.", "Plato principal", "35 min"),
        Receta("Crema Volteada", "Postre tipo flan, suave y acaramelado.", "Postre", "45 min"),
        Receta("Ocopa Arequipeña", "Papas bañadas con salsa de maní y ají mirasol.", "Entrada", "30 min")
    )

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
