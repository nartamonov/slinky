package slinky.core

import slinky.readwrite.Reader

import scala.scalajs.js
import scala.scalajs.js.ConstructorTag

import scala.language.implicitConversions

@js.native
trait ReactComponentClass extends js.Object

object ReactComponentClass {
  implicit def wrapperToClass[T <: BaseComponentWrapper](wrapper: T)
                                                        (implicit propsReader: Reader[wrapper.Props],
                                                         ctag: ConstructorTag[wrapper.Def]): ReactComponentClass = {
    wrapper.componentConstructor(propsReader, null, null, ctag).asInstanceOf[ReactComponentClass]
  }
}