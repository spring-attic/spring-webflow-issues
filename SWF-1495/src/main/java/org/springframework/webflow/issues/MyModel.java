package org.springframework.webflow.issues;

import java.io.Serializable;

public class MyModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private MyType[] options = { MyType.TYPE_1, MyType.TYPE_2 };

	private MyType[] selected;

	public MyType[] getOptions() {
		return options;
	}

	public void setOptions(MyType[] options) {
		this.options = options;
	}

	public MyType[] getSelected() {
		return selected;
	}

	public void setSelected(MyType[] selected) {
		this.selected = selected;
	}
	
}
