import com.typesafe.config.{Config, ConfigFactory}
import model.Movie
import service.MovieServiceImpl
import traits.MovieService
import util.{Constants, MovieReader}

import java.io.File

@main
def main(): Unit = {

  val applicationConf: Config = ConfigFactory.parseFile(new File(Constants.configFilePath))
  val fileName = applicationConf.getString(Constants.movieCsvPath)

  val movieService: MovieService = new MovieServiceImpl(MovieReader.readMovieCsv(fileName))

  val que1 = movieService.getTitleReport("August Blom", (1900, 2000))
  val que2 = movieService.getEnglishTitleReport(953L)
  val que3 = movieService.getHighestBudgetTitles(1942, "Spain")
  val que4 = movieService.getLongestDurationTitles("Spain", 100L)

  println("Question - 1 .............................")
  println(que1)
  println("Question - 2 .............................")
  println(que2)
  println("Question - 3 .............................")
  println(que3)
  println("Question - 4 .............................")
  println(que4)
  println("Question - 5 .............................")
  movieService.getLanguageWistReport("USA", (700, 90000))
}