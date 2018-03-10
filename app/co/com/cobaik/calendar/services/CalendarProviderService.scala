package co.com.cobaik.calendar.services


trait CalendarProviderService {
  def calendarService : CalendarCommandService = CalendarCommandServiceImpl
}
