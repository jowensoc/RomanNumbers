import org.scalatest.funsuite.AnyFunSuite

class RomanNumeralFilterServiceTest extends AnyFunSuite {

  test("Check Singles") {
    assert(RomanNumeralFilterService.solution(1) == "I")
    assert(RomanNumeralFilterService.solution(2) == "II")
    assert(RomanNumeralFilterService.solution(3) == "III")
    assert(RomanNumeralFilterService.solution(4) == "IV")
    assert(RomanNumeralFilterService.solution(5) == "V")
    assert(RomanNumeralFilterService.solution(6) == "VI")
    assert(RomanNumeralFilterService.solution(7) == "VII")
    assert(RomanNumeralFilterService.solution(8) == "VIII")
    assert(RomanNumeralFilterService.solution(9) == "IX")
  }

  test("Check Tens") {
    assert(RomanNumeralFilterService.solution(10) == "X")
    assert(RomanNumeralFilterService.solution(20) == "XX")
    assert(RomanNumeralFilterService.solution(30) == "XXX")
    assert(RomanNumeralFilterService.solution(40) == "XL")
    assert(RomanNumeralFilterService.solution(50) == "L")
    assert(RomanNumeralFilterService.solution(60) == "LX")
    assert(RomanNumeralFilterService.solution(70) == "LXX")
    assert(RomanNumeralFilterService.solution(80) == "LXXX")
    assert(RomanNumeralFilterService.solution(90) == "XC")
  }

  test("Check Hundreds") {
    assert(RomanNumeralFilterService.solution(100) == "C")
    assert(RomanNumeralFilterService.solution(200) == "CC")
    assert(RomanNumeralFilterService.solution(300) == "CCC")
    assert(RomanNumeralFilterService.solution(400) == "CD")
    assert(RomanNumeralFilterService.solution(500) == "D")
    assert(RomanNumeralFilterService.solution(600) == "DC")
    assert(RomanNumeralFilterService.solution(700) == "DCC")
    assert(RomanNumeralFilterService.solution(800) == "DCCC")
    assert(RomanNumeralFilterService.solution(900) == "CM")
  }

  test("Check thousand digits") {
    assert(RomanNumeralFilterService.solution(1000) == "M")
    assert(RomanNumeralFilterService.solution(2000) == "MM")
    assert(RomanNumeralFilterService.solution(3000) == "MMM")
    assert(RomanNumeralFilterService.solution(4000) == "MMMM")
  }

  test("Check Random digits") {
    assert(RomanNumeralFilterService.solution(1995) == "MCMXCV")

    assert(RomanNumeralFilterService.solution(12) == "XII")
    assert(RomanNumeralFilterService.solution(113) == "CXIII")
    assert(RomanNumeralFilterService.solution(115) == "CXV")
    assert(RomanNumeralFilterService.solution(1995) == "MCMXCV")
    assert(RomanNumeralFilterService.solution(2023) == "MMXXIII")
    assert(RomanNumeralFilterService.solution(2123) == "MMCXXIII")
    assert(RomanNumeralFilterService.solution(3125) == "MMMCXXV")
    assert(RomanNumeralFilterService.solution(4251) == "MMMMCCLI")

  }

  test("Out of range") {
    assert(RomanNumeralFilterService.solution(5000) == "OUT_OF_RANGE")
  }

}
