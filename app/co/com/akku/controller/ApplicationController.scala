package co.com.akku.controllers

import play.api.mvc.{AnyContent, Action, Controller}

class ApplicationController extends Controller {

  def options(path:String): Action[AnyContent] = Action { Ok("")}

}
