case class BankAccount() {
  private var balance: Option[Int] = Some(0)

  def closeAccount(): Unit = synchronized(balance = None)

  def getBalance: Option[Int] = synchronized(balance)

  def incrementBalance(increment: Int): Option[Int] = synchronized {
    balance match {
      case Some(b) => balance = Some(b + increment)
      case _ => None
    }
    balance
  }
}


object Bank {
  def openAccount(): BankAccount = new BankAccount
}

//notes on synchronized
//The synchronized keyword is used in two primary contexts:
//
//as a method modifier to mark a method that it can only be executed by one thread at a time.
//by declaring a code block as a critical section – one that’s only available to a single thread at any given point in time.