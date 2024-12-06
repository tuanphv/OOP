package Interface;
public interface IList<T> {
    public void docFile();
    public void ghiFile();
    // them 1 doi tuong vao cuoi danh sach
    public boolean add(T obj);
    // sua doi tuong theo id
    // public void edit(String ma);
    // xoa doi tuong obj
    public void remove(String ma);
    // lay vi tri cua doi tuong trong danh sach
    public int indexOf(String ma);
    // lay doi tuong theo id
    public T get(String ma);
    // kiem tra danh sach rong
    public boolean isEmpty();
    // lay do dai danh sach
    public int size();
}
