<!---
    Assurance Contract Annex Plugin for OSATE
    Copyright 2023 Carnegie Mellon University.
    NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE 
    MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO 
    WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT 
    NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR 
    RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE 
    ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
    INFRINGEMENT.
    Released under a BSD (SEI)-style license, please see license.txt or contact 
    permission@sei.cmu.edu for full terms.
    [DISTRIBUTION STATEMENT A] This material has been approved for public release and 
    unlimited distribution.  Please see Copyright notice for non-US Government use and 
    distribution.
    Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie 
    Mellon University.
    This Software includes and/or makes use of the following Third-Party Software subject 
    to its own license:
    1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft 
    Corporation.
    2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse 
    contributors and others.
    DM23-0575
 -->

# Contract Annex

[TOC levels=2-4 bullet hierarchy]

## Query Language

The query language is a textual language used to extract values from the instance model. These values are intended to be
used in other parts of the Contract Annex. The design of the query langauge has been inspired by functional and
functional-like programming languages with the syntax primarily inspired by Kotlin. As a result, the primary way of
building values is through the filter and map functions, which should be familiar to anyone who has used Java streams,
Xtend, Kotlin, Scala, Swift, Rust, etc. The following is an example of a query that gets a list of the names of all of
the threads in a system:

```
package test_queries
public
  annex contract {**
    assurance contract exampleContract {
      queries
        val threadNames = self.allSubcomponents
          .filter { subcomponent -> subcomponent.isThread }
          .map { thread -> thread.name };
    }
  **};
end test_queries;
```

In this example, the value `threadNames` will have the type `List<String>` and it will contain the names of all of the
threads that are directly and indirectly contained in a component.

### Libraries and Subclauses

The queries themselves are contained in a Contract Library. The queries are meant to be reusable and operate on any
component that is passed in.

Currently, the association of queries and a particular component occurs in a Contract Subclause. This will probably
change at some point, but it is the current mechanism for passing a component to a query. Consider the following
example:

```
package test_queries
public
  annex contract {**
    assurance contract exampleContract {
      queries
        val threadNames = self.allSubcomponents
          .filter { subcomponent -> subcomponent.isThread }
          .map { thread -> thread.name };
    }
  **};

  system s
    annex contract {**
      use test_queries::exampleContract
    **};
  end s;

  system implementation s.i
    subcomponents
      ps: process ps.i;
  end s.i;

  process ps
  end ps;

  process implementation ps.i
    subcomponents
      t1: thread t;
      t2: thread t;
  end ps.i;

  thread t
  end t;
end test_queries;
```

In this example, the system `s` contains a Contract Subclause which uses the contract `test_queries::exampleContract`.
When the system implementation `s.i` is instantiated and the Evaluate Queries analysis is run on the resulting instance
model, then the queries in the Contract Library will be evaluated against the component instance for `s.i`.

### Queries (Val Statements)

The fundamental building blocks of the Query Language are `val` statements which bind values to names. Simple `val`
statements take the following form:

```
val <name> = <expression>;
```

The name of each `val` statement must be unique within the `queries` section. The expression on the right side of the
equals sign contains some expression that collects model information from an instance model. The expression can be a
`self` expression, a `root` expression, a tuple literal, a string literal, a property lookup, a member call, an
operation, or a reference to another `val` statement. Expressions can also be more complicated compound expressions such
as a chain of member calls, multiple operations, grouping by parentheses, etc.

If an expression is a tuple, then a `val` statement can be used to destructure the tuple into its separate parts.
Destructuring `val` statements take the following form:

```
val (<name_1>, <name_2>, ..., <name_n>) = <expression>;
```

While it is possible to destructure a tuple expression, this is not required. A tuple can still be assigned to a single
name. The following example demonstates a tuple being assigned to a single name and a tuple being destructured into
multiple names:

```
package test_queries
public
  annex contract {**
    contract exampleContract {
      queries
        val tuple = (self.name, self.category);
        val (name, category) = (self.name, self.category);
    }
  **};

  system s
    annex contract {**
      use test_queries::exampleContract
    **};
  end s;

  system implementation s.i
  end s.i;
end test_queries;
```

In this example, `tuple` has the type `(String, ComponentCategory)` and the value `(s_i_Instance, system)`, `name` has
the type `String` and the value `s_i_Instance`, and `category` has the type `ComponentCategory` and the value `system`.

