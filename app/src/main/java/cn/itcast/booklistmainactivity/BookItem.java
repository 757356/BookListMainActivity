package cn.itcast.booklistmainactivity;

public class BookItem {
    private String name;
    private int cover_resource_id;

    public BookItem( String name, int cover_resource_id ) {
        this.name = name;
        this.cover_resource_id = cover_resource_id;
    }

    public String getTitle() {
        return name;
    }

    public int getCoverResourceId() {
        return cover_resource_id;
    }
}
