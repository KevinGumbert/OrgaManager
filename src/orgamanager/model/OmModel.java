package orgamanager.model;

public class OmModel {

	private double answer, initial_number;

    // Constructor sets both numbers. 
    public OmModel()
    {
        answer = 0.0;
        initial_number = 0.0;
    }

    // Adds a number to the existing answer.
    public void doAddition(double y)
    {
        answer = answer + y;
    }

    // Subtracts a number to the existing answer.
    public void doSubtraction(double y)
    {
        answer = answer - y;
    }

    // Multiplies the existing answer by a number.
    public void doMultiply(double y)
    {
        answer = answer * y;
    }

    // Divides the existing answer by a number.
    public void doDivision(double y)
    {
        answer = answer / y;
    }

    // Gets the current answer.
    public double getAnswer()
    {
        return answer;
    }

    // Sets the current answer.
    public void setAnswer(double new_answer)
    {
        answer = new_answer;
    }

    // Sets the initial number.
    public void setInitialNumber(double new_initial)
    {
        initial_number = new_initial;
    }

    // Sets the answer to be the initial number.
    public void reset()
    {
        answer = initial_number;
    }
	
}