### Self

A `self` expression returns the `ComponentInstance` that the queries are being operated on. Often times `self` is the
starting point for more complicated queries. For example, the following query starts with a `self` expression and then
calls `name` on `self` to get the name of the `ComponentInstance` that is being operated on:

```
val componentName = self.name;
```

### Root

A `root` expression return the `SystemInstance` that is the root of the `ComponentInstance` that queries are being
operated on. It is possible that `self` and `root` return the same value, but this is not always the case. For example,
if queries are being operated on a thread deeply nested in a system, then `self` would return the thread and `root`
would return the top-level system that contains the thread.

Just like `self`, `root` is often used as the starting point for more complicated queries. For example, the following
query starts with a `root` expression and then calls `allSubcomponents` to get every subcomponent in the entire system:

```
val subcomponents = root.allSubcomponents;
```

### Tuples

Tuple expressions can be used to combine multiple values of possibly different types into a single structured value. A
tuple is constructed by enclosing a sequence of two or more comma-separated values in a pair of parentheses:

```
(<expression_1>, <expression_2>, ..., <expression_n>)
```

The type of a tuple consistes of the types of its elements. For example, the tuple `(self.name, self.category)` has the
type `(String, ComponentCategory)` and the tuple `(self, self.isThread, self.subcomponents)` has the type
`(ComponentInstance, Boolean, List<ComponentInstance>)`.

### Property Lookup

The pound symbol (`#`) is used to lookup properties on objects retreived from the instance model. In essense, `#` can be
considered to be the property lookup operator with an expression on the left side and a property on the right side.
Property lookup takes the following form:

```
<expression>#<property_name>
```

The expression to the left of `#` must result in a type that supports property lookup. Currently, the types that support
property lookup are `ComponentInstance`, `ConnectionInstance`, `EndToEndFlowInstance`, `EventInstance`,
`InstanceObject`, `StateInstance`, and `SystemInstance`.

The property name to the right of `#` can be a fully qualified property name such as `EMV2::StateKind` or an unqualified
property name such as `Period` if the property is in one of the predeclared property sets.

The following is an example of queries with property lookup:

```
val resumption = self#Resumption_Policy;
val periods = self.allSubcomponents
  .filter { subcomponent -> subcomponent.isThread }
  .map { thread -> thread#Period };
```

Property lookup returns an optional type. If the property lookup was successful, then the resulting optional value will
have a value present within it. If property lookup failed, then the resuling optional value will be empty. Property
lookup could fail if the property is not defined for that particular model element, if the property does not apply to
the element, or if the property is defined, but is modal. Currently, the modal property lookup is not supported.

The resulting optional type will wrap another type that is dependent on the property type in AADL. When property lookup
is used, the AADL property type is converted to a type used in the query language. These are the rules governing this
type conversion:

* Lookup on the property type `aadlboolean` results in the query type `Boolean?`.
* Lookup on the property type `aadlstring` results in the query type `String?`.
* Lookup on the property type `classifier` results in the query type `Classifier?`.
* Lookup on the property type `enumeration` results in the query type `Enumeration<EnumerationType>?`.
* Lookup on the property type `aadlinteger` results in the query type `Long?`.
* Lookup on the property type `aadlinteger units UnitsType` results in the query type `LongWithUnits<UnitsType>?`.
* Lookup on the property type `aadlreal` results in the query type `Double?`.
* Lookup on the property type `aadlreal units UnitsType` results in the query type `DoubleWithUnits<UnitsType>?`.
* Lookup on the property type `range of aadlinteger` results in the query type `LongRange?`.
* Lookup on the property type `range of aadlinteger units UnitsType` results in the query type
  `LongRangeWithUnits<UnitsType>?`.
* Lookup on the property type `range of aadlreal` results in the query type `DoubleRange?`.
* Lookup on the property type `range of aadlreal UnitsType` results in the query type
  `DoubleRangeWithUnits<UnitsType>?`.
* Lookup on the property type `record` results in the query type `Record<RecordType>?`.
* Lookup on the property type `reference` results in the query type `InstanceObject?`.
* Lookup on the property type `list of element_type` results in the query type `List<ElementType>?`. These rules are
  applied recursively to convert the element type of the list from an AADL property type to a query type.

### Member Calls

Many of the types in the query language have member functions that can be called. These are used to extract model
information, process lists, process optionals, etc. The dot operator (`.`) is used to call a member function. Calls take
the following form:

