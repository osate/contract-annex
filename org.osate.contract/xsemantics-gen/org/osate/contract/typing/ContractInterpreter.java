/*******************************************************************************
 * Assurance Contract Annex Plugin for OSATE
 * Copyright 2023 Carnegie Mellon University.
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT
 * NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR
 * RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT MAKE
 * ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.
 * Released under a BSD (SEI)-style license, please see license.txt or contact
 * permission@sei.cmu.edu for full terms.
 * [DISTRIBUTION STATEMENT A] This material has been approved for public release and
 * unlimited distribution.  Please see Copyright notice for non-US Government use and
 * distribution.
 * Carnegie Mellon® is registered in the U.S. Patent and Trademark Office by Carnegie
 * Mellon University.
 * This Software includes and/or makes use of the following Third-Party Software subject
 * to its own license:
 * 1. Z3 (https://github.com/Z3Prover/z3/blob/master/LICENSE.txt) Copyright Microsoft
 * Corporation.
 * 2. Eclipse (https://www.eclipse.org/legal/epl-2.0/) Copyright 2000, 2023 Eclipse
 * contributors and others.
 * DM23-0575
 *******************************************************************************/
package org.osate.contract.typing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.contract.contract.AndExpression;
import org.osate.contract.contract.Expression;
import org.osate.contract.contract.Lambda;
import org.osate.contract.contract.MemberCall;
import org.osate.contract.contract.NameReference;
import org.osate.contract.contract.NotExpression;
import org.osate.contract.contract.OrExpression;
import org.osate.contract.contract.Parameter;
import org.osate.contract.contract.PropertyLookup;
import org.osate.contract.contract.Query;
import org.osate.contract.contract.RootExpression;
import org.osate.contract.contract.SelfExpression;
import org.osate.contract.contract.SingleParameter;
import org.osate.contract.contract.SingleValDeclaration;
import org.osate.contract.contract.TupleDeclaration;
import org.osate.contract.contract.TupleExpression;
import org.osate.contract.contract.TupleName;
import org.osate.contract.contract.TupleParameter;
import org.osate.contract.tuples.Tuple;
import org.osate.pluginsupport.properties.CodeGenUtil;

import com.google.inject.Inject;

@SuppressWarnings("all")
public class ContractInterpreter extends XsemanticsRuntimeSystem {
  public static final String EVALUATESINGLEVALDECLARATION = "org.osate.contract.typing.EvaluateSingleValDeclaration";

  public static final String EVALUATETUPLEDECLARATION = "org.osate.contract.typing.EvaluateTupleDeclaration";

  public static final String EVALUATEOREXPRESSION = "org.osate.contract.typing.EvaluateOrExpression";

  public static final String EVALUATEANDEXPRESSION = "org.osate.contract.typing.EvaluateAndExpression";

  public static final String EVALUATENOTEXPRESSION = "org.osate.contract.typing.EvaluateNotExpression";

  public static final String EVALUATEMEMBERCALL = "org.osate.contract.typing.EvaluateMemberCall";

  public static final String EVALUATEPROPERTYLOOKUP = "org.osate.contract.typing.EvaluatePropertyLookup";

  public static final String EVALUATESELFEXPRESSION = "org.osate.contract.typing.EvaluateSelfExpression";

  public static final String EVALUATEROOTEXPRESSION = "org.osate.contract.typing.EvaluateRootExpression";

  public static final String EVALUATETUPLEEXPRESSION = "org.osate.contract.typing.EvaluateTupleExpression";

  public static final String EVALUATENAMEREFERENCE = "org.osate.contract.typing.EvaluateNameReference";

  @Inject
  private ContractTypeSystem typeSystem;

  private PolymorphicDispatcher<Result<Map<String, Object>>> evaluateQueryDispatcher;

  private PolymorphicDispatcher<Result<Object>> evaluateExpressionDispatcher;

  public ContractInterpreter() {
    init();
  }

  public void init() {
    evaluateQueryDispatcher = buildPolymorphicDispatcher1(
    	"evaluateQueryImpl", 3, "||-", "~>");
    evaluateExpressionDispatcher = buildPolymorphicDispatcher1(
    	"evaluateExpressionImpl", 3, "|-", "~>");
  }

  public ContractTypeSystem getTypeSystem() {
    return this.typeSystem;
  }

