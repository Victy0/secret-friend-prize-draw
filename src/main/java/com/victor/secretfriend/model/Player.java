package com.victor.secretfriend.model;

public class Player
{
    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public Player getSecretFriend()
    {
        return this.secretFriend;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setSecretFriend(Player secretFriend)
    {
        this.secretFriend = secretFriend;
    }

    private  String name;

    private  String email;
    
    private  Player secretFriend;    
}
