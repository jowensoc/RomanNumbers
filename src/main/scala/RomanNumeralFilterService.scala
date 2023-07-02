import models._

import scala.collection.mutable.ListBuffer


object RomanNumeralFilterService {
  var listOfRomanNumbers: List[RomanNumber] = initList()
  var numericTypeMap: Map[Int, NumericUnitType.UnitType] = initNumericType()

  def initList(): List[RomanNumber] = {
    var list = new ListBuffer[RomanNumber]

    list.addOne(new RomanNumber(0, NumericUnitType.Single, ""))

    list.addOne(new RomanNumber(1, NumericUnitType.Single, "I"))
    list.addOne(new RomanNumber(2, NumericUnitType.Single, "II"))
    list.addOne(new RomanNumber(3, NumericUnitType.Single, "III"))
    list.addOne(new RomanNumber(4, NumericUnitType.Single, "IV"))
    list.addOne(new RomanNumber(5, NumericUnitType.Single, "V"))
    list.addOne(new RomanNumber(6, NumericUnitType.Single, "VI"))
    list.addOne(new RomanNumber(7, NumericUnitType.Single, "VII"))
    list.addOne(new RomanNumber(8, NumericUnitType.Single, "VIII"))
    list.addOne(new RomanNumber(9, NumericUnitType.Single, "IX"))

    list.addOne(new RomanNumber(10, NumericUnitType.Tens, "X"))
    list.addOne(new RomanNumber(20, NumericUnitType.Tens, "XX"))
    list.addOne(new RomanNumber(30, NumericUnitType.Tens, "XXX"))
    list.addOne(new RomanNumber(40, NumericUnitType.Tens, "XL"))
    list.addOne(new RomanNumber(50, NumericUnitType.Tens, "L"))
    list.addOne(new RomanNumber(60, NumericUnitType.Tens, "LX"))
    list.addOne(new RomanNumber(70, NumericUnitType.Tens, "LXX"))
    list.addOne(new RomanNumber(80, NumericUnitType.Tens, "LXXX"))
    list.addOne(new RomanNumber(90, NumericUnitType.Tens, "XC"))

    list.addOne(new RomanNumber(100, NumericUnitType.Hundreds, "C"))
    list.addOne(new RomanNumber(200, NumericUnitType.Hundreds, "CC"))
    list.addOne(new RomanNumber(300, NumericUnitType.Hundreds, "CCC"))
    list.addOne(new RomanNumber(400, NumericUnitType.Hundreds, "CD"))
    list.addOne(new RomanNumber(500, NumericUnitType.Hundreds, "D"))
    list.addOne(new RomanNumber(600, NumericUnitType.Hundreds, "DC"))
    list.addOne(new RomanNumber(700, NumericUnitType.Hundreds, "DCC"))
    list.addOne(new RomanNumber(800, NumericUnitType.Hundreds, "DCCC"))
    list.addOne(new RomanNumber(900, NumericUnitType.Hundreds, "CM"))

    list.addOne(new RomanNumber(1000, NumericUnitType.Thousands, "M"))
    list.addOne(new RomanNumber(2000, NumericUnitType.Thousands, "MM"))
    list.addOne(new RomanNumber(3000, NumericUnitType.Thousands, "MMM"))
    list.addOne(new RomanNumber(4000, NumericUnitType.Thousands, "MMMM"))

    list.toList
  }

  def initNumericType(): Map[Int, NumericUnitType.UnitType] = {
    Map(0 -> NumericUnitType.None
      , 1 -> NumericUnitType.Single
      , 2 -> NumericUnitType.Tens
      , 3 -> NumericUnitType.Hundreds
      , 4 -> NumericUnitType.Thousands
    )
  }


  def solution(number: Int): String = {

    if (number >= 5000) {
      return "OUT_OF_RANGE"
    }

    var results = ""

    if (listOfRomanNumbers.exists(item => item.number == number)) {
      results = listOfRomanNumbers.filter(item => item.number == number)(0).currentRomanNumeral
    } else {

      val listOfDigits: List[RomanNumber] = splitNumber(number)

      for(item <- listOfDigits) {
        results += item.currentRomanNumeral
      }

    }

    results
  }

  def splitNumber(number: Int): List[RomanNumber] = {
    var results = new ListBuffer[RomanNumber]

    val currentNumberString = number.toString
    var numberLength = currentNumberString.length
    val lastIndex = numberLength - 1
    var numericUnitType = numericTypeMap.get(numberLength).head

    for (currentIndex <- 0 to lastIndex) {
      if (currentNumberString(currentIndex).toString.toInt != 0) {
        val currentNumber = currentNumberString(currentIndex).toString.toInt
        val fullNumber = getFullNumber(currentNumber, numericUnitType)

        val romanNumber = listOfRomanNumbers.filter(item => item.number == fullNumber
                                                    && item.numericUnitType == numericUnitType)(0)

        results.addOne(romanNumber)

      }

      // MOVE TO NEXT UNIT NUMERIC TYPE
      numberLength -= 1
      numericUnitType = numericTypeMap.get(numberLength).head
    }

    results.toList
  }

  def getFullNumber(currentNumber: Int, numericUnitType: NumericUnitType.UnitType): Int = {
    var results = currentNumber

    if (numericUnitType == NumericUnitType.Thousands) {
      results = results * 1000
    }

    if (numericUnitType == NumericUnitType.Hundreds) {
      results = results * 100
    }

    if (numericUnitType == NumericUnitType.Tens) {
      results = results * 10
    }

    if (numericUnitType == NumericUnitType.Single) {
      results = results * 1
    }

    results
  }

}
