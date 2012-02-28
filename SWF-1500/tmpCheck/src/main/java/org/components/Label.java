package org.components;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.*;
import java.io.IOException;

@ListenersFor({
        @ListenerFor(systemEventClass = PostRestoreStateEvent.class),
        @ListenerFor(systemEventClass = PostAddToViewEvent.class)
})
public class Label extends UIOutput {
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public Object saveState(FacesContext context) {
        Object values[] = new Object[2];
        values[0] = super.saveState(context);
        values[1] = label;
        return values;
    }

    @Override
    public void restoreState(FacesContext context, Object state) {
        Object values[] = (Object[]) state;
        super.restoreState(context, values[0]);
        label = (String) values[1];
        System.out.println("method restoreState() invoked");
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        writer.startElement("div", this);
        writer.write(label);
        writer.endElement("div");
        writer.flush();
    }

    @Override
    public void processEvent(ComponentSystemEvent event) throws AbortProcessingException {
        super.processEvent(event);
        System.out.println("method processEvent() for " + event.getClass().getName() + " invoked; source = " + event.getSource());
    }

    @Override
    public String getFamily() {
        return "simple.Label";
    }
}
