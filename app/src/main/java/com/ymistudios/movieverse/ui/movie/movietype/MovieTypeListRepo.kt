package com.ymistudios.movieverse.ui.movie.movietype

object MovieTypeListRepo {

    fun getMovieTypeList() = arrayListOf(
        MovieType(
            type = "movie",
            image = "https://images.unsplash.com/photo-1579445710183-f9a816f5da05?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YXZlbmdlcnMlMjBlbmRnYW1lfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60"
        ),
        MovieType(
            type = "series",
            image = "https://images.unsplash.com/photo-1640499900704-b00dd6a1103a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8YXZlbmdlcnMlMjBlbmRnYW1lfGVufDB8MHwwfHx8MA%3D%3D&auto=format&fit=crop&w=500&q=60"
        ),
        MovieType(
            type = "episode",
            image = "https://images.unsplash.com/photo-1579445710183-f9a816f5da05?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8YXZlbmdlcnMlMjBlbmRnYW1lfGVufDB8fDB8fHww&auto=format&fit=crop&w=500&q=60"
        )
    )
}