```
<expression>.<function_name>
```

The following are examples of simple member calls:

```
val name = self.name;
val subcomponents = self.allSubcomponents;
val numberOfFeatures = self.allFeatures.size;
```

Some member calls take a type argument. Calls with type arguments take the following form:

```
<expression>.<function_name><<type>>
```

Here is an example of a call with a type argument:

```
val features = self#ps::reference_property
  .map { value -> value.filterType<FeatureInstance> };
```

In this example, `filterType` is called on a `List<InstanceObject>` with the type argument `FeatureInstance` and the
call returns a `List<FeatureInstance>`.

Only some of the types in the query language are supported as a type argument. These types include `Boolean`,
`Classifier`, `ComponentCategory`, `ComponentInstance`, `ConnectionInstance`, `Double`, `EndToEndFlowInstance`,
`EventInstance`, `FeatureInstance`, `FlowSpecificationInstance`, `InstanceObject`, `Long`, `ModeInstance`,
`ModeTransitionInstance`, `StateInstance`, `String`, `SystemInstance`, and `SystemOperationMode`.

Some member calls also take arguments. Calls with arguments take the following form:

```
<expression>.<function_name>(<argument>)
```

Here is an example of a call with an argument:

```
val hasSensor = self.allSubcomponents
  .map { subcomponent -> subcomponent.name }
  .contains("sensor");
```

In this example, `contains` is called on a `List<String>` with the argument `"sensor"` and the call returns a `Boolean`.

Some members calls take a lambda as an argument. Lambdas are usually seen on member calls on `List` and optional types.
Calls with lambdas take the following form:

```
<expression>.<function_name> { <lambda_parameter_name> ->
  <optional_val_statements>
  <return_expression>
}
```

The following is an example of calls with lambdas:

```
val threadNames = self.allSubcomponents
  .filter { subcomponent -> subcomponent.isThread }
  .map { thread -> thread.name };
```

This example has two calls with lambdas. In the first example, the lambda has the parameter `subcomponent` which has the
type `ComponentInstance`. The lambda returns a `Boolean` value of true if the subcomponent is a thread and false
otherwise. The function `filter` uses this lambda to create a list of threads.

The second lambda in the above example has the parameter `thread` which has the type `ComponentInstance`. The lambda
returns a `String`, which is the name of the thread. The function `map` uses this lambda to convert a list of threads to
a list of thread names.

Lambdas must end with an expression representing the return value of the lambda. However, it is possible for lambdas to
include other val statements which can be used to create the return value. This is an example of a lambda that contains
val statements:

```
val namesAndCategories = self.allSubcomponents.map { subcomponent ->
  val name = subcomponent.name;
  val category = subcomponent.category;
  (name, category)
}
```

If a lambda's parameter is a tuple, then the parameter can be destructured. Lambda calls with destructured parameters
take the following form:

```
<expression>.<function_name> { (<parameter_name_1>, <parameter_name_2>, ..., <parameter_name_n>) ->
  <optional_val_statements>
  <return_expression>
}
```

The following is an example of destructuring a lambda parameter:

```
val threadsAndProcesses = self.allSubcomponents
  .map { subcomponent -> (self, subcomponent.name, subcomponent.category) }
  .filter { (subcomponent, name, category) -> subcomponent.isThread || subcomponent.isProcess };
```

### Types

The query language is statically typed with type inference. Every val statement and lambda parameter has a type which is
inferred. Explicit typing is not currently supported. The type of a val statement or lambda parameter can be determined
by hovering over its name.

Types in the query langauge are backed by Java types. Some of these are types from the AADL meta-model such as
`ComponentInstance` or `Classifier` and others are standard Java types such as `String`, `Long`, and `List`.

Some of the types support property lookup and many of the types have member functions that can be called. Hovering over
a member call will reveal type information about that call. Consider the following example:

```
val my_name = self.name;
```

In this case, hovering over the function `name` will show the text "`ComponentInstance.name: String`". This shows that
the function `name` is a member of the type `ComponentInstance` and it returns a `String`.

Some types are generic such as `List` and the optional type. When `List` appears as a type in the query language, it is
always a list of a specific type such as `List<ComponentInstance>` or `List<String>`. Hovering over a name that is bound
to a list will show the specific type of the list. Similarly, the optional type is always an optional of a specifc type
such as `ComponentInstance?` or `String?`. Hover text can be espeically helpful when hovering over a function that
returns a generic type. Consider the following example:

