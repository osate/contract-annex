package org.osate.contract.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.Check;
import org.osate.contract.contract.AndExpression;
import org.osate.contract.contract.Lambda;
import org.osate.contract.contract.MemberCall;
import org.osate.contract.contract.NotExpression;
import org.osate.contract.contract.OrExpression;
import org.osate.contract.contract.PropertyLookup;
import org.osate.contract.contract.TupleDeclaration;
import org.osate.contract.contract.TupleParameter;
import org.osate.contract.typing.ContractTypeSystem;
import org.osate.contract.validation.AbstractContractValidator;

@SuppressWarnings("all")
public class ContractTypeSystemValidator extends AbstractContractValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;

  @Inject
  protected ContractTypeSystem xsemanticsSystem;

  protected ContractTypeSystem getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }

  @Check
  public void checkOrExpression(final OrExpression expression) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkOrExpression(expression),
    		expression);
  }

  @Check
  public void checkAndExpression(final AndExpression expression) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkAndExpression(expression),
    		expression);
  }

  @Check
  public void checkNotExpression(final NotExpression expression) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkNotExpression(expression),
    		expression);
  }

  @Check
  public void checkMemberCall(final MemberCall expression) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkMemberCall(expression),
    		expression);
  }

  @Check
  public void checkLambdaReturnType(final Lambda lambda) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkLambdaReturnType(lambda),
    		lambda);
  }

  @Check
  public void checkPropertyLookup(final PropertyLookup expression) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkPropertyLookup(expression),
    		expression);
  }

  @Check
  public void checkTupleDeclarationSize(final TupleDeclaration tupleDeclaration) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkTupleDeclarationSize(tupleDeclaration),
    		tupleDeclaration);
  }

  @Check
  public void checkTupleParameterSize(final TupleParameter tupleParameter) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkTupleParameterSize(tupleParameter),
    		tupleParameter);
  }
}
