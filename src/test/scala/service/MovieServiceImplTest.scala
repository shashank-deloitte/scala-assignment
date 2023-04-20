import exception.ServiceException
import model.Movie
import org.scalatest.funsuite.AnyFunSuite
import service.MovieServiceImpl
import util.{Constants, MovieReader}

import scala.collection.mutable.ListBuffer


class MovieServiceImplTest extends AnyFunSuite {

  val movies = ListBuffer(
    Movie("1", "title 1", "Original Title 1", 2020, "1999-12-30", List("Action", "Adventure", "Drama"), 110, List("India"), List("English", "French"), List("Christopher Nolan"), List("Christopher Nolan"), List("Warner Bros.", "Legendary Entertainment", "Syncopy"), List("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Test story 1", 8, 661, 22950, 0, 0, 0.0, 6, 8),
    Movie("2", "title 2", "Original Title 2", 2021, "2000-12-29", List("Action", "Adventure", "Drama"), 90, List("China"), List("Hindi", "Italian"), List("Christopher Nolan"), List("Christopher Nolan"), List("Warner Bros.", "Legendary Entertainment", "Syncopy"), List("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Test story 2", 7, 776, 92500, 0, 0, 0.0, 6, 7),
    Movie("3", "title 3", "Original Title 3", 2022, "2006-11-16", List("Action", "Adventure", "Drama"), 140, List("Japan"), List("English", "Russian"), List("Christopher Nolan"), List("Christopher Nolan"), List("Warner Bros.", "Legendary Entertainment", "Syncopy"), List("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Test story 3", 7, 833, 250, 0, 0, 0.0, 8, 6),
    Movie("4", "title 4", "Original Title 3", 2023, "2006-11-16", List("Action", "Adventure", "Drama"), 140, List("Japan"), List("English", "Russian"), List("Christopher Nolan"), List("Christopher Nolan"), List("Warner Bros.", "Legendary Entertainment", "Syncopy"), List("Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"), "Test story 3", 7, 833, 250, 0, 0, 0.0, 8, 6)
  )

  val movieService = new MovieServiceImpl(movies)

  /**
   * Question 1
   */
  test("test getTitleReport") {
    val result = movieService.getTitleReport("Christopher Nolan", (2020, 2022))
    assert(result.length == 3)
    assert(result.head.equals("title 1"))
  }

  test("test movieTitlesByDirector when directorName is null") {
    val exception = intercept[ServiceException] {
      movieService.getTitleReport(null, (2020, 2023))
    }
    assert(exception.getMessage == "Director name and year range cannot be null")
  }

  /**
   * Question 2
   */
  test("test getEnglishTitleReport") {
    val result = movieService.getEnglishTitleReport(6)
    assert(result.length == 2)
    assert(result == ListBuffer("title 3", "title 4"))
  }

  test("test movieTitlesByUserReview when userReviewCount is negative") {
    val exception = intercept[ServiceException] {
      movieService.getEnglishTitleReport(-1)
    }
    assert(exception.getMessage == "User review count cannot be negative")
  }

  /**
   * Question 3
   */
  test("test getHighestBudgetTitles") {
    val result = movieService.getHighestBudgetTitles(2020, "India")
    assert(result == ListBuffer("title 1"))
  }

  /**
   * Question 4
   */
  test("test getLongestDurationTitles") {
    val result = movieService.getLongestDurationTitles("India", 336)
    assert(result.length == 1)
    assert(result == ListBuffer("title 1"))
  }

  /**
   * Question 5
   */
  test("test getLanguageWistReport") {
    movieService.getLanguageWistReport("India", (100, 30000))
  }

  test("test getLanguageWistReport when budgetRange is null") {
    val exception = intercept[ServiceException] {
      movieService.getLanguageWistReport("India", null)
    }
    assert(exception.getMessage == "Country and budget range cannot be null")
  }
}