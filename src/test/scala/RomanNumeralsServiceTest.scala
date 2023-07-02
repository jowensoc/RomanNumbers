
import org.scalatest.funsuite.AnyFunSuite

class RomanNumeralsServiceTest extends AnyFunSuite {

  // need to check if results are accurate?
  // go to https://www.romannumerals.org/converter
  test("Check Singles") {
    assert(RomanNumeralsService.solution(1) == "I")
    assert(RomanNumeralsService.solution(2) == "II")
    assert(RomanNumeralsService.solution(3) == "III")
    assert(RomanNumeralsService.solution(4) == "IV")
    assert(RomanNumeralsService.solution(5) == "V")
    assert(RomanNumeralsService.solution(6) == "VI")
    assert(RomanNumeralsService.solution(7) == "VII")
    assert(RomanNumeralsService.solution(8) == "VIII")
    assert(RomanNumeralsService.solution(9) == "IX")
  }

  test("Check Tens") {
    assert(RomanNumeralsService.solution(10) == "X")
    assert(RomanNumeralsService.solution(20) == "XX")
    assert(RomanNumeralsService.solution(30) == "XXX")
    assert(RomanNumeralsService.solution(40) == "XL")
    assert(RomanNumeralsService.solution(50) == "L")
    assert(RomanNumeralsService.solution(60) == "LX")
    assert(RomanNumeralsService.solution(70) == "LXX")
    assert(RomanNumeralsService.solution(80) == "LXXX")
    assert(RomanNumeralsService.solution(90) == "XC")
  }

  test("Check Hundreds") {
    assert(RomanNumeralsService.solution(100) == "C")
    assert(RomanNumeralsService.solution(200) == "CC")
    assert(RomanNumeralsService.solution(300) == "CCC")
    assert(RomanNumeralsService.solution(400) == "CD")
    assert(RomanNumeralsService.solution(500) == "D")
    assert(RomanNumeralsService.solution(600) == "DC")
    assert(RomanNumeralsService.solution(700) == "DCC")
    assert(RomanNumeralsService.solution(800) == "DCCC")
    assert(RomanNumeralsService.solution(900) == "CM")
  }

  test("Check thousand digits") {
    assert(RomanNumeralsService.solution(1000) == "M")
    assert(RomanNumeralsService.solution(2000) == "MM")
    assert(RomanNumeralsService.solution(3000) == "MMM")
    assert(RomanNumeralsService.solution(4000) == "MMMM")
  }

  test("Check Random digits") {
    assert(RomanNumeralsService.solution(12) == "XII")
    assert(RomanNumeralsService.solution(113) == "CXIII")
    assert(RomanNumeralsService.solution(115) == "CXV")
    assert(RomanNumeralsService.solution(1995) == "MCMXCV")
    assert(RomanNumeralsService.solution(2023) == "MMXXIII")
    assert(RomanNumeralsService.solution(2123) == "MMCXXIII")
    assert(RomanNumeralsService.solution(3125) == "MMMCXXV")
    assert(RomanNumeralsService.solution(4251) == "MMMMCCLI")

  }

  test("Out of range") {
    assert(RomanNumeralsService.solution(5000) == "OUT_OF_RANGE")
  }

}
