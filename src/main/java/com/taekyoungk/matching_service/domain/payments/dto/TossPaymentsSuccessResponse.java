package com.taekyoungk.matching_service.domain.payments.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class TossPaymentsSuccessResponse {
    // Payment 객체의 응답 버전
    private String version;

     // 결제 고유 키
    private String paymentKey;

    // 결제 타입 (NORMAL, BRANDPAY, 간편결제 등)
    private String type;

    // 주문 ID (상점에서 지정)
    private String orderId;

    // 주문 이름
    private String orderName;

    // 상점 아이디
    private String mId;

    // 통화 (KRW)
    private String currency;

    // 결제 수단 (카드, 가상계좌, 간편결제 등)
    private String method;

    // 결제 총액
    private int totalAmount;

    // 취소 가능 잔고
    private int balanceAmount;

    // 결제 상태 (READY, IN_PROGRESS, DONE, CANCELED, PARTIAL_CANCELED, ABORTED, EXPIRED)
    private String status;

    // 결제 요청 시간
    private String requestedAt;

    // 결제 승인 시간
    private String approvedAt;

    // 결제 수수료
    private int suppliedAmount;

    // 부가세
    private int vat;



    // 카드 결제 정보 (null 가능성 있음)
    private Card card;

    // 모바일 간편결제 정보 (토스, 페이코 등)
    private EasyPay easyPay;

    // 할인 정보
    private Discount discount;

    // 실패 정보 (결제 실패 시)
    private Failure failure;


    // 카드 결제 상세
    public static class Card {
        private String issuerCode; // 카드사 코드
        private String number; // 카드 번호 일부
        private int installmentPlanMonths; // 할부 개월 수
        private boolean isInterestFree; // 무이자 할부 여부
        private String approveNo; // 카드 승인번호
        private String useCardPoint; // 카드 포인트 사용 여부
        private String cardType; // 카드 종류 (신용/체크)
        private String ownerType; // 소유자 타입 (개인/법인)
        private String acquireStatus; // 매입 상태
        private String receiptUrl; // 카드 매출전표 URL
        // Getter, Setter
        public Card(String issuerCode, String number, int installmentPlanMonths, boolean isInterestFree, String approveNo,
                String useCardPoint, String cardType, String ownerType, String acquireStatus, String receiptUrl) {
            this.issuerCode = issuerCode;
            this.number = number;
            this.installmentPlanMonths = installmentPlanMonths;
            this.isInterestFree = isInterestFree;
            this.approveNo = approveNo;
            this.useCardPoint = useCardPoint;
            this.cardType = cardType;
            this.ownerType = ownerType;
            this.acquireStatus = acquireStatus;
            this.receiptUrl = receiptUrl;
        }
        public String getIssuerCode() {
            return issuerCode;
        }
        public void setIssuerCode(String issuerCode) {
            this.issuerCode = issuerCode;
        }
        public String getNumber() {
            return number;
        }
        public void setNumber(String number) {
            this.number = number;
        }
        public int getInstallmentPlanMonths() {
            return installmentPlanMonths;
        }
        public void setInstallmentPlanMonths(int installmentPlanMonths) {
            this.installmentPlanMonths = installmentPlanMonths;
        }
        public boolean isInterestFree() {
            return isInterestFree;
        }
        public void setInterestFree(boolean isInterestFree) {
            this.isInterestFree = isInterestFree;
        }
        public String getApproveNo() {
            return approveNo;
        }
        public void setApproveNo(String approveNo) {
            this.approveNo = approveNo;
        }
        public String getUseCardPoint() {
            return useCardPoint;
        }
        public void setUseCardPoint(String useCardPoint) {
            this.useCardPoint = useCardPoint;
        }
        public String getCardType() {
            return cardType;
        }
        public void setCardType(String cardType) {
            this.cardType = cardType;
        }
        public String getOwnerType() {
            return ownerType;
        }
        public void setOwnerType(String ownerType) {
            this.ownerType = ownerType;
        }
        public String getAcquireStatus() {
            return acquireStatus;
        }
        public void setAcquireStatus(String acquireStatus) {
            this.acquireStatus = acquireStatus;
        }
        public String getReceiptUrl() {
            return receiptUrl;
        }
        public void setReceiptUrl(String receiptUrl) {
            this.receiptUrl = receiptUrl;
        }
        
    }

    // 간편결제 상세
    public static class EasyPay {
        private String provider; // 간편결제 서비스 제공자
        private int amount; // 간편결제 결제 금액
        private int discountAmount; // 간편결제 할인 금액
        // Getter, Setter
        public EasyPay(String provider, int amount, int discountAmount) {
            this.provider = provider;
            this.amount = amount;
            this.discountAmount = discountAmount;
        }
        public String getProvider() {
            return provider;
        }
        public void setProvider(String provider) {
            this.provider = provider;
        }
        public int getAmount() {
            return amount;
        }
        public void setAmount(int amount) {
            this.amount = amount;
        }
        public int getDiscountAmount() {
            return discountAmount;
        }
        public void setDiscountAmount(int discountAmount) {
            this.discountAmount = discountAmount;
        }
        
    }

    // 결제 취소 상세
    public static class Cancellation {
        private int cancelAmount; // 취소 금액
        private int cancelTaxFreeAmount; // 비과세 취소 금액
        private int cancelVatAmount; // 부가세 취소 금액
        private OffsetDateTime canceledAt; // 취소 일시
        private String cancelReason; // 취소 사유
        private String transactionKey; // 취소 트랜잭션 키
        // Getter, Setter
        public Cancellation(int cancelAmount, int cancelTaxFreeAmount, int cancelVatAmount, OffsetDateTime canceledAt,
                String cancelReason, String transactionKey) {
            this.cancelAmount = cancelAmount;
            this.cancelTaxFreeAmount = cancelTaxFreeAmount;
            this.cancelVatAmount = cancelVatAmount;
            this.canceledAt = canceledAt;
            this.cancelReason = cancelReason;
            this.transactionKey = transactionKey;
        }
        public int getCancelAmount() {
            return cancelAmount;
        }
        public void setCancelAmount(int cancelAmount) {
            this.cancelAmount = cancelAmount;
        }
        public int getCancelTaxFreeAmount() {
            return cancelTaxFreeAmount;
        }
        public void setCancelTaxFreeAmount(int cancelTaxFreeAmount) {
            this.cancelTaxFreeAmount = cancelTaxFreeAmount;
        }
        public int getCancelVatAmount() {
            return cancelVatAmount;
        }
        public void setCancelVatAmount(int cancelVatAmount) {
            this.cancelVatAmount = cancelVatAmount;
        }
        public OffsetDateTime getCanceledAt() {
            return canceledAt;
        }
        public void setCanceledAt(OffsetDateTime canceledAt) {
            this.canceledAt = canceledAt;
        }
        public String getCancelReason() {
            return cancelReason;
        }
        public void setCancelReason(String cancelReason) {
            this.cancelReason = cancelReason;
        }
        public String getTransactionKey() {
            return transactionKey;
        }
        public void setTransactionKey(String transactionKey) {
            this.transactionKey = transactionKey;
        }
        
    }

    // 할인 상세
    public static class Discount {
        private int amount; // 할인 금액
        // Getter, Setter

        public Discount(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
        
    }

    // 결제 실패 정보
    public static class Failure {
        private String code; // 실패 코드
        private String message; // 실패 메시지
        // Getter, Setter
        public Failure(String code, String message) {
            this.code = code;
            this.message = message;
        }
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        
    }

    public TossPaymentsSuccessResponse(String version, String paymentKey, String type, String orderId, String orderName,
            String mId, String currency, String method, int totalAmount, int balanceAmount, String status,
            String requestedAt, String approvedAt, int suppliedAmount, int vat, Card card, EasyPay easyPay,
            Discount discount, Failure failure) {
        this.version = version;
        this.paymentKey = paymentKey;
        this.type = type;
        this.orderId = orderId;
        this.orderName = orderName;
        this.mId = mId;
        this.currency = currency;
        this.method = method;
        this.totalAmount = totalAmount;
        this.balanceAmount = balanceAmount;
        this.status = status;
        this.requestedAt = requestedAt;
        this.approvedAt = approvedAt;
        this.suppliedAmount = suppliedAmount;
        this.vat = vat;
        this.card = card;
        this.easyPay = easyPay;
        this.discount = discount;
        this.failure = failure;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPaymentKey() {
        return paymentKey;
    }

    public void setPaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(String requestedAt) {
        this.requestedAt = requestedAt;
    }

    public String getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(String approvedAt) {
        this.approvedAt = approvedAt;
    }

    public int getSuppliedAmount() {
        return suppliedAmount;
    }

    public void setSuppliedAmount(int suppliedAmount) {
        this.suppliedAmount = suppliedAmount;
    }

    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public EasyPay getEasyPay() {
        return easyPay;
    }

    public void setEasyPay(EasyPay easyPay) {
        this.easyPay = easyPay;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Failure getFailure() {
        return failure;
    }

    public void setFailure(Failure failure) {
        this.failure = failure;
    }


}
