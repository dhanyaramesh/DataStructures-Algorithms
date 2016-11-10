@startuml
skinparam classAttributeIconSize 0
interface Component{
+operation(String
}
class ConcreteComponent{
+operation(String
}
class ConcreteDecoratorA{
-addedState:String
+ConcreteDecoratorA(c:Component)
+operation(String
}
class ConcreteDecoratorB{
-addedState:String
+ConcreteDecoratorB(c:Component)
+operation(String
}
class Decorator{
+Decorator(c:Component)
+operation(String
}
class Tester{
+main(args:String[]):void
}
Component <|.. ConcreteComponent
Decorator <|-- ConcreteDecoratorA
ConcreteDecoratorA ..> Component:use
Decorator <|-- ConcreteDecoratorB
ConcreteDecoratorB ..> Component:use
Component <|.. Decorator
Decorator ..> Component:use
Component "1"  -- Decorator
@enduml
