package com.mahao.leshan;

public class TravleItem {
  private   String title;
  private  String address;
  private  String subTitle;
  private  int imagesResource;


    public TravleItem(String title, String address, String subTitle, int imagesResource) {
        this.title = title;
        this.address = address;
        this.subTitle = subTitle;
        this.imagesResource = imagesResource;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public int getImagesResource() {
        return imagesResource;
    }
}
