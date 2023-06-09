package exception

class ServiceException(message: String, cause: Throwable) extends BaseException(message, cause) {
  def this(message: String) = this(message, null)

  def this(cause: Throwable) = this(null, cause)

  def this() = this(null, null)
}
