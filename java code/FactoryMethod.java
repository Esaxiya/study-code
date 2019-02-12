
public class FactoryMethod{
    public static void main(String[] args) {
        HuaweiFactory hf = new HuaweiFactory();
        Cumputer hc = hf.CreateCuputer();
        AppleFactory af = new AppleFactory();
        Cumputer ac = af.CreateCuputer();
        hc.play_movie("流浪地球");
        hc.play_music("Faded");
        ac.play_movie("熊出没");
        ac.play_music("平凡之路");
    }
}

interface Cumputer{
    public void play_movie(String movie);
    public void play_music(String music);
}

class Huawei implements Cumputer{
    public void play_movie(String movie){
        System.out.println("正在使用华为电脑播放电影: "+movie);
    }
    public void play_music(String music){
        System.out.println("正在使用华为电脑播放音乐: "+music);
    }
}

class Apple implements Cumputer{
    public void play_movie(String movie){
        System.out.println("正在使用苹果电脑播放电影: "+movie);
    }
    public void play_music(String music){
        System.out.println("正在使用苹果电脑播放音乐: "+music);
    }
}

interface Factory{
    public Cumputer CreateCuputer();
}

class HuaweiFactory implements Factory{
    public Cumputer CreateCuputer(){
        return new Huawei();
    }
}

class AppleFactory implements Factory{
    public Cumputer CreateCuputer(){
        return new Apple();
    }
}


//
