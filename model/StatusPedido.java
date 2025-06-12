package model;

public enum StatusPedido {
    PENDENTE("[PENDENTE]"),
    PAGO("[PAGO]");

    private final String tag;

    StatusPedido(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }

    public static StatusPedido fromTag(String tag) {
        for (StatusPedido status : values()) {
            if (status.tag.equals(tag)) {
                return status;
            }
        }
        return null;
    }
} 