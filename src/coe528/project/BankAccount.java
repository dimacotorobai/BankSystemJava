package coe528.project;

/**
 *
 * @author dimac
 */
public class BankAccount {
    int money;
    String szStatus = null;
    int uiStatus = -1;
    
    /**
     *
     */
    public BankAccount()
    {
        money = 100;
    }
    
    /**
     *
     * @return
     */
    public String Status()
    {
        if(money < 10000)
        {
            szStatus = "Silver";
            uiStatus = 20;
        }
        else if(money < 20000)
        {
            szStatus = "Gold";
            uiStatus = 10;
        }
        else
        {
            szStatus = "Platinum";
            uiStatus = 0;
        }
        
        return szStatus;
    }
    
    /**
     *
     * @param Deposit
     */
    public void DepositMoney(int Deposit)
    {
        if (Deposit > 0)
        {
            money  = money + Deposit;
        }
    }
    
    /**
     *
     * @param Withdraw
     */
    public void WithdrawMoney(int Withdraw)
    {
        if(Withdraw > 0)
        {
            if(money >= Withdraw)
            {
                money = money - Withdraw;
            }
        }
        
    }

    /**
     *
     * @return
     */
    public int GetBalance()
    {
        return money;
    }
    
    /**
     *
     * @param cost
     */
    public void OnlinePurchase(int cost)
    {
        if (cost>= 50)
        {
            if(money >= (uiStatus + cost))
            {
                Fee();
                money = money - cost;
            }
        }
        else{
            System.out.println("Transaction Failled < 50");
        }
    
    }

    /**
     *
     */
    public void Fee()
    {
        Status();
        money = money - uiStatus;
    }
    
    @Override
    public String toString()
    {
        Status();    
        String bank = "Balance: " + GetBalance()+ "\n";
        bank = bank + "Status: " + szStatus + "\n";
        return bank;
    }
}
