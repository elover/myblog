package cn.myblog.uitl.velocityTool;

/**
 * Created by nanwei on 14-8-2.
 */
public class StringFormat {

    public String slice(String content,int size){
        if(content.length() < size){
            return content;
        }else{
           return content.substring(0,size) + "<br><p>....</p>";
        }

    };
}
