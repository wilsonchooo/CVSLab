package sample;

public class Info {
    private String[] info;


    public Info(String[] info)
    {
        this.info=info;
    }

    public int size()
    {
        return info.length;
    }

    public String retrieve (int num)
    {
        return info[num];
    }

}

