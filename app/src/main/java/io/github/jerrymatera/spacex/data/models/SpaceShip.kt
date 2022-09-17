package io.github.jerrymatera.spacex.data.models

data class SpaceShip(
    val ship_id: String,
    val image: String,
    val position: Position,
    val ship_name: String,
    val ship_type: String,
    val speed_kn: Any,
    val status: String,
    val year_built: Int
)