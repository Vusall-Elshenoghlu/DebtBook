import java.util.ArrayList;
import java.util.List;

public class DeptLedger {
    private List<Customer> customers;
    private List<Debt> debts;

    public DeptLedger() {
        this.customers = new ArrayList<>();
        this.debts = new ArrayList<>();
    }

    public DeptLedger(List<Customer> customers, List<Debt> debts) {
        this.customers = customers;
        this.debts = debts;
    }

    public void addCustomer(Customer customer){
        if (customer != null) {
            customers.add(customer);
            System.out.println(customer.getName() + " is added...");
        } else {
            System.out.println("Customer cannot be null!");
        }
    }

    public void addDebt(Customer customer, double amount, String description){
        Debt debt = new Debt(amount, description);
        debts.add(debt);
        System.out.println(amount + " AZN debt is added for " + customer.getName());
    }

    public void payDebt(Customer customer, double paidAmount){
        for (Debt debt : debts) {
            if (debt.getDescription().equals(customer.getName())) {
                if (debt.getAmount() >= paidAmount) {
                    debt.setAmount(debt.getAmount() - paidAmount);
                    System.out.println(paidAmount + " is paid. Remaining debt: " + debt.getAmount());
                    if (debt.getAmount() == 0) {
                        debts.remove(debt);
                    }
                    return;
                } else {
                    System.out.println("Payment exceeds the debt amount!");
                    return;
                }
            }
        }
        System.out.println("No debt found for " + customer.getName());
    }

    public void listingDebts(Customer customer) {
        System.out.println(customer.getName() + "'s debts: ");
        for (Debt debt : debts) {
            System.out.println(debt);
        }
    }
}
