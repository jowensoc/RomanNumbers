import models._

object RomanNumeralsService {

  var map: Map[Int, String] = init()
  var numericTypeMap: Map[Int, NumericUnitType.UnitType] = initNumericType()

  def init(): Map[Int, String] = {
    Map(1 -> "I"
        ,2 -> "II"
        ,3 -> "III"
        ,4 -> "IV"
        ,5 -> "V"
        ,6 -> "VI"
        ,7 -> "VII"
        ,8 -> "VIII"
        ,9 -> "IX"
        ,10 -> "X"
        ,20 -> "XX"
        ,30 -> "XXX"
        ,40 -> "XL"
        ,50 -> "L"
        ,60 -> "LX"
        ,70 -> "LXX"
        ,80 -> "LXXX"
        ,90 -> "XC"
        ,100 -> "C"
        ,200 -> "CC"
        ,300 -> "CCC"
        ,400 -> "CD"
        ,500 -> "D"
        ,600 -> "DC"
        ,700 -> "DCC"
        ,800 -> "DCCC"
        ,900 -> "CM"
        ,1000 -> "M"
        ,2000 -> "MM"
        ,3000 -> "MMM"
        ,4000 -> "MMMM"
    )

  }

  def initNumericType(): Map[Int, NumericUnitType.UnitType] = {
    Map(0 -> NumericUnitType.None
      , 1 ->  NumericUnitType.Single
      , 2 ->  NumericUnitType.Tens
      , 3 ->  NumericUnitType.Hundreds
      , 4 -> NumericUnitType.Thousands
    )
  }

  def solution(number: Int): String = {
    var result = ""

    if (number >= 5000) {
      return "OUT_OF_RANGE"
    }

    // CHECK IF NUMBER ALREADY EXISTS IN LIST BEFORE BREAKING IT DOWN
    if (map.exists(_._1 == number)) {
      result = map.get(number).head
    } else {
      result = ""

      // BREAK DOWN NUMBER INTO UNITS AND REITERATE EACH UNIT IN NUMBER.
      // USE EACH UNIT TO GET ROMAN NUMBER, BASED ON MAPPING
      // i.e. 1995 becomes 1000 (Thousands), 900 (Hundreds), 90 (Tens), 5 (Singles)
      var currentNumericString = number.toString
      var numericLength = currentNumericString.length
      var lastIndex = currentNumericString.length - 1
      var numericType = numericTypeMap.get(numericLength).head

      for(currentIndex <- 0 to lastIndex) {
        if (currentNumericString(currentIndex).toString.toInt != 0) {
          var currentRomanNumber = ""
          val currentNumber = currentNumericString(currentIndex).toString.toInt
          val currentFullNumber: Int = getFullNumber(currentNumber, numericType)

          currentRomanNumber = map.get(currentFullNumber).head
          result += currentRomanNumber
        }

        // MOVE TO NEXT UNIT NUMERIC TYPE
        numericLength -= 1
        numericType = numericTypeMap.get(numericLength).head
      }

    }

    result
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
