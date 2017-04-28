package com.trunko.cms.encrypt;

public class EncryptFactory
{
  public static Encrypt getEncrypt(String type)
  {
    Encrypt ent = null;
    try {
      ent = (Encrypt)Class.forName(type).newInstance();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return ent;
  }
}