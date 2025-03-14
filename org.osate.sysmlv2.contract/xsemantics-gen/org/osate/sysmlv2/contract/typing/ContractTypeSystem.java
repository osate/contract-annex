package org.osate.sysmlv2.contract.typing;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.Map;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.omg.sysml.lang.sysml.Element;
import org.omg.sysml.lang.sysml.Usage;
import org.osate.sysmlv2.contract.contract.AndExpression;
import org.osate.sysmlv2.contract.contract.ContractPackage;
import org.osate.sysmlv2.contract.contract.Expression;
import org.osate.sysmlv2.contract.contract.Lambda;
import org.osate.sysmlv2.contract.contract.MemberCall;
import org.osate.sysmlv2.contract.contract.NameReference;
import org.osate.sysmlv2.contract.contract.NotExpression;
import org.osate.sysmlv2.contract.contract.OrExpression;
import org.osate.sysmlv2.contract.contract.PropertyLookup;
import org.osate.sysmlv2.contract.contract.SelfExpression;
import org.osate.sysmlv2.contract.contract.SingleParameter;
import org.osate.sysmlv2.contract.contract.SingleValDeclaration;
import org.osate.sysmlv2.contract.contract.StringLiteral;
import org.osate.sysmlv2.contract.contract.TupleDeclaration;
import org.osate.sysmlv2.contract.contract.TupleExpression;
import org.osate.sysmlv2.contract.contract.TupleName;
import org.osate.sysmlv2.contract.contract.TupleParameter;
import org.osate.sysmlv2.contract.contract.UsageExpression;

@SuppressWarnings("all")
public class ContractTypeSystem extends XsemanticsRuntimeSystem {
  public static final String OREXPRESSION = "org.osate.sysmlv2.contract.typing.OrExpression";

  public static final String ANDEXPRESSION = "org.osate.sysmlv2.contract.typing.AndExpression";

  public static final String NOTEXPRESSION = "org.osate.sysmlv2.contract.typing.NotExpression";

  public static final String MEMBERCALL = "org.osate.sysmlv2.contract.typing.MemberCall";

  public static final String PROPERTYLOOKUP = "org.osate.sysmlv2.contract.typing.PropertyLookup";

  public static final String SELFEXPRESSION = "org.osate.sysmlv2.contract.typing.SelfExpression";

  public static final String STRINGLITERAL = "org.osate.sysmlv2.contract.typing.StringLiteral";

  public static final String TUPLEEXPRESSION = "org.osate.sysmlv2.contract.typing.TupleExpression";

  public static final String NAMEREFERENCE = "org.osate.sysmlv2.contract.typing.NameReference";

  public static final String USAGEEXPRESSION = "org.osate.sysmlv2.contract.typing.UsageExpression";

  public static final String SINGLEVALDECLARATION = "org.osate.sysmlv2.contract.typing.SingleValDeclaration";

  public static final String TUPLENAME = "org.osate.sysmlv2.contract.typing.TupleName";

  public static final String SINGLEPARAMETER = "org.osate.sysmlv2.contract.typing.SingleParameter";

  private PolymorphicDispatcher<Result<Type>> expressionTypeDispatcher;

  private PolymorphicDispatcher<Result<Type>> namedTypeDispatcher;

  public ContractTypeSystem() {
    init();
  }

  public void init() {
    expressionTypeDispatcher = buildPolymorphicDispatcher1(
    	"expressionTypeImpl", 3, "|-", ":");
    namedTypeDispatcher = buildPolymorphicDispatcher1(
    	"namedTypeImpl", 3, "||-", ":");
  }

  public Result<Type> expressionType(final Expression expression) {
    return expressionType(new RuleEnvironment(), null, expression);
  }

  public Result<Type> expressionType(final RuleEnvironment _environment_, final Expression expression) {
    return expressionType(_environment_, null, expression);
  }

