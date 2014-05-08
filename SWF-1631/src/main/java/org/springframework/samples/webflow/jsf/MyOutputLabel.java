/*
 * COPYRIGHT:
 * 
 * TITLE TO THE CODE REMAIN WITH ZEB/INFORMATION.TECHNOLOGY. THE CODE IS COPYRIGHTED AND PROTECTED BY LAW. YOU WILL NOT
 * REMOVE ANY COPYRIGHT NOTICE FROM THE CODE. REASSEMBLING, RECOMPILATION, TRANSFER, DISTRIBUTION OR MODIFICATION OF
 * PART OR ALL OF THE CODE IN ANY FORM WITHOUT THE PRIOR WRITTEN PERMISSION OF ZEB/INFORMATION.TECHNOLOGY IS PROHIBITED.
 * 
 * created: 29.04.2014 - 17:54:43
 */
package org.springframework.samples.webflow.jsf;


import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.PreRenderViewEvent;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;


/**
 * @author azschorn
 * 
 */
@FacesComponent( "DemoOutput" )
public class MyOutputLabel extends javax.faces.component.UIOutput implements SystemEventListener
{

    public MyOutputLabel() {
        super();
        setValue( "outerLabel" );
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        root.subscribeToViewEvent( PreRenderViewEvent.class, this );
    }

    /** {@inheritDoc} */
    @Override
    public void processEvent( final SystemEvent event ) throws AbortProcessingException {
        if ( ( event instanceof PreRenderViewEvent ) && !FacesContext.getCurrentInstance().isPostback() ) {
            if ( getChildCount() == 0 ) {
                insertInnerOutputLabel();
            }

        }

    }

    private void insertInnerOutputLabel() {
        UIOutput output = (UIOutput) FacesContext.getCurrentInstance().getApplication()
                .createComponent( UIOutput.COMPONENT_TYPE );
        output.setValue( "innerValue" );
        output.setId( "innerOutputID" );
        this.getChildren().add( output );

    }

    @Override
    public boolean isListenerForSource( final Object source ) {
        return ( source instanceof UIViewRoot );
    }

}
