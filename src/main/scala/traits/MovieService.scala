package traits

import scala.collection.mutable.ListBuffer

trait MovieService {

  /**
   * Titles directed by given director in the given year range e.g.:
   * generate titles report for director D.W. Griffith and year range 2010 to 2020
   *
   * @param directorName : String
   * @param yearRange    (from,to): (Int, Int)
   * @return List[String]
   */
  def getTitleReport(directorName: String, yearRange: (Int, Int)): List[String]

  /**
   * Generate report of English titles which have user reviews more than given user review filter
   * and sort the report with user reviews by descending
   *
   * @param userReviewCount : Long
   * @return List[String]
   */
  def getEnglishTitleReport(userReviewCount: Long): List[String]

  /**
   * Generate highest budget titles for the given year and country filters
   *
   * @param year    : Int
   * @param country : String
   * @return List[String]
   */
  def getHighestBudgetTitles(year: Int, country: String): List[String]

  /**
   * Generate report of longest duration title for the given country filter,
   * no of minimum votes filter and sort by duration in descending order
   *
   * @param country : String
   * @param minVote : Long
   * @return List[String]
   */
  def getLongestDurationTitles(country: String, minVote: Long): List[String]

  /**
   * Generate language wise report to count the titles for the given budget range 
   * and country filter and sort with count descending
   *
   * @param country     : String
   * @param budgetRange (from,to): (Double, Double)
   */
  def getLanguageWistReport(country: String, budgetRange: (Double, Double)): Unit
}
