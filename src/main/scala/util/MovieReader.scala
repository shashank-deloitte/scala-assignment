package util

import com.github.tototoshi.csv.*
import exception.UtilException
import model.Movie

import java.io.{File, FileNotFoundException}
import scala.collection.immutable.List
import scala.collection.mutable.ListBuffer

object MovieReader {
  var moviesDetails: ListBuffer[Movie] = ListBuffer[Movie]()

  /**
   * Read movie csv and parse it to populate global movie list
   *
   * @param filePath : String
   * @return ListBuffer[Movie]
   */
  def readMovieCsv(filePath: String) = {
    var reader: CSVReader = null
    try {
      reader = CSVReader.open(new File(filePath))
      reader.all().slice(1, 10001).foreach(movie => {
        moviesDetails.append(parseMovies(movie))
      })
    }
    catch {
      case e: FileNotFoundException => throw new UtilException("File Not Found !!")
      case e: Exception => throw new UtilException("Failed to read CSV file")
    }
    finally {
      if (reader != null) reader.close()
    }
    moviesDetails
  }

  /**
   * Parse movies List[String] to Movie
   *
   * @param movie : List[String]
   * @return Movie
   */
  def parseMovies(movie: List[String]) = {
    Movie(
      movie(0),
      movie(1),
      movie(2),
      movie(3).toInt,
      movie(4),
      movie(5).split(",").toList,
      movie(6).toInt,
      movie(7).split(",").toList,
      movie(8).split(",").toList,
      movie(9).split(",").toList,
      movie(10).split(",").toList,
      movie(11).split(",").toList,
      movie(12).split(",").toList,
      movie(13),
      movie(14).toDouble,
      movie(15).toLong,
      parseStringToDouble(movie(16)),
      parseStringToDouble(movie(17)),
      parseStringToDouble(movie(18)),
      parseStringToDouble(movie(19)),
      parseStringToLong(movie(20)),
      parseStringToLong(movie(21))
    )
  }

  def parseStringToLong(str: String): Long = {
    Option(str).flatMap(_.toLongOption).getOrElse(0L)
  }

  def parseStringToDouble(str: String): Double = {
    Option(str).map(_.replaceAll("\\D", "")).flatMap(_.toDoubleOption).getOrElse(0.0)
  }
}