interface Apple{
    public void design();
}
interface Huawei{
    public void design();
}

class Iphone implements Apple{
    public void design(){
        System.out.println("苹果设计手机: Iphone");
    }
}

class Mac implements Apple{
    public void design(){
        System.out.println("苹果设计电脑: Mac");
    }
}

class Mate implements Huawei{
    public void design(){
        System.out.println("华为设计手机: Mate");
    }
}

class MateBook implements Huawei{
    public void design(){
        System.out.println("华为设计电脑: MateBook");
    }
}


interface Facotry{
    Apple manufactureAppleProduct();
    Huawei manufactureHuaweiProduct();
}

class CumputerFacotry implements Facotry{
    public Apple manufactureAppleProduct(){
        return new Mac();
    }
    public Huawei manufactureHuaweiProduct(){
        return new MateBook();
    }
}

class PhoneFactory implements Facotry{
    public Apple manufactureAppleProduct(){
        return new Iphone();
    }
    public Huawei manufactureHuaweiProduct(){
        return new Mate();
    }
}

public class AbstractFactory{
    public static void main(String[] args) {
        // 获取 Mate手机、Iphone手机
        Facotry facotry = new PhoneFactory();   //手机工厂
        Apple apple = facotry.manufactureAppleProduct();
        apple.design();
        Huawei huawei = facotry.manufactureHuaweiProduct();
        huawei.design();

        // 获取 MateBook、Mac
        Facotry facotry2 = new CumputerFacotry();
        Apple mac = facotry.manufactureAppleProduct();
        mac.design();
        Huawei matebook = facotry.manufactureHuaweiProduct();
        huawei.design();
    }
}






//