```
val names = self.allSubcomponents
  .map { subcomponent -> subcomponent.name };
```

In this case, hovering over the function `map` will show the text "`List<ComponentInstance>.map: List<String>`".

#### Boolean

The `Boolean` type is backed by the Java type `java.lang.Boolean` and has no members.

#### Classifier

The `Classifier` type is backed by the Java type `org.osate.aadl2.Classifier` and has no members.

#### ComponentCategory

The `ComponentCategory` type is backed by the Java type `org.osate.aadl2.ComponentCategory` and has no members.

#### ComponentInstance

The `ComponentInstance` type is backed by the Java type `org.osate.aadl2.instance.ComponentInstance` and has the
following members:
* `name`: Returns the name of the component as a `String`.
* `category`: Returns the category of the component as a `ComponentCategory`.
* `subcomponents`: Returns a `List<ComponentInstance>` with the immediate subcomponents of the component.
* `allSubcomponents`: Returns a `List<ComponentInstance>` with all of the subcomponents that are directly or indirectly
  contained by the component.
* `allComponents`: Returns a `List<ComponentInstance>` with all of the components that are part of the containment
  hierarchy starting with the component that `allComponents` is called on. This is similar to `allSubcomponents` except
  that the resulting list also has the component that `allComponents` is called on as well.
* `features`: Returns a `List<FeatureInstance>` with the immediate features of the component.
* `allFeatures`: Returns a `List<FeatureInstance>` with all of the features that are directly or indirectly contained by
  the component.
* `localModes`: Returns a `List<ModeInstance>` with the immediate modes of the component.
* `allModes`: Returns `List<ModeInstance>` with all of the modes that are directly or indirectly contained by the
  component.
* `modeTransitions`: Returns a `List<ModeTransitionInstance>` with the immediate mode transitions of the component.
* `allModeTransitions`: Returns a `List<ModeTransitionInstance>` with all of the mode transitions that are directly or
  indirectly contained by the component.
* `flowSpecifications`: Returns a `List<FlowSpecificationInstance>` with the immediate flow specifications of the
  component.
* `allFlowSpecifications`: Returns a `List<FlowSpecificationInstance>` with all of the flow specifications that are
  directly or indirectly contained by the component.
* `endToEndFlows`: Returns a `List<EndToEndFlowInstance>` with the immediate end to end flows of the component.
* `allEndToEndFlows`: Returns a `List<EndToEndFlowInstance>` with all of the end to end flows that are directly or
  indirectly contained by the component.
* `connections`: Returns a `List<ConnectionInstance>` with the immediate connections of the component.
* `allConnections`: Returns a `List<ConnectionInstance>` with all of the connections that are directly or indirectly
  contained by the component.
* `inModes`: Returns a `List<ModeInstance>` with the modes that the component is active in.
* `parent`: Returns the container of the component as a `ComponentInstance?`. If the component is the root component and
  does not have a parent, then an empty optional is returned.
* `isAbstract`: Returns a `Boolean` indicating if the component is an abstract.
* `isBus`: Returns a `Boolean` indicating if the component is a bus.
* `isData`: Returns a `Boolean` indicating if the component is a data.
* `isDevice`: Returns a `Boolean` indicating if the component is a device.
* `isMemory`: Returns a `Boolean` indicating if the component is a memory.
* `isProcess`: Returns a `Boolean` indicating if the component is a process.
* `isProcessor`: Returns a `Boolean` indicating if the component is a processor.
* `isSubprogram`: Returns a `Boolean` indicating if the component is a subprogram.
* `isSubprogramGroup`: Returns a `Boolean` indicating if the component is a subprogram group.
* `isSystem`: Returns a `Boolean` indicating if the component is a system.
* `isThread`: Returns a `Boolean` indicating if the component is a thread.
* `isThreadGroup`: Returns a `Boolean` indicating if the component is a thread group.
* `isVirtualBus`: Returns a `Boolean` indicating if the component is a virtual bus.
* `isVirtualProcessor`: Returns a `Boolean` indicating if the component is a virtual processor.
* `processorBindingSources`: Returns a `List<ComponentInstance>` with all of the components that refer to this component
  via the `Deployment_Properties::Actual_Processor_Binding` property. This will typically be a list of threads that are
  bound to this component, assuming that this component is a processor.