  public Result<Type> expressionType(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return expressionTypeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_expressionType) {
    	return resultForFailure(_e_expressionType);
    }
  }

  public Result<Type> namedType(final Element named) {
    return namedType(new RuleEnvironment(), null, named);
  }

  public Result<Type> namedType(final RuleEnvironment _environment_, final Element named) {
    return namedType(_environment_, null, named);
  }

  public Result<Type> namedType(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Element named) {
    try {
    	return namedTypeInternal(_environment_, _trace_, named);
    } catch (Exception _e_namedType) {
    	return resultForFailure(_e_namedType);
    }
  }

  public Result<Boolean> checkOrExpression(final OrExpression expression) {
    return checkOrExpression(null, expression);
  }

  public Result<Boolean> checkOrExpression(final RuleApplicationTrace _trace_, final OrExpression expression) {
    try {
    	return checkOrExpressionInternal(_trace_, expression);
    } catch (Exception _e_CheckOrExpression) {
    	return resultForFailure(_e_CheckOrExpression);
    }
  }

  protected Result<Boolean> checkOrExpressionInternal(final RuleApplicationTrace _trace_, final OrExpression expression) throws RuleFailedException {
    /* empty |- expression.left : var Type leftType */
    Expression _left = expression.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    /* empty |- expression.right : var Type rightType */
    Expression _right = expression.getRight();
    Type rightType = null;
    Result<Type> result_1 = expressionTypeInternal(emptyEnvironment(), _trace_, _right);
    checkAssignableTo(result_1.getFirst(), Type.class);
    rightType = (Type) result_1.getFirst();
    
    if ((((leftType != null) && (rightType != null)) && ((!(leftType instanceof BooleanType)) || (!(rightType instanceof BooleanType))))) {
      /* fail error "The operator || is undefined for the argument types " + leftType + ", " + rightType source expression */
      String error = ((("The operator || is undefined for the argument types " + leftType) + ", ") + rightType);
      EObject source = expression;
      throwForExplicitFail(error, new ErrorInformation(source, null));
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkAndExpression(final AndExpression expression) {
    return checkAndExpression(null, expression);
  }

  public Result<Boolean> checkAndExpression(final RuleApplicationTrace _trace_, final AndExpression expression) {
    try {
    	return checkAndExpressionInternal(_trace_, expression);
    } catch (Exception _e_CheckAndExpression) {
    	return resultForFailure(_e_CheckAndExpression);
    }
  }

  protected Result<Boolean> checkAndExpressionInternal(final RuleApplicationTrace _trace_, final AndExpression expression) throws RuleFailedException {
    /* empty |- expression.left : var Type leftType */
    Expression _left = expression.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    /* empty |- expression.right : var Type rightType */
    Expression _right = expression.getRight();
    Type rightType = null;
    Result<Type> result_1 = expressionTypeInternal(emptyEnvironment(), _trace_, _right);
    checkAssignableTo(result_1.getFirst(), Type.class);
    rightType = (Type) result_1.getFirst();
    
    if ((((leftType != null) && (rightType != null)) && ((!(leftType instanceof BooleanType)) || (!(rightType instanceof BooleanType))))) {
      /* fail error "The operator && is undefined for the argument types " + leftType + ", " + rightType source expression */
      String error = ((("The operator && is undefined for the argument types " + leftType) + ", ") + rightType);
      EObject source = expression;
      throwForExplicitFail(error, new ErrorInformation(source, null));
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkNotExpression(final NotExpression expression) {
    return checkNotExpression(null, expression);
  }

  public Result<Boolean> checkNotExpression(final RuleApplicationTrace _trace_, final NotExpression expression) {
    try {
    	return checkNotExpressionInternal(_trace_, expression);
    } catch (Exception _e_CheckNotExpression) {
    	return resultForFailure(_e_CheckNotExpression);
    }
  }

  protected Result<Boolean> checkNotExpressionInternal(final RuleApplicationTrace _trace_, final NotExpression expression) throws RuleFailedException {
    /* empty |- expression.operand : var Type operandType */
    Expression _operand = expression.getOperand();
    Type operandType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _operand);
    checkAssignableTo(result.getFirst(), Type.class);
    operandType = (Type) result.getFirst();
    
    if (((operandType != null) && (!(operandType instanceof BooleanType)))) {
      /* fail error "The operator ! is undefined for the argument type " + operandType source expression */
      String error = ("The operator ! is undefined for the argument type " + operandType);
      EObject source = expression;
      throwForExplicitFail(error, new ErrorInformation(source, null));
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkMemberCall(final MemberCall expression) {
    return checkMemberCall(null, expression);
  }

  public Result<Boolean> checkMemberCall(final RuleApplicationTrace _trace_, final MemberCall expression) {
    try {
    	return checkMemberCallInternal(_trace_, expression);
    } catch (Exception _e_CheckMemberCall) {
    	return resultForFailure(_e_CheckMemberCall);
    }
  }

  protected Result<Boolean> checkMemberCallInternal(final RuleApplicationTrace _trace_, final MemberCall expression) throws RuleFailedException {
    /* empty |- expression.left : var Type leftType */
    Expression _left = expression.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    if ((leftType != null)) {
      final Member member = leftType.getMembers().get(expression.getRight());
      if ((member == null)) {
        /* fail error "'" + expression.right + "' is not a member of the type " + leftType source expression feature ContractPackage.eINSTANCE.memberCall_Right */
        String _right = expression.getRight();
        String _plus = ("\'" + _right);
        String _plus_1 = (_plus + "\' is not a member of the type ");
        String _plus_2 = (_plus_1 + leftType);
        String error = _plus_2;
        EObject source = expression;
        EAttribute _memberCall_Right = ContractPackage.eINSTANCE.getMemberCall_Right();
        EStructuralFeature feature = _memberCall_Right;
        throwForExplicitFail(error, new ErrorInformation(source, feature));
      } else {
        final boolean expectGenerics = (member instanceof MemberWithTypeParameter);
        if ((expectGenerics && (expression.getTypeArgument() == null))) {
          /* fail error "Type argument expected for call to '" + expression.right + "'" source expression feature ContractPackage.eINSTANCE.memberCall_Right */
          String _right_1 = expression.getRight();
          String _plus_3 = ("Type argument expected for call to \'" + _right_1);
          String _plus_4 = (_plus_3 + "\'");
          String error_1 = _plus_4;
          EObject source_1 = expression;
          EAttribute _memberCall_Right_1 = ContractPackage.eINSTANCE.getMemberCall_Right();
          EStructuralFeature feature_1 = _memberCall_Right_1;
          throwForExplicitFail(error_1, new ErrorInformation(source_1, feature_1));
        } else {
          if (((!expectGenerics) && (expression.getTypeArgument() != null))) {
            /* fail error "Unexpected type argument for call to '" + expression.right + "'" source expression feature ContractPackage.eINSTANCE.memberCall_TypeArgument */
            String _right_2 = expression.getRight();
            String _plus_5 = ("Unexpected type argument for call to \'" + _right_2);
            String _plus_6 = (_plus_5 + "\'");
            String error_2 = _plus_6;
            EObject source_2 = expression;
            EAttribute _memberCall_TypeArgument = ContractPackage.eINSTANCE.getMemberCall_TypeArgument();
            EStructuralFeature feature_2 = _memberCall_TypeArgument;
            throwForExplicitFail(error_2, new ErrorInformation(source_2, feature_2));
          }
        }
        final boolean expectArgument = (member instanceof MemberWithArgument);
        if ((expectArgument && (expression.getArgument() == null))) {
          /* fail error "Argument expected for call to '" + expression.right + "'" source expression feature ContractPackage.eINSTANCE.memberCall_Right */
          String _right_3 = expression.getRight();
          String _plus_7 = ("Argument expected for call to \'" + _right_3);
          String _plus_8 = (_plus_7 + "\'");
          String error_3 = _plus_8;
          EObject source_3 = expression;
          EAttribute _memberCall_Right_2 = ContractPackage.eINSTANCE.getMemberCall_Right();
          EStructuralFeature feature_3 = _memberCall_Right_2;
          throwForExplicitFail(error_3, new ErrorInformation(source_3, feature_3));
        } else {
          if (((!expectArgument) && (expression.getArgument() != null))) {
            /* fail error "Unexpected argument for call to '" + expression.right + "'" source expression feature ContractPackage.eINSTANCE.memberCall_Argument */
            String _right_4 = expression.getRight();
            String _plus_9 = ("Unexpected argument for call to \'" + _right_4);
            String _plus_10 = (_plus_9 + "\'");
            String error_4 = _plus_10;
            EObject source_4 = expression;
            EReference _memberCall_Argument = ContractPackage.eINSTANCE.getMemberCall_Argument();
            EStructuralFeature feature_4 = _memberCall_Argument;
            throwForExplicitFail(error_4, new ErrorInformation(source_4, feature_4));
          }
        }
        final boolean expectLambda = (member instanceof MemberWithLambda);
        if ((expectLambda && (expression.getLambda() == null))) {
          /* fail error "Lambda expected for call to '" + expression.right + "'" source expression feature ContractPackage.eINSTANCE.memberCall_Right */
          String _right_5 = expression.getRight();
          String _plus_11 = ("Lambda expected for call to \'" + _right_5);
          String _plus_12 = (_plus_11 + "\'");
          String error_5 = _plus_12;
          EObject source_5 = expression;
          EAttribute _memberCall_Right_3 = ContractPackage.eINSTANCE.getMemberCall_Right();
          EStructuralFeature feature_5 = _memberCall_Right_3;
          throwForExplicitFail(error_5, new ErrorInformation(source_5, feature_5));
        } else {
          if (((!expectLambda) && (expression.getLambda() != null))) {
            /* fail error "Unexpected lambda for call to '" + expression.right + "'" source expression.lambda */
            String _right_6 = expression.getRight();
            String _plus_13 = ("Unexpected lambda for call to \'" + _right_6);
            String _plus_14 = (_plus_13 + "\'");
            String error_6 = _plus_14;
            Lambda _lambda = expression.getLambda();
            EObject source_6 = _lambda;
            throwForExplicitFail(error_6, new ErrorInformation(source_6, null));
          }
        }
      }
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkTypeArgument(final MemberCall expression) {
    return checkTypeArgument(null, expression);
  }

  public Result<Boolean> checkTypeArgument(final RuleApplicationTrace _trace_, final MemberCall expression) {
    try {
    	return checkTypeArgumentInternal(_trace_, expression);
    } catch (Exception _e_CheckTypeArgument) {
    	return resultForFailure(_e_CheckTypeArgument);
    }
  }

  protected Result<Boolean> checkTypeArgumentInternal(final RuleApplicationTrace _trace_, final MemberCall expression) throws RuleFailedException {
    if (((expression.getTypeArgument() != null) && (!GenericTypeArgumentRegistry.getTypeNames().contains(expression.getTypeArgument())))) {
      /* fail error "Invalid type argument '" + expression.typeArgument + "'" source expression feature ContractPackage.eINSTANCE.memberCall_TypeArgument */
      String _typeArgument = expression.getTypeArgument();
      String _plus = ("Invalid type argument \'" + _typeArgument);
      String _plus_1 = (_plus + "\'");
      String error = _plus_1;
      EObject source = expression;
      EAttribute _memberCall_TypeArgument = ContractPackage.eINSTANCE.getMemberCall_TypeArgument();
      EStructuralFeature feature = _memberCall_TypeArgument;
      throwForExplicitFail(error, new ErrorInformation(source, feature));
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkArgumentType(final MemberCall expression) {
    return checkArgumentType(null, expression);
  }

  public Result<Boolean> checkArgumentType(final RuleApplicationTrace _trace_, final MemberCall expression) {
    try {
    	return checkArgumentTypeInternal(_trace_, expression);
    } catch (Exception _e_CheckArgumentType) {
    	return resultForFailure(_e_CheckArgumentType);
    }
  }

  protected Result<Boolean> checkArgumentTypeInternal(final RuleApplicationTrace _trace_, final MemberCall expression) throws RuleFailedException {
    /* empty |- expression.left : var Type leftType */
    Expression _left = expression.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    String _switchResult = null;
    boolean _matched = false;
    if (leftType instanceof LongWithUnitsType) {
      String _right = expression.getRight();
      boolean _equals = Objects.equal(_right, "scaledTo");
      if (_equals) {
        _matched=true;
        _switchResult = "UnitLiteral";
      }
    }
    if (!_matched) {
      if (leftType instanceof RecordType) {
        String _right = expression.getRight();
        boolean _equals = Objects.equal(_right, "get");
        if (_equals) {
          _matched=true;
          _switchResult = "RecordField";
        }
      }
    }
    if (!_matched) {
      if (leftType instanceof EnumerationType) {
        String _right = expression.getRight();
        boolean _equals = Objects.equal(_right, "is");
        if (_equals) {
          _matched=true;
          _switchResult = "EnumerationLiteral";
        }
      }
    }
    final String requiredArgumentType = _switchResult;
    final Expression argument = expression.getArgument();
    if ((((requiredArgumentType != null) && (argument != null)) && (!(argument instanceof NameReference)))) {
      /* empty |- argument : var Type argumentType */
      Type argumentType = null;
      Result<Type> result_1 = expressionTypeInternal(emptyEnvironment(), _trace_, argument);
      checkAssignableTo(result_1.getFirst(), Type.class);
      argumentType = (Type) result_1.getFirst();
      
      /* fail error "Expected " + requiredArgumentType + "; found " + argumentType source expression feature ContractPackage.eINSTANCE.memberCall_Argument */
      String error = ((("Expected " + requiredArgumentType) + "; found ") + argumentType);
      EObject source = expression;
      EReference _memberCall_Argument = ContractPackage.eINSTANCE.getMemberCall_Argument();
      EStructuralFeature feature = _memberCall_Argument;
      throwForExplicitFail(error, new ErrorInformation(source, feature));
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkLambdaReturnType(final Lambda lambda) {
    return checkLambdaReturnType(null, lambda);
  }

  public Result<Boolean> checkLambdaReturnType(final RuleApplicationTrace _trace_, final Lambda lambda) {
    try {
    	return checkLambdaReturnTypeInternal(_trace_, lambda);
    } catch (Exception _e_CheckLambdaReturnType) {
    	return resultForFailure(_e_CheckLambdaReturnType);
    }
  }

  protected Result<Boolean> checkLambdaReturnTypeInternal(final RuleApplicationTrace _trace_, final Lambda lambda) throws RuleFailedException {
    final MemberCall memberCall = EcoreUtil2.<MemberCall>getContainerOfType(lambda, MemberCall.class);
    /* empty |- memberCall.left : var Type leftType */
    Expression _left = memberCall.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    final Member member = leftType.getMembers().get(memberCall.getRight());
    if ((member instanceof MemberWithLambda)) {
      /* empty |- lambda.returnValue : var Type returnType */
      Expression _returnValue = lambda.getReturnValue();
      Type returnType = null;
      Result<Type> result_1 = expressionTypeInternal(emptyEnvironment(), _trace_, _returnValue);
      checkAssignableTo(result_1.getFirst(), Type.class);
      returnType = (Type) result_1.getFirst();
      
      if ((returnType != null)) {
        final Consumer<String> _function = (String errorMessage) -> {
          /* fail error errorMessage source lambda.returnValue */
          String error = errorMessage;
          Expression _returnValue_1 = lambda.getReturnValue();
          EObject source = _returnValue_1;
          throwForExplicitFail(error, new ErrorInformation(source, null));
        };
        ((MemberWithLambda)member).validateLambdaReturnType(returnType, _function);
      }
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkPropertyLookup(final PropertyLookup expression) {
    return checkPropertyLookup(null, expression);
  }

  public Result<Boolean> checkPropertyLookup(final RuleApplicationTrace _trace_, final PropertyLookup expression) {
    try {
    	return checkPropertyLookupInternal(_trace_, expression);
    } catch (Exception _e_CheckPropertyLookup) {
    	return resultForFailure(_e_CheckPropertyLookup);
    }
  }

  protected Result<Boolean> checkPropertyLookupInternal(final RuleApplicationTrace _trace_, final PropertyLookup expression) throws RuleFailedException {
    /* empty |- expression.left : var Type leftType */
    Expression _left = expression.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    if (((leftType != null) && (!leftType.supportsAttributeLookup()))) {
      /* fail error "Cannot lookup property on a " + leftType source expression */
      String error = ("Cannot lookup property on a " + leftType);
      EObject source = expression;
      throwForExplicitFail(error, new ErrorInformation(source, null));
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkTupleDeclarationSize(final TupleDeclaration tupleDeclaration) {
    return checkTupleDeclarationSize(null, tupleDeclaration);
  }

  public Result<Boolean> checkTupleDeclarationSize(final RuleApplicationTrace _trace_, final TupleDeclaration tupleDeclaration) {
    try {
    	return checkTupleDeclarationSizeInternal(_trace_, tupleDeclaration);
    } catch (Exception _e_CheckTupleDeclarationSize) {
    	return resultForFailure(_e_CheckTupleDeclarationSize);
    }
  }

  protected Result<Boolean> checkTupleDeclarationSizeInternal(final RuleApplicationTrace _trace_, final TupleDeclaration tupleDeclaration) throws RuleFailedException {
    /* empty |- tupleDeclaration.value : var Type type */
    Expression _value = tupleDeclaration.getValue();
    Type type = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _value);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    if ((type instanceof TupleType)) {
      final int expectedCount = tupleDeclaration.getNames().size();
      final int actualCount = ((TupleType)type).getElementTypes().size();
      if ((expectedCount != actualCount)) {
        /* fail error "Expected tuple with " + expectedCount + " elements; found tuple with " + actualCount + " elements" source tupleDeclaration feature ContractPackage.eINSTANCE.query_Value */
        String error = (((("Expected tuple with " + Integer.valueOf(expectedCount)) + " elements; found tuple with ") + Integer.valueOf(actualCount)) + 
          " elements");
        EObject source = tupleDeclaration;
        EReference _query_Value = ContractPackage.eINSTANCE.getQuery_Value();
        EStructuralFeature feature = _query_Value;
        throwForExplicitFail(error, new ErrorInformation(source, feature));
      }
    } else {
      /* fail error "Expected tuple; found " + type source tupleDeclaration feature ContractPackage.eINSTANCE.query_Value */
      String error_1 = ("Expected tuple; found " + type);
      EObject source_1 = tupleDeclaration;
      EReference _query_Value_1 = ContractPackage.eINSTANCE.getQuery_Value();
      EStructuralFeature feature_1 = _query_Value_1;
      throwForExplicitFail(error_1, new ErrorInformation(source_1, feature_1));
    }
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkTupleParameterSize(final TupleParameter tupleParameter) {
    return checkTupleParameterSize(null, tupleParameter);
  }

  public Result<Boolean> checkTupleParameterSize(final RuleApplicationTrace _trace_, final TupleParameter tupleParameter) {
    try {
    	return checkTupleParameterSizeInternal(_trace_, tupleParameter);
    } catch (Exception _e_CheckTupleParameterSize) {
    	return resultForFailure(_e_CheckTupleParameterSize);
    }
  }

  protected Result<Boolean> checkTupleParameterSizeInternal(final RuleApplicationTrace _trace_, final TupleParameter tupleParameter) throws RuleFailedException {
    final MemberCall memberCall = EcoreUtil2.<MemberCall>getContainerOfType(tupleParameter, MemberCall.class);
    /* empty |- memberCall.left : var Type leftType */
    Expression _left = memberCall.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(emptyEnvironment(), _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    final Member member = leftType.getMembers().get(memberCall.getRight());
    if ((member instanceof MemberWithLambda)) {
      final Type leftElementType = ((MemberWithLambda)member).getLambdaParameterType();
      if ((leftElementType instanceof TupleType)) {
        final int declarationCount = tupleParameter.getNames().size();
        final int requiredCount = ((TupleType)leftElementType).getElementTypes().size();
        if ((declarationCount != requiredCount)) {
          /* fail error "Tuple declared with " + declarationCount + " elements, but should have " + requiredCount + " elements" source tupleParameter */
          String error = (((("Tuple declared with " + Integer.valueOf(declarationCount)) + " elements, but should have ") + Integer.valueOf(requiredCount)) + 
            " elements");
          EObject source = tupleParameter;
          throwForExplicitFail(error, new ErrorInformation(source, null));
        }
      } else {
        if ((leftElementType != null)) {
          /* fail error "Cannot destructure lambda parameter of type " + leftElementType source tupleParameter */
          String error_1 = ("Cannot destructure lambda parameter of type " + leftElementType);
          EObject source_1 = tupleParameter;
          throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
        }
      }
    }
    return new Result<Boolean>(true);
  }

  protected Result<Type> expressionTypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return expressionTypeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_expressionType) {
    	sneakyThrowRuleFailedException(_e_expressionType);
    	return null;
    }
  }

  protected void expressionTypeThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Type> namedTypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Element named) {
    try {
    	checkParamsNotNull(named);
    	return namedTypeDispatcher.invoke(_environment_, _trace_, named);
    } catch (Exception _e_namedType) {
    	sneakyThrowRuleFailedException(_e_namedType);
    	return null;
    }
  }

  protected void namedTypeThrowException(final String _error, final String _issue, final Exception _ex, final Element named, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OrExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleOrExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("OrExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleOrExpression) {
    	expressionTypeThrowException(ruleName("OrExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "BooleanType",
    		OREXPRESSION,
    		e_applyRuleOrExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleOrExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final OrExpression expression) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleOrExpression_1(G, expression));
  }

  private BooleanType _applyRuleOrExpression_1(final RuleEnvironment G, final OrExpression expression) throws RuleFailedException {
    return BooleanType.INSTANCE;
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAndExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AndExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAndExpression) {
    	expressionTypeThrowException(ruleName("AndExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "BooleanType",
    		ANDEXPRESSION,
    		e_applyRuleAndExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleAndExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AndExpression expression) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleAndExpression_1(G, expression));
  }

  private BooleanType _applyRuleAndExpression_1(final RuleEnvironment G, final AndExpression expression) throws RuleFailedException {
    return BooleanType.INSTANCE;
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NotExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleNotExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("NotExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleNotExpression) {
    	expressionTypeThrowException(ruleName("NotExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "BooleanType",
    		NOTEXPRESSION,
    		e_applyRuleNotExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleNotExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NotExpression expression) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleNotExpression_1(G, expression));
  }

  private BooleanType _applyRuleNotExpression_1(final RuleEnvironment G, final NotExpression expression) throws RuleFailedException {
    return BooleanType.INSTANCE;
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MemberCall expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleMemberCall(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("MemberCall") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMemberCall) {
    	expressionTypeThrowException(ruleName("MemberCall") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "Type",
    		MEMBERCALL,
    		e_applyRuleMemberCall, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleMemberCall(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MemberCall expression) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- expression.left : var Type leftType */
    Expression _left = expression.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    Type _switchResult = null;
    Map<String, Member> _members = null;
    if (leftType!=null) {
      _members=leftType.getMembers();
    }
    Member _get = null;
    if (_members!=null) {
      _get=_members.get(expression.getRight());
    }
    final Member member = _get;
    boolean _matched = false;
    if (member instanceof SimpleMember) {
      _matched=true;
      _switchResult = ((SimpleMember<?, ?>)member).getReturnType();
    }
    if (!_matched) {
      if (member instanceof MemberWithTypeParameter) {
        _matched=true;
        Type _xblockexpression = null;
        {
          final Type queryType = GenericTypeArgumentRegistry.getQueryType(expression.getTypeArgument());
          Type _xifexpression = null;
          if ((queryType != null)) {
            _xifexpression = ((MemberWithTypeParameter<?, ?>)member).getReturnType(queryType);
          }
          _xblockexpression = (_xifexpression);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      if (member instanceof MemberWithArgument) {
        _matched=true;
        _switchResult = ((MemberWithArgument<?, ?, ?>)member).getReturnType(expression.getArgument());
      }
    }
    if (!_matched) {
      if (member instanceof MemberWithLambda) {
        Lambda _lambda = expression.getLambda();
        boolean _tripleNotEquals = (_lambda != null);
        if (_tripleNotEquals) {
          _matched=true;
          Type _xblockexpression = null;
          {
            /* G |- expression.lambda.returnValue : var Type lambdaType */
            Expression _returnValue = expression.getLambda().getReturnValue();
            Type lambdaType = null;
            Result<Type> result_1 = expressionTypeInternal(G, _trace_, _returnValue);
            checkAssignableTo(result_1.getFirst(), Type.class);
            lambdaType = (Type) result_1.getFirst();
            
            _xblockexpression = (((MemberWithLambda<?, ?, ?>)member).getReturnType(lambdaType));
          }
          _switchResult = _xblockexpression;
        }
      }
    }
    type = _switchResult;
    return new Result<Type>(type);
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyLookup expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRulePropertyLookup(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PropertyLookup") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePropertyLookup) {
    	expressionTypeThrowException(ruleName("PropertyLookup") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "Type",
    		PROPERTYLOOKUP,
    		e_applyRulePropertyLookup, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRulePropertyLookup(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyLookup expression) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- expression.left : var Type leftType */
    Expression _left = expression.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    boolean _supportsAttributeLookup = leftType.supportsAttributeLookup();
    if (_supportsAttributeLookup) {
      Type _convertPropertyType = TypeSystemUtils.convertPropertyType(expression.getRight());
      OptionalType _optionalType = new OptionalType(_convertPropertyType);
      type = _optionalType;
    }
    return new Result<Type>(type);
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SelfExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleSelfExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SelfExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSelfExpression) {
    	expressionTypeThrowException(ruleName("SelfExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "OccurrenceDefintionType",
    		SELFEXPRESSION,
    		e_applyRuleSelfExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleSelfExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SelfExpression expression) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleSelfExpression_1(G, expression));
  }

  private OccurrenceDefintionType _applyRuleSelfExpression_1(final RuleEnvironment G, final SelfExpression expression) throws RuleFailedException {
    return OccurrenceDefintionType.INSTANCE;
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleStringLiteral(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("StringLiteral") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleStringLiteral) {
    	expressionTypeThrowException(ruleName("StringLiteral") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "StringType",
    		STRINGLITERAL,
    		e_applyRuleStringLiteral, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral expression) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleStringLiteral_1(G, expression));
  }

  private StringType _applyRuleStringLiteral_1(final RuleEnvironment G, final StringLiteral expression) throws RuleFailedException {
    return StringType.INSTANCE;
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTupleExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TupleExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTupleExpression) {
    	expressionTypeThrowException(ruleName("TupleExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "TupleType",
    		TUPLEEXPRESSION,
    		e_applyRuleTupleExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleTupleExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleExpression expression) throws RuleFailedException {
    TupleType type = null; // output parameter
    final ArrayList<Type> elementTypes = CollectionLiterals.<Type>newArrayList();
    EList<Expression> _elements = expression.getElements();
    for (final Expression element : _elements) {
      /* G |- element : var Type elementType */
      Type elementType = null;
      Result<Type> result = expressionTypeInternal(G, _trace_, element);
      checkAssignableTo(result.getFirst(), Type.class);
      elementType = (Type) result.getFirst();
      
      /* elementTypes += elementType */
      if (!elementTypes.add(elementType)) {
        sneakyThrowRuleFailedException("elementTypes += elementType");
      }
    }
    TupleType _tupleType = new TupleType(elementTypes);
    type = _tupleType;
    return new Result<Type>(type);
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NameReference expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleNameReference(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("NameReference") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleNameReference) {
    	expressionTypeThrowException(ruleName("NameReference") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "Type",
    		NAMEREFERENCE,
    		e_applyRuleNameReference, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleNameReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NameReference expression) throws RuleFailedException {
    Type type = null; // output parameter
    final Element named = expression.getReference();
    boolean _eIsProxy = named.eIsProxy();
    boolean _not = (!_eIsProxy);
    if (_not) {
      /* G ||- named : type */
      Result<Type> result = namedTypeInternal(G, _trace_, named);
      checkAssignableTo(result.getFirst(), Type.class);
      type = (Type) result.getFirst();
      
    }
    return new Result<Type>(type);
  }

  protected Result<Type> expressionTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UsageExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleUsageExpression(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("UsageExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUsageExpression) {
    	expressionTypeThrowException(ruleName("UsageExpression") + stringRepForEnv(G) + " |- " + stringRep(expression) + " : " + "Type",
    		USAGEEXPRESSION,
    		e_applyRuleUsageExpression, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<Type> applyRuleUsageExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UsageExpression expression) throws RuleFailedException {
    Type type = null; // output parameter
    final Usage usage = expression.getUsage();
    boolean _eIsProxy = usage.eIsProxy();
    boolean _not = (!_eIsProxy);
    if (_not) {
      type = TypeSystemUtils.typeOfUsage(usage);
      if ((type == null)) {
        /* fail error "Reference to unsupported usage" source expression */
        String error = "Reference to unsupported usage";
        EObject source = expression;
        throwForExplicitFail(error, new ErrorInformation(source, null));
      }
    }
    return new Result<Type>(type);
  }

  protected Result<Type> namedTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SingleValDeclaration named) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleSingleValDeclaration(G, _subtrace_, named);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SingleValDeclaration") + stringRepForEnv(G) + " ||- " + stringRep(named) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSingleValDeclaration) {
    	namedTypeThrowException(ruleName("SingleValDeclaration") + stringRepForEnv(G) + " ||- " + stringRep(named) + " : " + "Type",
    		SINGLEVALDECLARATION,
    		e_applyRuleSingleValDeclaration, named, new ErrorInformation[] {new ErrorInformation(named)});
    	return null;
    }
  }

  protected Result<Type> applyRuleSingleValDeclaration(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SingleValDeclaration named) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- named.value : type */
    Expression _value = named.getValue();
    Result<Type> result = expressionTypeInternal(G, _trace_, _value);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }

  protected Result<Type> namedTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleName named) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTupleName(G, _subtrace_, named);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TupleName") + stringRepForEnv(G) + " ||- " + stringRep(named) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTupleName) {
    	namedTypeThrowException(ruleName("TupleName") + stringRepForEnv(G) + " ||- " + stringRep(named) + " : " + "Type",
    		TUPLENAME,
    		e_applyRuleTupleName, named, new ErrorInformation[] {new ErrorInformation(named)});
    	return null;
    }
  }

  protected Result<Type> applyRuleTupleName(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleName named) throws RuleFailedException {
    Type type = null; // output parameter
    final EObject parent = named.eContainer();
    if ((parent instanceof TupleDeclaration)) {
      /* G |- parent.value : var Type valueType */
      Expression _value = ((TupleDeclaration)parent).getValue();
      Type valueType = null;
      Result<Type> result = expressionTypeInternal(G, _trace_, _value);
      checkAssignableTo(result.getFirst(), Type.class);
      valueType = (Type) result.getFirst();
      
      if ((valueType instanceof TupleType)) {
        final int index = ((TupleDeclaration)parent).getNames().indexOf(named);
        int _size = ((TupleType)valueType).getElementTypes().size();
        boolean _lessThan = (index < _size);
        if (_lessThan) {
          type = ((TupleType)valueType).getElementTypes().get(index);
        }
      }
    } else {
      if ((parent instanceof TupleParameter)) {
        final MemberCall memberCall = EcoreUtil2.<MemberCall>getContainerOfType(parent, MemberCall.class);
        /* G |- memberCall.left : var Type leftType */
        Expression _left = memberCall.getLeft();
        Type leftType = null;
        Result<Type> result_1 = expressionTypeInternal(G, _trace_, _left);
        checkAssignableTo(result_1.getFirst(), Type.class);
        leftType = (Type) result_1.getFirst();
        
        final Member member = leftType.getMembers().get(memberCall.getRight());
        if ((member instanceof MemberWithLambda)) {
          final Type leftElementType = ((MemberWithLambda)member).getLambdaParameterType();
          if ((leftElementType instanceof TupleType)) {
            final int index_1 = ((TupleParameter)parent).getNames().indexOf(named);
            int _size_1 = ((TupleType)leftElementType).getElementTypes().size();
            boolean _lessThan_1 = (index_1 < _size_1);
            if (_lessThan_1) {
              type = ((TupleType)leftElementType).getElementTypes().get(index_1);
            }
          }
        }
      }
    }
    return new Result<Type>(type);
  }

  protected Result<Type> namedTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SingleParameter parameter) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleSingleParameter(G, _subtrace_, parameter);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SingleParameter") + stringRepForEnv(G) + " ||- " + stringRep(parameter) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSingleParameter) {
    	namedTypeThrowException(ruleName("SingleParameter") + stringRepForEnv(G) + " ||- " + stringRep(parameter) + " : " + "Type",
    		SINGLEPARAMETER,
    		e_applyRuleSingleParameter, parameter, new ErrorInformation[] {new ErrorInformation(parameter)});
    	return null;
    }
  }

  protected Result<Type> applyRuleSingleParameter(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SingleParameter parameter) throws RuleFailedException {
    Type type = null; // output parameter
    final MemberCall memberCall = EcoreUtil2.<MemberCall>getContainerOfType(parameter, MemberCall.class);
    /* G |- memberCall.left : var Type leftType */
    Expression _left = memberCall.getLeft();
    Type leftType = null;
    Result<Type> result = expressionTypeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    final Member member = leftType.getMembers().get(memberCall.getRight());
    if ((member instanceof MemberWithLambda)) {
      type = ((MemberWithLambda)member).getLambdaParameterType();
    }
    return new Result<Type>(type);
  }
}
