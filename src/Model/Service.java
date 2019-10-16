package Model;

public class Service {
    public enum TypeOfService{
        ACCOUNT,
        PACKAGE
    }
    private TypeOfService serviceType;

    public Service(TypeOfService serviceType) {
        this.serviceType = serviceType;
    }

    public TypeOfService getServiceType() {
        return serviceType;
    }

    public void setServiceType(TypeOfService serviceType) {
        this.serviceType = serviceType;
    }
}

