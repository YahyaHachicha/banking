package banking.transfer;

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

    public static final PaymentService GOOGLE_PAY
            = new PaymentService(GooglePayBankName);

    public static final PaymentService APPLE_PAY
            = new PaymentService(ApplePayBankName);

    public static final PaymentService PAYPAL
            = new PaymentService(PayPalBankName);

    public static final PaymentService WERO
            = new PaymentService(WeroBankName);

    public static final PaymentService MONEY_GRAM
            = new PaymentService(MoneyGramBankName);

    public static final PaymentService KLARNA
            = new PaymentService(KlarnaName);

    public static final PaymentService WESTERN_UNION
            = new PaymentService(WesternUnionName);

    // TODO:
    private String serviceName;

    private PaymentService(String serviceName) {
        // TODO:
        this.serviceName = serviceName;
    }

    @Override
    public boolean submitTransaction(Transaction transaction) {
        // TODO:
        if (transaction == null)
            return false;
        // erzeugen ein temporäres BICBank
        BICBank tempBICBank = new BICBank(this.serviceName + "_TEMP", 0, 0);
        tempBICBank.setBIC(0, SWIFTSystem.SWIFT_INSTANCE);
        return SWIFTSystem.SWIFT_INSTANCE.submitTransaction(transaction);
    }

    @Override
    public boolean register(SWIFTBank executor) {
        // TODO:
        return SWIFTSystem.SWIFT_INSTANCE.register(executor);
    }

    @Override
    public SWIFTBank[] getAll() {
        // TODO:
        return SWIFTSystem.SWIFT_INSTANCE.getAll();
    }

    @Override
    public SWIFTBank getByBIC(int bic) {
        // TODO:
        return SWIFTSystem.SWIFT_INSTANCE.getByBIC(bic);
    }

    @Override
    public SWIFTBank getByName(String bankName) {
        // TODO:
        if (this.serviceName.equalsIgnoreCase(bankName)){
            return null;
        }
        return SWIFTSystem.SWIFT_INSTANCE.getByName(bankName);
    }
}