* `states`: Returns a `List<StateInstance>` with all of the error behavior states of the component.
* `events`: Returns a `List<EventInstance>` with all of the error behavior events of the component.

#### ConnectionInstance

The `ConnectionInstance` type is backed by the Java type `org.osate.aadl2.instance.ConnectionInstance` and has the
following members:
* `name`: Returns the name of the connection as a `String`.
* `source`: Returns the source of the connection as a `ConnectionInstanceEnd`.
* `destination`: Returns the destination of the connection as a `ConnectionInstanceEnd`.
* `allEndPoints`: Returns all of the end points that make up the entire semantic connection. This includes the ultimate
  source and destination as well as all of the sources and destinations of the up and down connections that contribute
  to the semantic connection. Returns a `List<ConnectionInstanceEnd>`.

#### DoubleRange

The `DoubleRange` type is backed by the Java type `org.osate.contract.typing.RangeValueHolder` and has the following
members:
* `minimum`: Returns the minimum value of the range as a `Double`.
* `maximum`: Returns the maximum value of the range as a `Double`.
* `getDelta`: Returns the delta value of the range as a `Double`.

#### DoubleRangeWithUnits

TODO

#### Double

The `Double` type is backed by the Java type `java.lang.Double` and has no members.

#### DoubleWithUnits

TODO

#### EndToEndFlowInstance

The `EndToEndFlowInstance` type is backed by the Java type `org.osate.aadl2.instance.EndToEndFlowInstance` and has the
following members:
* `name`: Returns the name of the end to end flow as a `String`.
* `flowSpecifications`: Returns a `List<FlowSpecificationInstance>` with all of the flow specifications that make up the
  end to end flow. This includes the flow specifcations that are listed in the end to end flow's declaration as well as
  the flow specifications that make up any other end to end flows that are listed in the current end to end flow's
  declaration.
* `connections`: Returns a `List<ConnectionInstance>` with all of the connections that make up the end to end flow. This
  includes the connections that are listed in the end to end flow's declaration as well as the connections that make up
  any other end to end flows that are listed in the current end to end flow's declaration.
* `components`: Returns a `List<ComponentInstance>` with all of the components that make up the end to end flow. This
  includes the components that are listed in the end to end flow's declaration, the components that contain the flow
  specifications that are listed in the end to end flow's declaration, as well as the components that make up any other
  end to end flows that are listed in the current end to end flow's declaration.

#### Enumeration

TODO

#### EventInstance

The `EventInstance` type is backed by the Java type `org.osate.aadl2.errormodel.instance.EventInstance` and has the
following members:
* `name`: Returns the name of the event as a `String`.

#### FeatureInstance

The `FeatureInstance` type is backed by the Java type `org.osate.aadl2.instance.FeatureInstance` and has no members.

#### FlowSpecificationInstance

The `FlowSpecificationInstance` type is backed by the Java type `org.osate.aadl2.instance.FlowSpecificationInstance` and
has no members.

#### InstanceObject

The `InstanceObject` type is backed by the Java type `org.osate.aadl2.instance.InstanceObject` and has no members.

#### List

The `List` type is backed by the Java type `java.util.List`. `List` has a generic type which represents the type of the
elements of the list. A query or parameter with the type `List` will have its generic type specified such as
`List<ComponentInstance>` or `List<String>`. `List` has the following members:

* `size`: Returns the size of the list as a `Long`.
* `empty`: Returns a `Boolean` indicating if the list is empty.
* `first`: If the list has elements, returns the first element as an optional with a value. If the list is empty, then
  an empty optional is returned. The return type is dependent on the element type of the list. For example, if the list
  has the type `List<ComponentInstance>`, then calling `first` will result in a `ComponentInstance?`.
* `filter`: Filters the elements of the list based upon a predicate which is passed as a lambda to `filter`. Each
  element of the list is passed to the lambda and the lambda must return a `Boolean` indicating if the element should be
  included in the resulting list. `filter` returns a list with the same type as the original list. For example, if the
  type of the original list is `List<ComponentInstance>`, then the result will be a `List<ComponentInstance>`.
* `filterType`: Filters the elements of the list that are instances of the specified type argument. Returns a list with
  an element type based on the type argument. For example, if the type of the original list is `List<InstanceObject>`
  and the specified type argument is `ComponentInstance`, then the resulting list will have the type
  `List<ComponentInstance>`.
