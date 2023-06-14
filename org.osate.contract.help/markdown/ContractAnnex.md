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

### Self

### Root

### Tuples

### Property Lookup

### Member Calls

### Types

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
