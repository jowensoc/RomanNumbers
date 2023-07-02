package models

object NumericUnitType extends Enumeration {
  type UnitType = Value

  val None, Single, Tens, Hundreds, Thousands = Value
}
