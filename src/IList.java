public interface IList<T> {
    public void docFile();
    public void ghiFile();
    // them 1 doi tuong vao cuoi danh sach
    public void add(T obj);
    // lay vi tri cua doi tuong trong danh sach
    public int indexOf(String ma);
    // xoa doi tuong obj
    public void remove(T obj);
}
