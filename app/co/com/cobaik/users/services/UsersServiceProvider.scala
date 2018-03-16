package co.com.cobaik.users.services

trait UsersServiceProvider {
  def usersQueriesService : UsersQueriesService = UsersQueriesServiceImpl
}
