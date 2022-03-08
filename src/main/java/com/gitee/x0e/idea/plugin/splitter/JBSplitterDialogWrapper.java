package com.gitee.x0e.idea.plugin.splitter;

import java.awt.*;

import javax.swing.*;

import org.jetbrains.annotations.Nullable;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.ui.JBSplitter;

/**
 * @author 渣码
 * @since 2022/3/8 19:08
 */
public class JBSplitterDialogWrapper extends DialogWrapper {
	private JBSplitter splitter;

	public JBSplitterDialogWrapper() {
		super(true);
		init();
		setTitle("JBSplitter");
	}

	@Nullable
	@Override
	protected JComponent createCenterPanel() {
		splitter = new JBSplitter();
		JPanel firstPanel = new JPanel();
		firstPanel.add(new JLabel("First Panel"));
		firstPanel.setBorder(BorderFactory.createTitledBorder("First Panel"));
		splitter.setFirstComponent(firstPanel);

		JPanel secondPanel = new JPanel();
		secondPanel.add(new JLabel("Second Panel"));
		secondPanel.setBorder(BorderFactory.createTitledBorder("Second Panel"));
		splitter.setSecondComponent(secondPanel);

		// 记录当前俩个组件的比例，存放到map中，key即为该值
		splitter.setSplitterProportionKey("customProportionKey");
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(splitter, BorderLayout.CENTER);
		return panel;
	}
}
