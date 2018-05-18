/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardgame;

/**
 *
 * @author Linh
 */
public class CardObj {
    //tạo đối tượng lá bài
    private int type;
    private int value;
    private String Url;

    public CardObj(int type, int value, String Url) {
        this.type = type;
        this.value = value;
        this.Url = Url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

  
   
    
}
