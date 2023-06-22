package com.ymistudios.movieverse.ui.movie.movietype

object MovieTypeListRepo {

    fun getMovieTypeList() = arrayListOf(
        MovieType(
            type = "movie",
            image = "https://getwallpapers.com/wallpaper/full/e/f/d/259446.jpg"
        ),
        MovieType(
            type = "series",
            image = "https://i.pinimg.com/originals/88/39/53/883953fddc1dbc9e2a16e1eda4f26dad.jpg"
        ),
        MovieType(
            type = "episode",
            image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTovI5X8eKt4BRK-CM2PnOPkkXJVwqZ5E65ng&usqp=CAU"
        )
    )
}