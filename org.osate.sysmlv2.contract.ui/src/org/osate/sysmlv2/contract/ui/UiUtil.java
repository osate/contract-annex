package org.osate.sysmlv2.contract.ui;

import org.eclipse.ease.tools.RunnableWithResult;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class UiUtil {

	private class ContractDialog extends MessageDialog {

		public ContractDialog(Shell parentShell, String dialogTitle, Image dialogTitleImage, String dialogMessage,
				int dialogImageType, String[] dialogButtonLabels, int defaultIndex) {
			super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, dialogButtonLabels,
					defaultIndex);
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
			setBlockOnOpen(true);
		}

		public ContractDialog(Shell parentShell, String dialogTitle, Image dialogTitleImage, String dialogMessage,
				int dialogImageType, int defaultIndex, String... dialogButtonLabels) {
			super(parentShell, dialogTitle, dialogTitleImage, dialogMessage, dialogImageType, defaultIndex,
					dialogButtonLabels);
			setShellStyle(SWT.CLOSE | SWT.MODELESS | SWT.BORDER | SWT.TITLE);
			setBlockOnOpen(true);
		}

	}

	public boolean showQuestionDialog(final String message, final String title) {

			final RunnableWithResult<Boolean> runnable = new RunnableWithResult<>() {

				@Override
				public Boolean runWithTry() throws Throwable {
					int kind = MessageDialog.QUESTION;
					var dialog = new ContractDialog(Display.getDefault().getActiveShell(), title, null,
							message, kind, 0, "Yes", "No");
					return dialog.open() == 0;
				}

			};

			Display.getDefault().syncExec(runnable);
			return runnable.getResult();
		}

}
