package co.com.cobaik.users.owners.services

trait OwnersServiceProvider {
  def ownersCommandsService: OwnersCommandsService = OwnersCommandsServiceImpl
}