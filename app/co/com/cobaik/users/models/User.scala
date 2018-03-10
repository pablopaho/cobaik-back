package co.com.cobaik.users.models

sealed trait UserV2 {

  def id                  : Int
  def email               : String
  def firstName           : String
  def lastName            : String
  def identificationType  : String
  def identificationNumber: String

}

final case class OwnerV2() extends UserV2 {
  def id                  = ???
  def email               = ???
  def firstName           = ???
  def lastName            = ???
  def identificationType  = ???
  def identificationNumber= ???
}

final case class Renter() extends UserV2 {
  def id                  = ???
  def email               = ???
  def firstName           = ???
  def lastName            = ???
  def identificationType  = ???
  def identificationNumber= ???
}

case class User(id: Int, email: String, firstName: String, lastName: String, identificationType: String,
                identificationNumber: String)
