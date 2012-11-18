package foo.bar;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class HighLevelBean implements Serializable {
	private List<ElementBean> elements = new LinkedList<ElementBean>();

	public List<ElementBean> getElements() {
		return elements;
	}

	public void setElements(List<ElementBean> elements) {
		this.elements = elements;
	}

	public HighLevelBean() {
		elements.add(new ElementBean());
	}

}
