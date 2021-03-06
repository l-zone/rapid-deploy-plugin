package com.gitee.x0e.idea.plugin.editor;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

/**
 * @author 渣码
 * @since 2022/3/8 19:24
 */
public class EditorAreaIllustration extends AnAction {

	/**
	 * Displays a message with information about the current caret.
	 *
	 * @param e
	 *            Event related to this action
	 */
	@Override
	public void actionPerformed(@NotNull final AnActionEvent e) {
		// Get access to the editor and caret model. update() validated editor's
		// existence.
		final Editor editor = e.getRequiredData(CommonDataKeys.EDITOR);
		final CaretModel caretModel = editor.getCaretModel();
		// Getting the primary caret ensures we get the correct one of a possible many.
		final Caret primaryCaret = caretModel.getPrimaryCaret();
		// Get the caret information
		LogicalPosition logicalPos = primaryCaret.getLogicalPosition();
		VisualPosition visualPos = primaryCaret.getVisualPosition();
		int caretOffset = primaryCaret.getOffset();
		// Build and display the caret report.
		String report = logicalPos + "\n" + visualPos + "\n" + "Offset: " + caretOffset;
		Messages.showInfoMessage(report, "Caret Parameters Inside The Editor");
	}

	/**
	 * Sets visibility and enables this action menu item if: A project is open, An
	 * editor is active,
	 *
	 * @param e
	 *            Event related to this action
	 */
	@Override
	public void update(@NotNull final AnActionEvent e) {
		// Get required data keys
		final Project project = e.getProject();
		final Editor editor = e.getData(CommonDataKeys.EDITOR);
		// Set visibility only in case of existing project and editor
		e.getPresentation().setEnabledAndVisible(project != null && editor != null);
	}
}
