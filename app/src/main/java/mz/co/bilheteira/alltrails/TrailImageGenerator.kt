package mz.co.bilheteira.alltrails

object TrailImageGenerator {
    private val images = listOf(
        R.drawable.trails,
        R.drawable.natural,
        R.drawable.forest,
        R.drawable.threes,
    )

    fun generate(): List<Int> {
        return images.shuffled()
    }
}
