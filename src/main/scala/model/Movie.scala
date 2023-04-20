package model

class Movie
(val imdbTitleId: String,
 val title: String,
 val originalTitle: String,
 val year: Int,
 val datePublished: String,
 val genre: List[String],
 val duration: Int,
 val country: List[String],
 val language: List[String],
 val director: List[String],
 val writer: List[String],
 val productionCompany: List[String],
 val actors: List[String],
 val description: String,
 val avgVote: Double,
 val votes: Long,
 val budget: Double,
 val usaGrossIncome: Double,
 val worlwideGrossIncome: Double,
 val metascore: Double,
 val reviewsFromUsers: Long,
 val reviewsFromCritics: Long
) {
  override def toString(): String = {
    s"""Movie(
       |  imdbTitleId=$imdbTitleId,
       |  title=$title,
       |  originalTitle=$originalTitle,
       |  year=$year,
       |  datePublished=$datePublished,
       |  genre=$genre,
       |  duration=$duration,
       |  country=$country,
       |  language=$language,
       |  director=$director,
       |  writer=$writer,
       |  productionCompany=$productionCompany,
       |  actors=$actors,
       |  description=$description,
       |  avgVote=$avgVote,
       |  votes=$votes,
       |  budget=$budget,
       |  usaGrossIncome=$usaGrossIncome,
       |  worldwideGrossIncome=$worlwideGrossIncome,
       |  metascore=$metascore,
       |  reviewsFromUsers=$reviewsFromUsers,
       |  reviewsFromCritics=$reviewsFromCritics
       |)""".stripMargin
  }
}