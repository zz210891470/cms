package com.trunko.cms.encrypt;

public abstract interface Encrypt
{
  public abstract String encrypt(String paramString)
    throws Exception;

  public abstract String decrypt(String paramString)
    throws Exception;
}