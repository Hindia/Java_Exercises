/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teledir;

import java.io.Serializable;

/**
 *
 * @author e1500943
 */
public class Person implements Serializable {
    
    private static final long serialVersionUID=1L;
    private String name, nick, tel;

    public Person(String name, String nick, String tel) {
        this.name = name;
        this.nick = nick;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", nick=" + nick + ", tel=" + tel + '}';
    }
    

}
