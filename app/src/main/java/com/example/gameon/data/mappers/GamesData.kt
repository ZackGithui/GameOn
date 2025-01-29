package com.example.gameon.data.mappers

import com.example.gameon.data.local.LikedEntity
import com.example.gameon.data.remote.Dto.GameResponse
import com.example.gameon.data.remote.Dto.GamesResponseItem
import com.example.gameon.domain.model.Game
import com.example.gameon.domain.model.Games

fun GamesResponseItem.toGames(): Games {
    return Games(
        title = title,
        gameUrl = gameUrl,
        thumbnail = thumbnail,
        developer = developer,
        genre = genre,
        id = id,
        shortDescription = shortDescription,
        releaseDate = releaseDate
    )
}

fun GameResponse.toGame(): Game {
    return Game(
        title = title,
        gameUrl = gameUrl,
        thumbnail = thumbnail,
        developer = developer,
        genre = genre,
        id = id,
        shortDescription = shortDescription,
        description = description,
        releaseDate = releaseDate
    )
}

fun GamesResponseItem.toLikedEntity(): LikedEntity {
    return LikedEntity(
        id = id,
        genre = genre,
        thumbnail = thumbnail,
        title = title

    )
}