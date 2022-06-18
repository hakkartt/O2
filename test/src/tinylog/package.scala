

package object tinylog {
  
  abstract class Gate()
  {
    def value: Boolean     // implemented by the extending classes
  }
  
  class InputElement() extends Gate()
  {
    var v = false                         // default value is false
    def set(s: Boolean) { v = s }
    def value = v
  }
  
  class NotGate(in: Gate) extends Gate()
  {
    def value = !in.value
  }
  
  class OrGate(in1: Gate, in2: Gate) extends Gate()
  {
    def value = in1.value || in2.value
  }
  
  class AndGate(in1: Gate, in2: Gate) extends Gate()
  {
    def value = in1.value && in2.value
  }
  
  class ConstantGate(v: Boolean) extends Gate()
  {
    def value = v
  }
  
  object Gate {
    val False = new ConstantGate(false)
    val True  = new ConstantGate(true)
  }
    
}