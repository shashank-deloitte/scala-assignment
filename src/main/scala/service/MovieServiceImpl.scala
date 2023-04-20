package service

import exception.ServiceException
import model.Movie
import traits.MovieService
import util.MovieReader

import scala.collection.mutable.ListBuffer

class MovieServiceImpl(movies: ListBuffer[Movie]) extends MovieService {

  override def getTitleReport(directorName: String, yearRange: (Int, Int)): List[String] = {
    if (directorName == null || yearRange == null) {
      throw new ServiceException("Director name and year range cannot be null")
    }
    movies.filter(movie => movie.director.contains(directorName) && movie.year >= yearRange._1 && movie.year <= yearRange._2)
      .map(movie => movie.title).toList
  }

  override def getEnglishTitleReport(userReviewCount: Long): List[String] = {
    if (userReviewCount < 0) {
      throw new ServiceException("User review count cannot be negative")
    }
    movies.filter(movie => movie.reviewsFromUsers > userReviewCount)
      .sortBy(-_.reviewsFromUsers)
      .map(movie => movie.title).toList
  }

  override def getHighestBudgetTitles(year: Int, country: String): List[String] = {
    val result = movies.filter(movie => movie.year == year && movie.country.contains(country))
      .sortBy(-_.budget)
    result.filter(movie => movie.budget == result.head.budget).map(movie => movie.title).toList
  }

  override def getLongestDurationTitles(country: String, minVote: Long): List[String] = {
    val result = movies.filter(movie => movie.country.contains(country) && movie.votes > minVote).sortBy(-_.duration)
    result.filter(movie => movie.duration == result.head.duration).map(movie => movie.title).toList
  }

  override def getLanguageWistReport(country: String, budgetRange: (Double, Double)): Unit = {
    if (country == null || budgetRange == null) {
      throw new ServiceException("Country and budget range cannot be null")
    }
    val filterMovies = movies.filter(movie=> movie.language.head.nonEmpty &&  movie.country.contains(country) && movie.budget >= budgetRange._1 && movie.budget <= budgetRange._2)
    val languages = filterMovies.flatMap(_.language)

    // Count the number of occurrences of each language
    val languageCounts = languages.groupMapReduce(identity)(_ => 1)(_ + _)

    // Sort the languages by count in descending order
    languageCounts.toList.sortBy(-_._2).foreach(
      movie => println(movie._1 + " : " + movie._2)
    )
  }
}
