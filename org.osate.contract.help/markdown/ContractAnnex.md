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

Lambdas must end with an expression representing the return value of the lambda. However, it is possible for lambda's to
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

#### Classifier

#### ComponentCategory

#### ComponentInstance

#### ConnectionInstance

#### DoubleRange

#### DoubleRangeWithUnits

#### Double

#### DoubleWithUnits

#### EndToEndFlowInstance

#### InstanceObject

#### List

#### LongRange

#### LongRangeWithUnits

#### Long

#### LongWithUnits

#### ModeInstance

#### ModeTransitionInstance

#### Optional

#### Record

#### String

#### SystemInstance

#### SystemOperationMode

#### Tuple

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
