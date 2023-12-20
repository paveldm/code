import java.util.*
abstract class BankCard(val cardNumber: String, val pinCode: String) {
    abstract fun getBalance(): Double
}
class CreditCard(cardNumber: String, pinCode: String, val creditLimit: Double, var debt: Double) : BankCard(cardNumber, pinCode) {
    override fun getBalance(): Double {
        return creditLimit - debt
    }
}
class DebitCard(cardNumber: String, pinCode: String, var accountBalance: Double) : BankCard(cardNumber, pinCode) {
    override fun getBalance(): Double {
        return accountBalance
    }
}
data class Transaction(val cardNumber: String, val amount: Double, val date: Date, val type: TransactionType)
enum class TransactionType {
    WITHDRAWAL, DEPOSIT
}
class Bank {
    val transactions = mutableListOf<Transaction>()
    fun makeTransaction(cardNumber: BankCard, amount: Double, date: Date, type: TransactionType) {
        when(type){
            TransactionType.DEPOSIT->{
                if(cardNumber is CreditCard){
                    cardNumber.debt-=amount
                }
                else if(cardNumber is DebitCard){
                    cardNumber.accountBalance+=amount
                }
            }
            TransactionType.WITHDRAWAL->{
                if(cardNumber is CreditCard){
                    cardNumber.debt+=amount
                }
                else if(cardNumber is DebitCard){
                    cardNumber.accountBalance-=amount
                }
            }
        }
        transactions.add(Transaction(cardNumber.cardNumber, amount, date, type))
    }
    fun printTransactions(cardNumber: String, type: TransactionType) {
        val filteredTransactions = transactions.filter { it.cardNumber == cardNumber && it.type == type }
        for (transaction in filteredTransactions) {
            println("Номер карты: " + transaction.cardNumber + " Баланс: " + transaction.amount +  " Дата: " + transaction.date + " Тип: " + transaction.type)
        }
    }
}
fun main() {
    val bank = Bank()
    val creditCard = CreditCard("123456789", "1234", 10000.0, 5000.0)
    val debitCard = DebitCard("987654321", "9876", 2000.0)
    println("Баланс кредитной карты: " + creditCard.getBalance())
    println("Баланс дебетовой карты: " + debitCard.getBalance())
    val transactionDate = Date()
    bank.makeTransaction(creditCard, 500.0, transactionDate, TransactionType.WITHDRAWAL)
    bank.makeTransaction(debitCard, 200.0, transactionDate, TransactionType.DEPOSIT)
    bank.printTransactions(creditCard.cardNumber, TransactionType.WITHDRAWAL)
    bank.printTransactions(debitCard.cardNumber, TransactionType.DEPOSIT)
    println("Баланс кредитной карты: " + creditCard.getBalance())
    println("Баланс дебетовой карты: " + debitCard.getBalance())
}
