package com.trunko.cms.encrypt;

import java.security.MessageDigest;

public class MD5Encrypt
  implements Encrypt
{
  public String encrypt(String s)
  {
    byte[] btInput;
    try
    {
      btInput = s.getBytes();
      MessageDigest mdInst = MessageDigest.getInstance("MD5");
      mdInst.update(btInput);
      byte[] md = mdInst.digest();
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < md.length; ++i) {
        int val = md[i] & 0xFF;
        if (val < 16)
          sb.append("0");
        sb.append(Integer.toHexString(val));
      }

      return sb.toString(); } catch (Exception e) {
    }
    return null;
  }

  public String decrypt(String s)
  {
    return s;
  }
}