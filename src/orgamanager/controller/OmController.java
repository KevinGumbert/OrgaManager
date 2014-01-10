package orgamanager.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import orgamanager.model.OmModel;
import orgamanager.view.OmView;

public class OmController implements  ActionListener {

	private OmModel model;
    private OmView view;
    
    public OmController(OmModel model, OmView view){
    	this.model = model;
        this.view = view;
        model.setAnswer(0.0); // Give the model a start situation as per what the GUI will show.
        model.setInitialNumber(0.0);
        view.buttonActionListeners(this); // Add the action listener from this class on to the buttons of the view.           
    }
    
 // This deals with the interactions performed on the View.
    // It covers addition, subtraction, division and multiplication.
    public void actionPerformed(ActionEvent ae)
    {
        String action_com = ae.getActionCommand();

        if(action_com.equals("+"))
        {
            model.doAddition(view.getFieldText());
        }
        else if (action_com.equals("-"))
        {
            model.doSubtraction(view.getFieldText());
        }
        else if (action_com.equals("*"))
        {
            model.doMultiply(view.getFieldText());
        }
        else if (action_com.equals("/"))
        {
            model.doDivision(view.getFieldText());
        }

        view.setFieldText(""+model.getAnswer());
    }
	
}
