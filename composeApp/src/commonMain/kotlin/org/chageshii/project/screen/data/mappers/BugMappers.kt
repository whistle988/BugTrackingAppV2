package org.chageshii.project.screen.data.mappers

import org.chageshii.project.screen.data.dto.SearchedBugDto
import org.chageshii.project.screen.domain.Bug

fun SearchedBugDto.toBug(): Bug {
    return Bug(
        id = id.substringAfterLast("/"),
        title = title,
        imageUrl = "",
        author = authorNames,
        description = null,
        createdDate = null,
        averageRating = null,
        priority = "minimum",
        numPages = 0,
        lastEditedAuthor = authorNames,
        status = "to do",
        solution = null,
        performer = null,
        comments = null,
        testerName = authorNames,
        taskName = "new test case"
    )
}

/*
fun Bug.toBugEntity(): BugEntity {
    return BugEntity(

    )
}*/
