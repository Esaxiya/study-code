public class SimpleFactory{
    public static Cumputer factory(String cuputername){
        if(cuputername.equals("Huawei")){
            return new HuaweiCumputer();
        }else if(cuputername.equals("Apple")){
            return new AppleCumputer();
        }else{
            throw new RuntimeException("没有找到登陆类型");
        }
    }

    public static void main(String[]args){
        Cumputer a = SimpleFactory.factory("Apple");
        Cumputer h = SimpleFactory.factory("Huawei");
        a.play("流浪地球");
        h.play("三体");
    }
}

interface Cumputer{
    public void play(String movie);
}

class HuaweiCumputer implements Cumputer{
    @Override
    public void play(String movie){
        System.out.println("正在使用华为电脑播放电影:"+movie);
    }
}

class AppleCumputer implements Cumputer{
    @Override
    public void play(String movie){
        System.out.println("正在使用苹果电脑播放电影:"+movie);
    }
}