* `map`: Returns a new list with all of the elements of the original list transformed by the lambda passed to `map`. The
  element type of the resulting list is based on the return type of the lambda. For example, if the type of the original
  list is `List<ComponentInstance>` and the lambda gets the name of each component, then the resulting list will have
  the type `List<String>`.
* `mapPresent`: `mapPresent` works like `map` except that the lambda must return an optional. In addition to
  transforming values, `mapPresent` also filters those values by only including the ones that are present. The return
  type is a list in which the element type is a non-optional type based on the lambda's return type. For example, the
  expression `components.mapPresent { c -> c#Queue_Size }` returns a `List<Long>`.
* `contains`: Returns a `Boolean` indicating if the list contains a specified element. The element is passed as a
  parameter to `contains`.

The following members only apply to lists that have an optional element type such as `List<ComponentInstance?>` or
`List<String?>`:

* `filterPresent`: Filters the optional elements of the list that have a value. Empty elements are filtered out. Returns
  a list with a non-optional element type. For example, if the type of the original list is `List<ComponentInstance?>`,
  then the resulting list will have the type `List<ComponentInstance>`.

The following members only apply to lists that have tuples with at least on optional in the tuple such as
`List<(String, Long?)>`:

* `filterTupleElementsPresent`: Filters the elements of the list in which all fields of the tuple have values. If at
least one tuple field does not have a value, then that tuple is filtered out and it is not included in the resulting
list. The return type is the same as the original list except with all of the optional types unwrapped. For example, if
the original list is `List<(String, Long?)>`, then the resulting list will have the type `List<(String, Long)>`.

#### LongRange

The `LongRange` type is backed by the Java type `org.osate.contract.typing.RangeValueHolder` and has the following
members:
* `minimum`: Returns the minimum value of the range as a `Long`.
* `maximum`: Returns the maximum value of the range as a `Long`.
* `getDelta`: Returns the detla value of the range as a `Long`.

#### LongRangeWithUnits

TODO

#### Long

The `Long` type is backed by the Java type `java.lang.Long` and has no members.

#### LongWithUnits

TODO

#### ModeInstance

The `ModeInstance` type is backed by the Java type `org.osate.aadl2.instance.ModeInstance` and has no members.

#### ModeTransitionInstance

The `ModeTransitionInstance` type is backed by the Java type `org.osate.aadl2.instance.ModeTransitionInstance` and has
no members.

#### Optional

The optional type is backed by the Java type `java.util.Optional` and represents a value that might or might not be
present. Optional types appear with a question mark appended to the end of another type such as `ComponentInstance?` or
`String?`. It is possible to nest optionals and lists. For example, the type `List<ComponentInstance?>?` is an optional
list of optional components. The optional type has the following members:

* `isEmpty`: Returns a `Boolean` indicating if a value is not present.
* `filterType`: If the optional has a value and the value is an instance of the specified type argument, then
  `filterType` returns a new optional with the same value. If the optional is empty or if the optional has a value, but
  the value is not an instance of the specified type argument, then `filterType` returns an empty optional. The type of
  the resulting optional is based on the type argument. For example, if the type of the original optional is
  `InstanceObject?` and the type argument is `ComponentInstance`, then the resulting optional will have the type
  `ComponentInstance?`.
* `map`: If the optional has a value, then `map` returns a new optional with a value that was transformed by the lambda
  passed to `map`. If the optional does not have a value, then `map` returns an empty optional. The specific type of the
  resulting optional is based on the return type of the lambda. For example, if the type of the original optional is
  `ComponentInstance?` and the lambda gets the name of the component, then the resulting optional will have the type
  `String?`.
* `flatMap`: `flatMap` works like `map` except that the lambda must return an optional itself. `flatMap` is useful to
  avoid deep nesting of optional values. For example, the expression `optionalComponent.map { c -> c#Queue_Size }`
  returns a `Long??` while the expression `optionalComponent.flatMap { c -> c#Queue_Size }` returns a `Long?`.

#### Record

TODO

#### StateInstance

The `StateInstance` type is backed by the Java type `org.osate.aadl2.errormodel.instance.StateInstance` and has the
following members:
* `name`: Returns the name of the state as a `String`.

#### String

The `String` type is backed by the Java type `java.lang.String` and has no members.

#### SystemInstance

