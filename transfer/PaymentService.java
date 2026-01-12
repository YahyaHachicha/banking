package banking.transfer;

import banking.account.BankCustomer;
import banking.account.Customer;
import banking.bank.*;

/**
 * A simple TransactionTransferSystem without a SWIFTBank by senders.
 * e.g. WesternUnion, MoneyGram, PayPal, Wero, Klarna etc.
 */
public class PaymentService implements TransactionTransferSystem {
    public final static String GooglePayBankName = "GooglePay";
    public final static String ApplePayBankName = "ApplePay";
    public final static String PayPalBankName = "PayPal";
    public final static String WeroBankName = "Wero";
    public final static String MoneyGramBankName = "MoneyGram";
    public final static String KlarnaName = "Klarna";
    public final static String WesternUnionName = "WesternUnion";

    public static final PaymentService GOOGLE_PAY = new PaymentService(GooglePayBankName);

    public static final PaymentService APPLE_PAY = new PaymentService(ApplePayBankName);

    public static final PaymentService PAYPAL = new PaymentService(PayPalBankName);

    public static final PaymentService WERO = new PaymentService(WeroBankName);

    public static final PaymentService MONEY_GRAM = new PaymentService(MoneyGramBankName);

    public static final PaymentService KLARNA = new PaymentService(KlarnaName);

    public static final PaymentService WESTERN_UNION = new PaymentService(WesternUnionName);

    // TODO:

    String serviceName;

    private PaymentService(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * No need for documentation here! This method is defined and
     * documented in the given interface. The documentation is inherited
     * automatically from the interface. If you want to add additional
     * documentation to an implemented method, you can use {&#64;inheritDoc}
     * (see below).
     * <br />
     * <br />
     * {@inheritDoc}
     */

    @Override
    public boolean submitTransaction(Transaction transaction) {
        if (transaction == null || transaction.getFinishDate() != null || transaction.getToBank() == null)
            return false;

        //temporäres Bankkonto erstellen und Transaktion submitten
        if (transaction.getFromBank() == null) {
            SWIFTBank banktmp = new BICBank(serviceName, 1, 1);
            Customer customertmp = new BankCustomer(serviceName, serviceName, null, null);
            banktmp.registerCustomer(customertmp);
            banktmp.getBankAccount(banktmp.createCheckingBankAccount(customertmp.getCustomerNumber(), 9999)).depositMoney(transaction.getAmount());
            SWIFTSystem.SWIFT_INSTANCE.submitTransaction(new Transaction(0, serviceName, transaction.getToAccountNumber(), transaction.getRecipientLastName(), transaction.getAmount(), banktmp, transaction.getToBank()));
            return true;
        }
        return false;
    }

    @Override
    public boolean register(SWIFTBank executor) {
        return SWIFTSystem.SWIFT_INSTANCE.register(executor);
    }

    @Override
    public SWIFTBank[] getAll() {
        return SWIFTSystem.SWIFT_INSTANCE.getAll();
    }

    @Override
    public SWIFTBank getByBIC(int bic) {
        return SWIFTSystem.SWIFT_INSTANCE.getByBIC(bic);
    }

    @Override
    public SWIFTBank getByName(String bankName) {
        if (bankName.equals(this.serviceName)) {
            return new BICBank(serviceName, 1, 1);
        }
        return SWIFTSystem.SWIFT_INSTANCE.getByName(bankName);
    }
}
