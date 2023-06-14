package org.osate.contract.typing.validation;

import com.google.inject.Inject;
import org.eclipse.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.osate.contract.typing.ContractInterpreter;

@SuppressWarnings("all")
public class ContractInterpreterValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;

  @Inject
  protected ContractInterpreter xsemanticsSystem;

  protected ContractInterpreter getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
}
