import java.util.*;

public class InputValidation {
    private double amount;
    private String category;
    
    public InputValidation(double amount, String cateogry)
    {
        this.amount = amount;
        this.category = cateogry;
    }

    public void validateAmount() throws InvalidAmountException
    {
        if(this.amount<1 || this.amount>1000 )
        {
            throw new InvalidAmountException("Please enter amount in range (0,1000)!");
        }
    }
    public void validateCategory()
    {
        List <String> categories = new ArrayList<String>();
        categories.add("food");
        categories.add("travel");
        categories.add("bills");
        categories.add("entertainment");
        categories.add("other");

        if(!categories.contains(this.category))
        {
            throw new IllegalArgumentException("Please enter valid category from list : "+ categories);
        }
    }
}
