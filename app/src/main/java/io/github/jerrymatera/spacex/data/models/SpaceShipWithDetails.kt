package io.github.jerrymatera.spacex.data.models

data class SpaceShipWithDetails(
    val abs: Int,
    val active: Boolean,
    val attempted_catches: Int,
    val attempted_landings: Int,
    val `class`: Int,
    val course_deg: Any,
    val home_port: String,
    val image: String,
    val imo: Int,
    val missions: List<Mission>,
    val mmsi: Int,
    val position: Position,
    val roles: List<String>,
    val ship_id: String,
    val ship_model: String,
    val ship_name: String,
    val ship_type: String,
    val speed_kn: Any,
    val status: String,
    val successful_catches: Int,
    val successful_landings: Int,
    val url: String,
    val weight_kg: Int,
    val weight_lbs: Int,
    val year_built: Int)