The `SystemInstance` type is backed by the Java type `org.osate.aadl2.instance.SystemInstance` and has the following
members:
* `name`: Returns the name of the component as a `String`.
* `category`: Returns the category of the component as a `ComponentCategory`.
* `subcomponents`: Returns a `List<ComponentInstance>` with the immediate subcomponents of the component.
* `allSubcomponents`: Returns a `List<ComponentInstance>` with all of the subcomponents that are directly or indirectly
  contained by the component.
* `allComponents`: Returns a `List<ComponentInstance>` with all of the components that are part of the containment
  hierarchy starting with the component that `allComponents` is called on. This is similar to `allSubcomponents` except
  that the resulting list also has the component that `allComponents` is called on as well.
* `features`: Returns a `List<FeatureInstance>` with the immediate features of the component.
* `allFeatures`: Returns a `List<FeatureInstance>` with all of the features that are directly or indirectly contained by
  the component.
* `localModes`: Returns a `List<ModeInstance>` with the immediate modes of the component.
* `allModes`: Returns `List<ModeInstance>` with all of the modes that are directly or indirectly contained by the
  component.
* `modeTransitions`: Returns a `List<ModeTransitionInstance>` with the immediate mode transitions of the component.
* `allModeTransitions`: Returns a `List<ModeTransitionInstance>` with all of the mode transitions that are directly or
  indirectly contained by the component.
* `flowSpecifications`: Returns a `List<FlowSpecificationInstance>` with the immediate flow specifications of the
  component.
* `allFlowSpecifications`: Returns a `List<FlowSpecificationInstance>` with all of the flow specifications that are
  directly or indirectly contained by the component.
* `endToEndFlows`: Returns a `List<EndToEndFlowInstance>` with the immediate end to end flows of the component.
* `allEndToEndFlows`: Returns a `List<EndToEndFlowInstance>` with all of the end to end flows that are directly or
  indirectly contained by the component.
* `connections`: Returns a `List<ConnectionInstance>` with the immediate connections of the component.
* `allConnections`: Returns a `List<ConnectionInstance>` with all of the connections that are directly or indirectly
  contained by the component.
* `systemOperationModes`: Returns a `List<SystemOperationMode>` with all of the system operation modes of the component.
* `isAbstract`: Returns a `Boolean` indicating if the component is an abstract.
* `isBus`: Returns a `Boolean` indicating if the component is a bus.
* `isData`: Returns a `Boolean` indicating if the component is a data.
* `isDevice`: Returns a `Boolean` indicating if the component is a device.
* `isMemory`: Returns a `Boolean` indicating if the component is a memory.
* `isProcess`: Returns a `Boolean` indicating if the component is a process.
* `isProcessor`: Returns a `Boolean` indicating if the component is a processor.
* `isSubprogram`: Returns a `Boolean` indicating if the component is a subprogram.
* `isSubprogramGroup`: Returns a `Boolean` indicating if the component is a subprogram group.
* `isSystem`: Returns a `Boolean` indicating if the component is a system.
* `isThread`: Returns a `Boolean` indicating if the component is a thread.
* `isThreadGroup`: Returns a `Boolean` indicating if the component is a thread group.
* `isVirtualBus`: Returns a `Boolean` indicating if the component is a virtual bus.
* `isVirtualProcessor`: Returns a `Boolean` indicating if the component is a virtual processor.
* `states`: Returns a `List<StateInstance>` with all of the error behavior states of the component.
* `events`: Returns a `List<EventInstance>` with all of the error behavior events of the component.

#### SystemOperationMode

The `SystemOperationMode` type is backed by the Java type `org.osate.aadl2.instance.SystemOperationMode` and has no
members.

#### Tuple

TODO

---

Assurance Contract Annex Plugin for OSATE

Copyright 2023 Carnegie Mellon University.

NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE 
MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO 
WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT 
NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR 
RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE 
ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT 
INFRINGEMENT.

Released under a BSD (SEI)-style license, please see license.txt or contact 
permission@sei.cmu.edu for full terms.

[DISTRIBUTION STATEMENT A] This material has been approved for public release and 
unlimited distribution.  Please see Copyright notice for non-US Government use and 
distribution.

Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie 
Mellon University.

This Software includes and/or makes use of the following Third-Party Software subject 
to its own license:

1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft 
   Corporation.
2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse 
   contributors and others.

DM23-0575