  public void setTypeSystem(final ContractTypeSystem typeSystem) {
    this.typeSystem = typeSystem;
  }

  public Result<Map<String, Object>> evaluateQuery(final Query query) {
    return evaluateQuery(new RuleEnvironment(), null, query);
  }

  public Result<Map<String, Object>> evaluateQuery(final RuleEnvironment _environment_, final Query query) {
    return evaluateQuery(_environment_, null, query);
  }

  public Result<Map<String, Object>> evaluateQuery(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Query query) {
    try {
    	return evaluateQueryInternal(_environment_, _trace_, query);
    } catch (Exception _e_evaluateQuery) {
    	return resultForFailure(_e_evaluateQuery);
    }
  }

  public Result<Object> evaluateExpression(final Expression expression) {
    return evaluateExpression(new RuleEnvironment(), null, expression);
  }

  public Result<Object> evaluateExpression(final RuleEnvironment _environment_, final Expression expression) {
    return evaluateExpression(_environment_, null, expression);
  }

  public Result<Object> evaluateExpression(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return evaluateExpressionInternal(_environment_, _trace_, expression);
    } catch (Exception _e_evaluateExpression) {
    	return resultForFailure(_e_evaluateExpression);
    }
  }

  protected Result<Map<String, Object>> evaluateQueryInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Query query) {
    try {
    	checkParamsNotNull(query);
    	return evaluateQueryDispatcher.invoke(_environment_, _trace_, query);
    } catch (Exception _e_evaluateQuery) {
    	sneakyThrowRuleFailedException(_e_evaluateQuery);
    	return null;
    }
  }

  protected void evaluateQueryThrowException(final String _error, final String _issue, final Exception _ex, final Query query, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Object> evaluateExpressionInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return evaluateExpressionDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_evaluateExpression) {
    	sneakyThrowRuleFailedException(_e_evaluateExpression);
    	return null;
    }
  }

  protected void evaluateExpressionThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Map<String, Object>> evaluateQueryImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SingleValDeclaration valDeclaration) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Map<String, Object>> _result_ = applyRuleEvaluateSingleValDeclaration(G, _subtrace_, valDeclaration);
    	addToTrace(_trace_, () -> ruleName("EvaluateSingleValDeclaration") + stringRepForEnv(G) + " ||- " + stringRep(valDeclaration) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateSingleValDeclaration) {
    	evaluateQueryThrowException(ruleName("EvaluateSingleValDeclaration") + stringRepForEnv(G) + " ||- " + stringRep(valDeclaration) + " ~> " + "Map<String, Object>",
    		EVALUATESINGLEVALDECLARATION,
    		e_applyRuleEvaluateSingleValDeclaration, valDeclaration, new ErrorInformation[] {new ErrorInformation(valDeclaration)});
    	return null;
    }
  }

  protected Result<Map<String, Object>> applyRuleEvaluateSingleValDeclaration(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SingleValDeclaration valDeclaration) throws RuleFailedException {
    Map<String, Object> result = null; // output parameter
    /* G |- valDeclaration.value ~> var Object value */
    Expression _value = valDeclaration.getValue();
    Object value = null;
    Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _value);
    checkAssignableTo(result_1.getFirst(), Object.class);
    value = result_1.getFirst();

    String _name = valDeclaration.getName();
    Pair<String, Object> _mappedTo = Pair.<String, Object>of(_name, value);
    result = Collections.<String, Object>unmodifiableMap(CollectionLiterals.<String, Object>newHashMap(_mappedTo));
    return new Result<Map<String, Object>>(result);
  }

  protected Result<Map<String, Object>> evaluateQueryImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleDeclaration tupleDeclaration) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Map<String, Object>> _result_ = applyRuleEvaluateTupleDeclaration(G, _subtrace_, tupleDeclaration);
    	addToTrace(_trace_, () -> ruleName("EvaluateTupleDeclaration") + stringRepForEnv(G) + " ||- " + stringRep(tupleDeclaration) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateTupleDeclaration) {
    	evaluateQueryThrowException(ruleName("EvaluateTupleDeclaration") + stringRepForEnv(G) + " ||- " + stringRep(tupleDeclaration) + " ~> " + "Map<String, Object>",
    		EVALUATETUPLEDECLARATION,
    		e_applyRuleEvaluateTupleDeclaration, tupleDeclaration, new ErrorInformation[] {new ErrorInformation(tupleDeclaration)});
    	return null;
    }
  }

  protected Result<Map<String, Object>> applyRuleEvaluateTupleDeclaration(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleDeclaration tupleDeclaration) throws RuleFailedException {
    Map<String, Object> result = null; // output parameter
    /* G |- tupleDeclaration.value ~> var Tuple tupleResult */
    Expression _value = tupleDeclaration.getValue();
    Tuple tupleResult = null;
    Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _value);
    checkAssignableTo(result_1.getFirst(), Tuple.class);
    tupleResult = (Tuple) result_1.getFirst();

    result = CollectionLiterals.<String, Object>newLinkedHashMap();
    for (int i = 0; (i < tupleDeclaration.getNames().size()); i++) {
      result.put(tupleDeclaration.getNames().get(i).getName(), tupleResult.getElements().get(i));
    }
    return new Result<Map<String, Object>>(result);
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OrExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateOrExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateOrExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateOrExpression) {
    	evaluateExpressionThrowException(ruleName("EvaluateOrExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "Boolean",
    		EVALUATEOREXPRESSION,
    		e_applyRuleEvaluateOrExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateOrExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OrExpression expression) throws RuleFailedException {
    Boolean result = null; // output parameter
    /* G |- expression.left ~> var Boolean leftValue */
    Expression _left = expression.getLeft();
    Boolean leftValue = null;
    Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Boolean.class);
    leftValue = (Boolean) result_1.getFirst();

    if ((leftValue).booleanValue()) {
      result = Boolean.valueOf(true);
    } else {
      /* G |- expression.right ~> var Boolean rightValue */
      Expression _right = expression.getRight();
      Boolean rightValue = null;
      Result<Object> result_2 = evaluateExpressionInternal(G, _trace_, _right);
      checkAssignableTo(result_2.getFirst(), Boolean.class);
      rightValue = (Boolean) result_2.getFirst();

      result = rightValue;
    }
    return new Result<Object>(result);
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateAndExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateAndExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateAndExpression) {
    	evaluateExpressionThrowException(ruleName("EvaluateAndExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "Boolean",
    		EVALUATEANDEXPRESSION,
    		e_applyRuleEvaluateAndExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateAndExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndExpression expression) throws RuleFailedException {
    Boolean result = null; // output parameter
    /* G |- expression.left ~> var Boolean leftValue */
    Expression _left = expression.getLeft();
    Boolean leftValue = null;
    Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Boolean.class);
    leftValue = (Boolean) result_1.getFirst();

    if ((leftValue).booleanValue()) {
      /* G |- expression.right ~> var Boolean rightValue */
      Expression _right = expression.getRight();
      Boolean rightValue = null;
      Result<Object> result_2 = evaluateExpressionInternal(G, _trace_, _right);
      checkAssignableTo(result_2.getFirst(), Boolean.class);
      rightValue = (Boolean) result_2.getFirst();

      result = rightValue;
    } else {
      result = Boolean.valueOf(false);
    }
    return new Result<Object>(result);
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NotExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateNotExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateNotExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateNotExpression) {
    	evaluateExpressionThrowException(ruleName("EvaluateNotExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "Boolean",
    		EVALUATENOTEXPRESSION,
    		e_applyRuleEvaluateNotExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateNotExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NotExpression expression) throws RuleFailedException {
    Boolean result = null; // output parameter
    /* G |- expression.operand ~> var Boolean operandValue */
    Expression _operand = expression.getOperand();
    Boolean operandValue = null;
    Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _operand);
    checkAssignableTo(result_1.getFirst(), Boolean.class);
    operandValue = (Boolean) result_1.getFirst();

    result = Boolean.valueOf((!(operandValue).booleanValue()));
    return new Result<Object>(result);
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MemberCall expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateMemberCall(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateMemberCall") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateMemberCall) {
    	evaluateExpressionThrowException(ruleName("EvaluateMemberCall") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "Object",
    		EVALUATEMEMBERCALL,
    		e_applyRuleEvaluateMemberCall, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateMemberCall(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MemberCall expression) throws RuleFailedException {
    Object result = null; // output parameter
    final Type leftType = this.typeSystem.expressionType(expression.getLeft()).getValue();
    /* G |- expression.left ~> var Object leftValue */
    Expression _left = expression.getLeft();
    Object leftValue = null;
    Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), Object.class);
    leftValue = result_1.getFirst();

    Object _switchResult = null;
    Member _get = leftType.getMembers().get(expression.getRight());
    final Member member = _get;
    boolean _matched = false;
    if (member instanceof SimpleMember) {
      _matched=true;
      _switchResult = ((SimpleMember)member).evaluate(leftValue);
    }
    if (!_matched) {
      if (member instanceof MemberWithArgument) {
        _matched=true;
        _switchResult = ((MemberWithArgument)member).evaluate(leftValue, expression.getArgument());
      }
    }
    if (!_matched) {
      if (member instanceof MemberWithLambda) {
        _matched=true;
        Object _xblockexpression = null;
        {
          final Lambda lambda = expression.getLambda();
          final Parameter parameter = lambda.getParameter();
          final Function<Object, Object> _function = (Object element) -> {
            Object _xblockexpression_1 = null;
            {
              final RuleEnvironment withParameters = new RuleEnvironment(G);
              boolean _matched_1 = false;
              if (parameter instanceof SingleParameter) {
                _matched_1=true;
                withParameters.add(((SingleParameter)parameter).getName(), element);
              }
              if (!_matched_1) {
                if (parameter instanceof TupleParameter) {
                  _matched_1=true;
                  final Tuple tuple = ((Tuple) element);
                  for (int i = 0; (i < ((TupleParameter)parameter).getNames().size()); i++) {
                    /* withParameters.add(parameter.names.get(i).name, tuple.elements.get(i)) */
                    if (!withParameters.add(((TupleParameter)parameter).getNames().get(i).getName(), tuple.getElements().get(i))) {
                      sneakyThrowRuleFailedException("withParameters.add(parameter.names.get(i).name, tuple.elements.get(i))");
                    }
                  }
                }
              }
              /* withParameters |- lambda.returnValue ~> var Object lambdaResult */
              Expression _returnValue = lambda.getReturnValue();
              Object lambdaResult = null;
              Result<Object> result_2 = evaluateExpressionInternal(withParameters, _trace_, _returnValue);
              checkAssignableTo(result_2.getFirst(), Object.class);
              lambdaResult = result_2.getFirst();

              _xblockexpression_1 = lambdaResult;
            }
            return _xblockexpression_1;
          };
          _xblockexpression = (((MemberWithLambda)member).evaluate(leftValue, _function));
        }
        _switchResult = _xblockexpression;
      }
    }
    result = _switchResult;
    return new Result<Object>(result);
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyLookup expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluatePropertyLookup(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluatePropertyLookup") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluatePropertyLookup) {
    	evaluateExpressionThrowException(ruleName("EvaluatePropertyLookup") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "Optional<?>",
    		EVALUATEPROPERTYLOOKUP,
    		e_applyRuleEvaluatePropertyLookup, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluatePropertyLookup(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyLookup expression) throws RuleFailedException {
    Optional<?> result = null; // output parameter
    /* G |- expression.left ~> var NamedElement lookupContext */
    Expression _left = expression.getLeft();
    NamedElement lookupContext = null;
    Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _left);
    checkAssignableTo(result_1.getFirst(), NamedElement.class);
    lookupContext = (NamedElement) result_1.getFirst();

    try {
      final PropertyExpression value = CodeGenUtil.lookupProperty(expression.getRight(), lookupContext, Optional.<Mode>empty());
      final PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, Optional.<Mode>empty());
      result = Optional.<Object>of(TypeSystemUtils.convertPropertyValue(resolved, lookupContext));
    } catch (final Throwable _t) {
      if (_t instanceof PropertyNotPresentException) {
        result = Optional.<Object>empty();
      } else if (_t instanceof PropertyDoesNotApplyToHolderException) {
        result = Optional.<Object>empty();
      } else if (_t instanceof PropertyIsModalException) {
        result = Optional.<Object>empty();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return new Result<Object>(result);
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SelfExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateSelfExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateSelfExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateSelfExpression) {
    	evaluateExpressionThrowException(ruleName("EvaluateSelfExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "ComponentInstance",
    		EVALUATESELFEXPRESSION,
    		e_applyRuleEvaluateSelfExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateSelfExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SelfExpression expression) throws RuleFailedException {

    return new Result<Object>(_applyRuleEvaluateSelfExpression_1(G, expression));
  }

  private ComponentInstance _applyRuleEvaluateSelfExpression_1(final RuleEnvironment G, final SelfExpression expression) throws RuleFailedException {
    ComponentInstance _env = this.<ComponentInstance>env(G, "self", ComponentInstance.class);
    return _env;
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RootExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateRootExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateRootExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateRootExpression) {
    	evaluateExpressionThrowException(ruleName("EvaluateRootExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "SystemInstance",
    		EVALUATEROOTEXPRESSION,
    		e_applyRuleEvaluateRootExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateRootExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RootExpression expression) throws RuleFailedException {

    return new Result<Object>(_applyRuleEvaluateRootExpression_1(G, expression));
  }

  private SystemInstance _applyRuleEvaluateRootExpression_1(final RuleEnvironment G, final RootExpression expression) throws RuleFailedException {
    SystemInstance _containerOfType = EcoreUtil2.<SystemInstance>getContainerOfType(this.<ComponentInstance>env(G, "self", ComponentInstance.class), SystemInstance.class);
    return _containerOfType;
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateTupleExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateTupleExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateTupleExpression) {
    	evaluateExpressionThrowException(ruleName("EvaluateTupleExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "Tuple",
    		EVALUATETUPLEEXPRESSION,
    		e_applyRuleEvaluateTupleExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateTupleExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleExpression expression) throws RuleFailedException {
    Tuple result = null; // output parameter
    final ArrayList<Object> elementResults = CollectionLiterals.<Object>newArrayList();
    EList<Expression> _elements = expression.getElements();
    for (final Expression element : _elements) {
      /* G |- element ~> var Object elementResult */
      Object elementResult = null;
      Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, element);
      checkAssignableTo(result_1.getFirst(), Object.class);
      elementResult = result_1.getFirst();

      /* elementResults += elementResult */
      if (!elementResults.add(elementResult)) {
        sneakyThrowRuleFailedException("elementResults += elementResult");
      }
    }
    Tuple _tuple = new Tuple(elementResults);
    result = _tuple;
    return new Result<Object>(result);
  }

  protected Result<Object> evaluateExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NameReference expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Object> _result_ = applyRuleEvaluateNameReference(G, _subtrace_, expression);
    	addToTrace(_trace_, () -> ruleName("EvaluateNameReference") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst()));
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEvaluateNameReference) {
    	evaluateExpressionThrowException(ruleName("EvaluateNameReference") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "Object",
    		EVALUATENAMEREFERENCE,
    		e_applyRuleEvaluateNameReference, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Object> applyRuleEvaluateNameReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NameReference expression) throws RuleFailedException {
    Object result = null; // output parameter
    final NamedElement named = expression.getReference();
    boolean _matched = false;
    if (named instanceof SingleParameter) {
      _matched=true;
    }
    if (!_matched) {
      if (named instanceof TupleName) {
        EObject _eContainer = ((TupleName)named).eContainer();
        if ((_eContainer instanceof TupleParameter)) {
          _matched=true;
        }
      }
    }
    if (_matched) {
      result = this.<Object>env(G, named.getName(), Object.class);
    }
    if (!_matched) {
      if (named instanceof SingleValDeclaration) {
        _matched=true;
        /* G |- named.value ~> result */
        Expression _value = ((SingleValDeclaration)named).getValue();
        Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _value);
        checkAssignableTo(result_1.getFirst(), Object.class);
        result = result_1.getFirst();

      }
    }
    if (!_matched) {
      if (named instanceof TupleName) {
        _matched=true;
        final TupleDeclaration tupleDeclaration = EcoreUtil2.<TupleDeclaration>getContainerOfType(named, TupleDeclaration.class);
        /* G |- tupleDeclaration.value ~> var Tuple tupleResult */
        Expression _value = tupleDeclaration.getValue();
        Tuple tupleResult = null;
        Result<Object> result_1 = evaluateExpressionInternal(G, _trace_, _value);
        checkAssignableTo(result_1.getFirst(), Tuple.class);
        tupleResult = (Tuple) result_1.getFirst();

        final int index = tupleDeclaration.getNames().indexOf(named);
        result = tupleResult.getElements().get(index);
      }
    }
    return new Result<Object>(result);
  }
}
